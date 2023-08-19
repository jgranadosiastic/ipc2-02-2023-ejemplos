/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jsp.app.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author jose
 */
public class DBEstudiante {

    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/control_cursos";
    private static final String USER = "rootdba";
    private static final String PASSWORD = "12345";

    private static final String INSERT = "INSERT INTO estudiante (carnet, nombre, apellidos, fecha_nacimiento) VALUES (?, ?, ?, ?)";

    private Connection connection;

    public DBEstudiante() throws ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL_MYSQL, USER, PASSWORD);

        } catch (SQLException e) {
            // manejamos la excepcion al momento de crear la connexion
            e.printStackTrace();
        }

    }

    public boolean crearEstudiante(Estudiante estudiante) {
        try {
            PreparedStatement insert = connection.prepareStatement(INSERT);
            insert.setString(1, estudiante.getCarnet());
            insert.setString(2, estudiante.getNombre());
            insert.setString(3, estudiante.getApellidos());
            insert.setDate(4, Date.valueOf(estudiante.getFechaNacimiento()));

            insert.executeUpdate();
        } catch (SQLException ex) {
            // TODO pendiente manejo
            ex.printStackTrace();
        }

        return true;
    }
}
