package org.example;

import org.example.dbconnect.DbConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Example7 {
    public static void main(String[] args) {



            try {
                Connection con = DbConnection.takeConnection();
                CallableStatement cs = con.prepareCall("{call GetAdditioonalAge(?)}");

                cs.setInt(1, 76);
                cs.registerOutParameter(1, Types.INTEGER);
                cs.executeQuery();

                System.out.println("Record inserted");

                int age = cs.getInt(1);
                System.out.println("age is :"+age);


                con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}