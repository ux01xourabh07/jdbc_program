package org.example;

import org.example.dbconnect.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Example3 {
    public static void main(String[] args) {


        try{
           Connection con = DbConnection.takeConnection();
            //3.Create statment object
            String query = "select * from person";
            Statement st = con.createStatement();
           //4. Query Execution
           ResultSet rs = st.executeQuery(query);
            System.out.println("successfully ho gaya");

            while (rs.next()){
                System.out.print(rs.getString(1)+"\t");
                System.out.print(rs.getString(2)+"\t");
                System.out.print(rs.getString(3)+"\t");
                System.out.print(rs.getString(4)+"\t");
                System.out.println();

            }
            //5. close connections
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}