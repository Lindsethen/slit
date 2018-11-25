<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>File Uploader Example</title>
  </head>
   <body>
     <center>
    <form method="post" action="FileUploadServlet" enctype="multipart/form-data">
    Velg hvilken fil du skal laste opp:
    <input type="file" name="uploadFile" />
    <br/><br/>
    <input type="submit" value="Last opp" />
    </form>
    <h5>${message}</h5>
    </center>
  </body>
</html>