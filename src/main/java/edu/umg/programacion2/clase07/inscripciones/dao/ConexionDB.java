package edu.umg.programacion2.clase07.inscripciones.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    // Cada miembro del equipo solo modificará esto en su entorno local
    private static final String URL = "jdbc:mariadb://localhost:3306/prog2_db";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "MyfirstBD.W";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
}