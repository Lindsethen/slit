/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleUtil;

import java.sql.*;

/**
 *
 * @author ludamac
 */
public class EditModule {
    private Connection conn = null;
    private Statement stmt = null;
    String newModule;
    String sqlQuery;
    int ModuleID;
   
    public void changeModule(String ModuleString, int ModuleID){
    
    newModule = ModuleString;
    ModuleID = this.ModuleID;
    sqlQuery = "UPDATE MODULE SET Module = " + newModule + " WHERE m_id" + ModuleID;
    try {
        conn = DbUtil.ConnectionManager.getConnection();
        stmt = conn.createStatement();
        //sender query til MYSQL
        stmt.executeUpdate(sqlQuery);
    }
        catch (Exception ex) {
            System.out.println("Noe gikk galt:");
            System.out.println(ex);
        }
    }
}
