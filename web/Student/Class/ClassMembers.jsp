<%-- 
    Document   : ClassMembers
    Created on : 26-Nov-2018, 20:17:00
    Author     : matjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection,DbUtil.ConnectionManager,java.sql.Statement,java.sql.ResultSet,java.io.IOException,java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Klassemedlemmer</title>
    </head>
    <body>
        <%
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListUserServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>All users:</h1>");
            //lager query
        String query = "SELECT * FROM USER ORDER BY u_lname DESC;";
        //connect til db
        conn = DbUtil.ConnectionManager.getConnection();
        stmt = conn.createStatement();
        //executer query
        rs = stmt.executeQuery(query);

      // itererer gjennom hele listen (resultset rs)
            out.println("<ul>");
      while (rs.next())
      {
          //lager ny printer med navn sqlWriter og skriver ut i HTML format
        PrintWriter sqlWriter = response.getWriter();
        //hvilke columns som skal kalles hva (SQL -> Java)
        int id = rs.getInt("u_id");
        String firstName = rs.getString("u_fname");
        String lastName = rs.getString("u_lname");
        String uEmail = rs.getString("u_email");
        String uRole = rs.getString("u_role");
        // kjøres for hver row med følgende format:
        sqlWriter.format("<li>ID:%s</br> Role: %s <br> Name: %s %s <br>Email:%s", id, uRole, firstName, lastName, uEmail);
      }
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
      //lukker tilkoblingen
         stmt.close();
            } //henter og sender feilmeldinger. Foreløpig går de kun til console i IDE
            catch (Exception e)
            {
              System.err.println("Got an exception! ");
              System.err.println(e.getMessage());
            }
        %>
        
        <h4>
    <a href="../../index.jsp">Back to index</a>
    </h4>
    </body>
</html>
