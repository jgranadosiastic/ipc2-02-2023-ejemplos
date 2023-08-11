/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jdbc.mysql;

import java.sql.Connection;
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
public class EjemploConeccionMysql {

    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/control_cursos";
    private static final String USER = "rootdba";
    private static final String PASSWORD = "12345";

    private Connection connection;

    public EjemploConeccionMysql() {
        Scanner scanner = new Scanner(System.in);
        try {
            connection = DriverManager.getConnection(URL_MYSQL, USER, PASSWORD);
            System.out.println("Esquema desde connection" + connection.getSchema());
            System.out.println("Esquema desde connection" + connection.isClosed());
/*
            System.out.println("Escriba carner:");
            String carnet = scanner.nextLine();

            System.out.println("Escriba nombre:");
            String nombre = scanner.nextLine();

            System.out.println("Escriba apellidos:");
            String apellidos = scanner.nextLine();

            System.out.println("Escriba fecha nacimiento:");
            String fecha = scanner.nextLine();

            connection.setAutoCommit(false);
            Statement updateStatement = connection.createStatement();
            updateStatement.executeUpdate("update estudiante SET nombre = 'zzzzzzzz' where carnet = '200413171'");

            Statement insertStatement = connection.createStatement();
            int result = insertStatement.executeUpdate(
                    "insert into estudiante  values ('" + carnet + "','" + nombre + "', '" + apellidos + "', '" + fecha + "')");
            System.out.println("rows affected> " + result);

            connection.commit();*/
            
            // Inyeccion de SQL
            /*System.out.println("Escriba el carnet a buscar:");
            String carnet = scanner.nextLine();
            Statement query = connection.createStatement();
            ResultSet resultQuery = query.executeQuery("select * from estudiante where carnet ='" + carnet + "'");*/
            
            System.out.println("Escriba el carnet a buscar:");
            String carnet = scanner.nextLine();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from estudiante where carnet = ?");
            preparedStatement.setString(1, carnet);
            
            ResultSet resultQuery = preparedStatement.executeQuery();
            
            while (resultQuery.next()) {
                System.out.println("Datos Estudiante");
                System.out.println("Carnet: " + resultQuery.getString("carnet"));
                System.out.println("Nombre: " + resultQuery.getString("nombre"));
                System.out.println("Apellidos: " + resultQuery.getString("apellidos"));
                System.out.println("fecha nacimiento: " + resultQuery.getDate("fecha_nacimiento").toLocalDate());
            }

        } catch (SQLException e) {
            // manejamos la excepcion al momento de crear la connexion
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println("error en rollback");
            }
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    // manejariamos excepcion
                }
            }
        }

    }
}
