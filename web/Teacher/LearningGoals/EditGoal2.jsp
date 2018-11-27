<%-- 
    Document   : EditGoal2
    Created on : 27.nov.2018, 11:43:28
    Author     : Marius
--%>
<%@page import="java.sql.Connection,DbUtil.ConnectionManager,java.sql.Statement,java.sql.ResultSet,java.io.IOException,java.io.PrintWriter, java.sql.SQLException" %>
<%  int goalID;
    String goalName;
    int moduleFK;
    String goalText;
    String idString;
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    String getQuery = null;
    String setQuery = null;
%>

<% 
PrintWriter error = response.getWriter();
try {
    conn = DbUtil.ConnectionManager.getConnection();
    stmt = conn.createStatement();
        } catch (Exception ex) { 
            error.println("Feil: " + ex); }
        
    goalName = request.getParameter("nameString");
    goalText = request.getParameter("goalString");
    idString = request.getParameter("GID");
    goalID = Integer.parseInt("goalString");
    
    PrintWriter htmlout = response.getWriter();
    htmlout.println("Current data:");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
