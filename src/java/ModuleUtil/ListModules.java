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
 * @author henlind
 */

public class ListModules {
        private Connection conn = null;
        private Statement stmt = null;
        private ResultSet rs = null;
    public void selectAll(){
    try {
        String query = "SELECT * FROM MODULE;";
        conn = DbUtil.ConnectionManager.getConnection();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);
            
      // iterate through the java resultset
      while (rs.next())
      {
        int id = rs.getInt("u_id");
        String mName = rs.getString("u_firstName");
        String mDesc = rs.getString("u_lastName");
        
        // print the results
        System.out.format("%s, %s, %s\n", id, mName, mDesc);
      }
         stmt.close();
            }
            catch (Exception e)
            {
              System.err.println("Got an exception! ");
              System.err.println(e.getMessage());
            }
  }
}