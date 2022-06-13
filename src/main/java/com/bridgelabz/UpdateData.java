package com.bridgelabz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {
        public static void main(String[] args)  {
            String query = "update employee_payroll set salary=30000 where name='bill'";
            Connection connection = null;
            Statement statement = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Driver class loaded and registered");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service? user=root & password=root");
                System.out.println("Connection established with db server");
                statement = connection.createStatement();
                System.out.println("platform created/Statement object created");
                statement.executeUpdate(query);
                System.out.println("Data updated to DB");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }

