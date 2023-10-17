/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.app_agular_api.app.db;

import com.jgranados.app_agular_api.app.exceptions.InvalidDataException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author jose
 */
public class DBEstudiante {

    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/control_cursos";
    private static final String USER = "rootdba";
    private static final String PASSWORD = "12345";

    private static final String INSERT = "INSERT INTO estudiante (carnet, nombre, apellidos, fecha_nacimiento) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM estudiante";
    private static final String SELECT_BY_CARNET = "SELECT * FROM estudiante WHERE carnet = ?";

    private Connection connection;

    public DBEstudiante() {
        Scanner scanner = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL_MYSQL, USER, PASSWORD);

        } catch (SQLException e) {
            // manejamos la excepcion al momento de crear la connexion
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    public Estudiante crearEstudiante(Estudiante estudiante) throws InvalidDataException {

        validar(estudiante);
// Create Read Update Delete
        try {
            PreparedStatement insert = connection.prepareStatement(INSERT);
            insert.setString(1, estudiante.getCarnet());
            insert.setString(2, estudiante.getNombre());
            insert.setString(3, estudiante.getApellidos());
            insert.setDate(4, Date.valueOf(estudiante.getFechaNacimiento()));

            insert.executeUpdate();

            return estudiante;
        } catch (SQLException ex) {
            // TODO pendiente manejo
            ex.printStackTrace();
        }

        return null;
    }

    public List<Estudiante> getAll() {
        try {
            PreparedStatement select = connection.prepareStatement(SELECT_ALL);

            List<Estudiante> estudiantes = new ArrayList<>();
            ResultSet resultset = select.executeQuery();
            while (resultset.next()) {
                estudiantes.add(new Estudiante(resultset.getString("carnet"),
                        resultset.getString("nombre"),
                        resultset.getString("apellidos"),
                        resultset.getDate("fecha_nacimiento").toLocalDate())
                );
            }
            return estudiantes;
        } catch (SQLException ex) {
            // TODO pendiente manejo
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public Optional<Estudiante> getStudentByCarnet(String carnet) {
        // validateCarnet not null
        try {
            PreparedStatement select = connection.prepareStatement(SELECT_BY_CARNET);
            select.setString(1, carnet);
            ResultSet resultset = select.executeQuery();
            
            if (resultset.next()) {
                return Optional.of(new Estudiante(resultset.getString("carnet"),
                        resultset.getString("nombre"),
                        resultset.getString("apellidos"),
                        resultset.getDate("fecha_nacimiento").toLocalDate()));
            }
            
            return Optional.empty();
        } catch (SQLException ex) {
            // TODO pendiente manejo
            ex.printStackTrace();
        }
        
        return Optional.empty();
    }

    private void validar(Estudiante estudiante) throws InvalidDataException {
        if (StringUtils.isEmpty(estudiante.getCarnet()) ||
                StringUtils.isBlank(estudiante.getCarnet())) {
            throw new InvalidDataException("El carnet del estudiante es requerido.");
        }

        if (estudiante.getCarnet().length() > 10) {
            throw new InvalidDataException("El carnet no debe de tener mas de 10 caracteres.");
        }
    }
}
