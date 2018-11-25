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
    <form method="post" action="FileUploadServlet"
        enctype="multipart/form-data">
        Velg hvilken fil du skal laste opp: <input type="file" name="file" size="60" /><br />
        <br /> <input type="submit" value="Last opp" />
    </form>
    <%{ 
    
        }%>
</center>
</body>
</html>