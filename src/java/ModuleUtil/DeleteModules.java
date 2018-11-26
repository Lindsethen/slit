/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author matjo
 * Kristian prøver seg fram LUL
 */
public class DeleteModules {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    int ModuleID;

    
    
    public void deleteID(int ID){
        //SQL Query
        ModuleID = ID;
        String sqlQuery = "DELETE FROM MODULE WHERE m_id = " + ModuleID;
        
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
