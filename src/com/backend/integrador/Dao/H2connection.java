package com.backend.integrador.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2connection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        //indicar driver a usar

        Class.forName("org.h2.Driver");

        return DriverManager.getConnection("jdbc:h2:~/parcial","sa","sa");

    }

}
