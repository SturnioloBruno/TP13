/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clasetp13;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author br1st
 */
public class ClaseTP13 {

    public static void main(String[] args) {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            String URL = "jdbc:mariadb://localhost:3306/universidad";
            String USUARIO = "root";
            String PASSWORD = "mysql";
            Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            
           // Crear una declaración SQL
            Statement statement = con.createStatement();

            // SQL para crear la tabla "alumnos"
            String createTableSQL = "CREATE TABLE IF NOT EXISTS alumnos (" +
                    "dni INT PRIMARY KEY," +
                    "apellido VARCHAR(255)," +
                    "nombre VARCHAR(255)," +
                    "fechaNacimiento DATE," +
                    "estado BOOLEAN" +
                    ");";

            // Ejecutar la instrucción SQL para crear la tabla
            statement.executeUpdate(createTableSQL);
            
            // Agregar un alumno
            String sql = "INSERT INTO alumnos (dni, apellido,nombre,fechaNacimiento,estado)"
                    + "values (1234,'Lopez','Maria','2000-10-25',true)";
            
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            // insert, update, delete
            int filas = preparedStatement.executeUpdate();
            if(filas > 0){
                JOptionPane.showMessageDialog(null, "Alumno Agregado");
            }
            System.out.println("Exito");
            
        }catch(ClassNotFoundException cnf){
            JOptionPane.showMessageDialog(null, "Error al cargar el driver");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la BD");
        }
    }
}
