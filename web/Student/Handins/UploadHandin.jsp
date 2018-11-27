<%--
    Document   : UploadHandin
    Created on : 26.nov.2018, 12:31:12
    Author     : Henrik
--%>



<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <style>
.jumbotron{
    background-color:#7C01BA;
    color:purple;
}
/* Adds borders for tabs */
.tab-content {
    border-left: 1px solid #ddd;
    border-right: 1px solid #ddd;
    border-bottom: 1px solid #ddd;
    padding: 10px;
}
.nav-tabs {
    margin-bottom: 0;
}
</style>

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

        <div class="container">
        <h1>Filopplastning for modul</h1>
        </div>

        <div class="jumbotron">
            <div class="container">
        <form method="post" action="../../UploadHandin" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>Student: </td>
                    <td><input type="text-white" name="studentName" size="50"/></td>
                </tr>
                <tr>
                    <td>Modul: </td>
                    <td><input type="text" name="moduleNumber" size="50"/></td>
                </tr>
                <tr>
                    <td>Opplastning: </td>
                    <td><input type="file" name="handinHere" size="50"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Last opp">
                    </td>
                </tr>
            </table>
        </form>
                <a href="../index.jsp" class="text-black">Tilbake til forsiden</a>

        <form action="../../LogoutServlet">

              <input type="submit" value="Logg ut">

        </form>
            </div>
        </div>
    </center>
</body>

  <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>
