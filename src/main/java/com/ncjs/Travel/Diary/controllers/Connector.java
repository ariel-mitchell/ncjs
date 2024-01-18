package com.ncjs.Travel.Diary.controllers;

import java.io.IOException;
//import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.*;

public class Connector {

    public Connection con;
    private final String URL = "jdbc:mysql://localhost:8080/traveldiary";
    private final String USERNAME = "traveldiary";
    private final String PASSWORD = "traveldiary";

    /* Add DB Connection */
    public void add() {
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException se) {
            se.printStackTrace();
        }

    }
}
