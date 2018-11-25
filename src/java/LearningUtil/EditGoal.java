/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LearningUtil;
import java.sql.*;

/**
 *
 * @author Ludamac
 */
public class EditGoal {
        private Connection conn = null;
        private Statement stmt = null;
        String newName;
        String newString;
        String sqlQuery;
        int goalID;

public void changeGoalname(String nameString, int goalID){
    newName = nameString;
    goalID = this.goalID;
    sqlQuery = "UPDATE LEARNINGGOAL SET lg_name = " + newName + "WHERE lg_id = " + goalID;
    try{
        conn = DbUtil.ConnectionManager.getConnection();
        stmt = conn.createStatement();
        stmt.executeUpdate(sqlQuery);
    }
    catch (SQLException ex){
        System.out.println("Det er noe som ikke stemmer her :(");
        System.out.println(ex);
    }
}
public void changeGoalstring(String stringString, int goalID){
    newString = stringString;
    goalID = this.goalID;
    sqlQuery = "UPDATE LEARNINGGOAL SET lg_string = " + newString + "WHERE lg_id = " + goalID;
    try{
        conn = DbUtil.ConnectionManager.getConnection();
        stmt = conn.createStatement();
        stmt.executeUpdate(sqlQuery);
    }
    catch (SQLException ex){
        System.out.println("Det er noe som ikke stemmer her :(");
        System.out.println(ex);
    }
}

}
