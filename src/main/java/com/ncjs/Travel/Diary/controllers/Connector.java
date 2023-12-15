package com.ncjs.Travel.Diary.controllers;

import java.io.IOException;
//import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.*;

public class Connector {

    public Connection con;
    private final String URL = "jdbc:mysql://localhost:8800/dbname";
    private final String USERNAME = "username";
    private final String PASSWORD = "password";

    /* Add DB Connection */
    public void add() {
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException se) {
            se.printStackTrace();
        }

    }
}
