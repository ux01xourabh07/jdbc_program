package org.example;

import org.example.dbconnect.DbConnection;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Example2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter your name: ");
        String name = sc.nextLine();
        System.out.print("enter your location: ");
        String location = sc.nextLine();
        System.out.println("enter your age");
        int age = sc.nextInt();



        try{
           Connection con = DbConnection.takeConnection();
            //3.Create statment object
            String query = "insert into person value(102,'"+name+"', '"+location+"','"+age+"' )";
            Statement st = con.createStatement();
           //4. Query Execution
            st.execute(query);
            System.out.println("successfully ho gaya");
            //5. close connections
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}