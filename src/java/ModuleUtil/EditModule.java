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
    int number;
    String sqlQuery;
    String newName;
    String newDescription;
    String newDeadline;
    int moduleID;
    boolean isPublished;
   
    public void changeID(int newNum, int mID){
        number = newNum;
        moduleID = mID;
        
        sqlQuery = "UPDATE MODULE SET m_id = " + number + " WHERE m_id = " + moduleID + ";";
        try {
            conn = DbUtil.ConnectionManager.getConnection();
            stmt = conn.createStatement();
            //sender query til MYSQL
            stmt.executeUpdate(sqlQuery);
            stmt.close();
        }
            catch (Exception ex) {
                System.out.println("Noe gikk galt:");
                System.out.println(ex);
            }
        }
    
    public void changeName(String nameString, int mID){
        
        newName = nameString;
        moduleID = mID;
        sqlQuery = "UPDATE MODULE SET m_name = " + "\"" +  newName + "\"" + " WHERE m_id = " + moduleID + ";";
        try {
        conn = DbUtil.ConnectionManager.getConnection();
        stmt = conn.createStatement();
        //sender query til MYSQL
        stmt.executeUpdate(sqlQuery);
        stmt.close();
    }
        catch (Exception ex) {
            System.out.println("Noe gikk galt:");
            System.out.println(ex);
        }
        
    }
    public void changeDescription(String descriptionString, int mID){
        newDescription = descriptionString;
        moduleID = mID;
        sqlQuery = "UPDATE MODULE SET m_description = " + "\"" + newDescription + "\"" + " WHERE m_id = " + moduleID + ";";
        try {
        conn = DbUtil.ConnectionManager.getConnection();
        stmt = conn.createStatement();
        //sender query til MYSQL
        stmt.executeUpdate(sqlQuery);
        stmt.close();
    }
        catch (Exception ex) {
            System.out.println("Noe gikk galt:");
            System.out.println(ex);
        }
    }
    public void changeDeadline(String deadlineString, int mID){
        newDeadline = deadlineString;
        moduleID = mID;
        sqlQuery = "UPDATE MODULE SET m_deadline = " + "'" + newDeadline + "'" + " WHERE m_id = " + moduleID + ";";
        try {
        conn = DbUtil.ConnectionManager.getConnection();
        stmt = conn.createStatement();
        //sender query til MYSQL
        stmt.executeUpdate(sqlQuery);
        stmt.close();
    }
        catch (Exception ex) {
            System.out.println("Noe gikk galt:");
            System.out.println(ex);
        }
    }
    public void changePublished(boolean published, int mID){
        moduleID = mID;
        isPublished = published;
        sqlQuery = "UPDATE MODULE SET m_published = " + isPublished + " WHERE m_id = " + moduleID + ";";
        try {
        conn = DbUtil.ConnectionManager.getConnection();
        stmt = conn.createStatement();
        //sender query til MYSQL
        stmt.executeUpdate(sqlQuery);
        stmt.close();
    }
        catch (Exception ex) {
            System.out.println("Noe gikk galt:");
            System.out.println(ex);
        }
    }
    }

