package org.example.dbconnect;

import java.sql.*;

public class DbConnection {

    public static Connection takeConnection(){
        Connection con = null;
        try{
            //1.register driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2.Create connection object
            String path = "jdbc:mysql://localhost:3306/dbs";
            String username = "root";
            String password = "sourabh";
            con = DriverManager.getConnection(path,username,password);

            if(con!=null){
                System.out.println("connection maded");
            }
            else {
                System.out.println("connection not maded");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }


}
