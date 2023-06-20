package com.backend.clinicaOdontologica.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/clinica-odontologica", "sa", "sa");
    }

   public static Connection crearBd() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/clinica-odontologica;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");
    }
}

