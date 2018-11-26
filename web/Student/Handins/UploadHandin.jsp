<%-- 
    Document   : UploadHandin
    Created on : 26.nov.2018, 12:31:12
    Author     : Henrik
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//DELIVER HAND-IN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload to Database example</title>
</head>
<body>
    <center>
        <h1>File Upload to Database example</h1>
        <form method="post" action="../../uploadServlet" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>Student: </td>
                    <td><input type="text" name="studentName" size="50"/></td>
                </tr>
                <tr>
                    <td>Module: </td>
                    <td><input type="text" name="moduleNumber" size="50"/></td>
                </tr>
                <tr>
                    <td>:Upload </td>
                    <td><input type="file" name="handinHere" size="50"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save">
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>