package com.bridgelabz;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class DatabaseConectivity {

        public static void main(String[] args)  {
            Connection connection = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Driver class loaded and registered");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service? user=root & password=root");
                System.out.println("Connection established with dbserver");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }

