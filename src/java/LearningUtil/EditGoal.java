/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LearningUtil;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author henlind
 */
public class EditGoal {
        
    
    private Connection conn = null;
    private Statement stmt = null;
    String newLearning;
    String sqlQuery;
    int lg_id;
   
    public void changeGoal(String lg_string, int lg_id){
    
    newLearning = lg_string;
    lg_id = this.lg_id;
    sqlQuery = "UPDATE MODULE SET Module = " + newLearning + " WHERE lg_id" + lg_id;
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

