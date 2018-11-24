/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserUtil;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author matjo
 */
public class ListUsers {
        private Connection conn = null;
        private Statement stmt = null;
        private ResultSet rs = null;
    public void selectAll(){
    try {
        String query = "SELECT * FROM USER;";
        conn = DbUtil.ConnectionManager.getConnection();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);
            
      // iterate through the java resultset
      while (rs.next())
      {
        int id = rs.getInt("u_id");
        String firstName = rs.getString("u_firstName");
        String lastName = rs.getString("u_lastName");
        String uEmail = rs.getString("u_email");
        String uRole = rs.getString("u_role");
        
        // print the results
        System.out.format("%s, %s, %s, %s, %s\n", id, firstName, lastName, uEmail, uRole);
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
    

