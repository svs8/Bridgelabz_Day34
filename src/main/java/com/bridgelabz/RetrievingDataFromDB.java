package com.bridgelabz;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.*;


public class RetrievingDataFromDB {

    private static List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    public static void main(String[] args) {


        String query = "select * from employee_payroll";
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver class loaded and registered");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service? user=root & password=root");
            System.out.println("Connection established with db server");
            statement = connection.createStatement();
            System.out.println("platform created/Statement Object Created");
            ResultSet resultset=statement.executeQuery(query);
            System.out.println("Data selected from DB");
            while(resultset.next()){
                int id=resultset.getInt("id");
                String name=resultset.getString("name");
                double salary=resultset.getDouble("salary");
                employeePayrollList.add(new EmployeePayrollData(id,name,salary));
            }
            System.out.println(employeePayrollList);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
