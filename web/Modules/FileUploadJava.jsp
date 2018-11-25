<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload</title>
</head>
<body>
<center>
    <h1>Filopplastning</h1>
    <form method="post" action="UploadServlet"
        enctype="multipart/form-data">
        Velg hvilken fil du skal laste opp: <input type="file" name="file" size="60" /><br />
        <br /> <input type="submit" value="Last opp" />
    </form>
    <%try {
            String connectionURL = "jdbc:mysql://host/db";
            Connection connection = null; 
            Class.forName("com.mysql.jdbc.Driver").newInstance(); 
            connection = DriverManager.getConnection(connectionURL, "username", "password");
            if(!connection.isClosed())
                 out.println("Successfully connected to " + "MySQL server using TCP/IP...");
            connection.close();
        }catch(Exception ex){
            out.println("Unable to connect to database"+ex);
        }   
    %>
</center>
</body>
</html>