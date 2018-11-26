/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LearningUtil;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

/**
 *
 * @author matjo
 */
public class DeleteGoals {
String targetGoal = null;

    public static void deleteGoal(String goalNo) {
        Connection conn;
        Statement stmt;
        String targetGoal = goalNo;

        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
//        try {
//            conn = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/slit", "slit", "verystrong");
//
 //
 //       }
  //      catch (SQLException ex) {
   //         System.out.println("Error: " + ex);
    //    }
        //commence the deletion
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/slit", "slit", "verystrong");
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM USER WHERE lg_id LIKE " + targetGoal);
        }
        catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

}
