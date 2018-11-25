/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserUtil;
import java.sql.*;

/**
 *
 * @author matjo
 */
public class EditUser {
    private Connection conn = null;
    private Statement stmt = null;
    String newEmail;
    String sqlQuery;
    int userID;
    
public void changeEmail(String mailString, int userID){
    
    newEmail = mailString;
    userID = this.userID;
    sqlQuery = "UPDATE USER SET u_email = " + newEmail + " WHERE u_id = " + userID;
    try {
            conn = DbUtil.ConnectionManager.getConnection();
            stmt = conn.createStatement();
            //Sender query til MySQL
            stmt.executeUpdate(sqlQuery);
            }
            catch (SQLException ex) {
                System.out.println("Noe gikk galt:");
                System.out.println(ex);
            }


}


}
