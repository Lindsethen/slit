/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author matjo
 */
public class DeleteUsers {
    //trengs for å initiate connection
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    int userID;

    /**
     *
     * @param ID
     */
    public void deleteID(int ID){
            //SQL Query
            int userID = ID;
            String sqlQuery = "DELETE FROM USER WHERE u_id = " + userID;
            
            //Connecting using DbUtil.ConnectionManager
            try {
            conn = DbUtil.ConnectionManager.getConnection();
            stmt = conn.createStatement();
            //Sender query til MySQL
            stmt.executeUpdate(sqlQuery);
            }
            catch (Exception ex) {
                System.out.println("Noe gikk feil:");
                System.out.println(ex);
            }
        }
}
