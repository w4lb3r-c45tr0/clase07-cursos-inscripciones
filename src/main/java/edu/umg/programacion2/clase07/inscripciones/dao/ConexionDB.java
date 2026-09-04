package edu.umg.programacion2.clase07.inscripciones.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionDB {

    public static Connection obtenerConexion() throws SQLException {
        Properties props = new Properties();

        // Lee el archivo database.properties desde la carpeta de recursos (classpath)
        try (InputStream input = ConexionDB.class.getClassLoader().getResourceAsStream("database.properties")) {
            if (input == null) {
                throw new SQLException("No se encontró el archivo 'database.properties' en el classpath.");
            }
            props.load(input);
        } catch (IOException e) {
            throw new SQLException("Error al leer la configuración de la base de datos.", e);
        }

        return DriverManager.getConnection(
            props.getProperty("db.url"),
            props.getProperty("db.usuario"),
            props.getProperty("db.password")
        );
    }
}