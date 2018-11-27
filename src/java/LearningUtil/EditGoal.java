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
        String newText;
        String sqlQuery;
        int gID;
        int mID;

    public void changeModule(int moduleID, int goalID){
        mID = moduleID;
        gID = goalID;
        sqlQuery = "UPDATE LEARNINGGOAL SET fk_m_id = " + mID + " WHERE lg_id = " + gID + ";";
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
    public void changeGoaltext(String goalText, int goalID){
        //newText = goalText;
        gID = goalID;
        sqlQuery = "UPDATE LEARNINGGOAL SET lg_string = \"" + goalText + "\" WHERE lg_id = " + gID + ";";
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
