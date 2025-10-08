package org.example;

import org.example.dbconnect.DbConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Example5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter your name: ");
        String name = sc.nextLine();
        System.out.print("enter your location: ");
        String location = sc.nextLine();
        System.out.println("enter your age");
        int age = sc.nextInt();




            try {
                Connection con = DbConnection.takeConnection();
                CallableStatement cs = con.prepareCall("{call insertPerson(?,?,?)}");
                cs.setString(1,name);
                cs.setString(2,location);
                cs.setInt(3,age);
                cs.execute();

                System.out.println("Record inserted");
                con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}