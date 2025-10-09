package org.example;

import org.example.dbconnect.DbConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Example6 {
    public static void main(String[] args) {



            try {
                Connection con = DbConnection.takeConnection();
                CallableStatement cs = con.prepareCall("{call GetRecode(?,?)}");

                cs.setInt(1, 80);
                cs.registerOutParameter(2, Types.VARCHAR);
                ResultSet rs =  cs.executeQuery();

                System.out.println("Record inserted");

                String name = cs.getString(2);
                System.out.println(name);


                con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}