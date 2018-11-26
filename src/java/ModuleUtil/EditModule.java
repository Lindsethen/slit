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
    String newName;
    String newDescription;
    String newDeadline;
    int ModuleID;
   
    public void changeModule(String moduleString, int ModuleID){
    
    newModule = moduleString;
    ModuleID = this.ModuleID;
    sqlQuery = "UPDATE MODULE SET m_id = " + newModule + " WHERE m_id" + ModuleID;
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
    
    public void changeName(String nameString, int ModuleID){
        
        newName = nameString;
        ModuleID = this.ModuleID;
        sqlQuery = "UPDATE MODULE SET m_name = " + newName + " WHERE m_name" + ModuleID;
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
    public void changeDescription(String descriptionString, int ModuleID){
        newDescription = descriptionString;
        ModuleID = this.ModuleID;
        sqlQuery = "UPDATE MODULE SET m_description = " + newDescription + "WHERE m_description" + ModuleID;
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
    public void changeDeadline(String deadlineString, int ModuleID){
        newDeadline = deadlineString;
        ModuleID = this.ModuleID;
        sqlQuery = "UPDATE MODULE SET m_deadline = " + newDeadline + "WHERE m_deadline" + ModuleID;
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

