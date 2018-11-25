/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LearningUtil;
import DbUtil.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author henlind
 */
public class ListGoals {
private Connection conn = null;
        private Statement stmt = null;
        private ResultSet rs = null;
    public void selectAll(){
    try {
        String query = "SELECT * FROM LEARNING;";
        conn = DbUtil.ConnectionManager.getConnection();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);
            
      // iterate through the java resultset
      while (rs.next())
      {
        int id = rs.getInt("g_ID");
        String g_Name = rs.getString("g_Name");
        String g_Desc = rs.getString("g_desc");
        
        // print the results
        System.out.format("%s, %s, %s\n", id, g_Name, g_Desc);
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