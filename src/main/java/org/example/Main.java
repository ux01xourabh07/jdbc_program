package org.example;
import java.sql.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection con;
        try{
            //1.register driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2.Create connection object
            String path = "jdbc:mysql://localhost:3306/company";
            String username = "root";
            String password = "sourabh";
            con = DriverManager.getConnection(path,username,password);

            if(con!=null){
                System.out.println("connection maded");
            }
            else {
                System.out.println("connection not maded");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}