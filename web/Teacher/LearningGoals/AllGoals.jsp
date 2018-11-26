<%-- 
    Document   : AllModules
    Created on : 26-Nov-2018, 15:18:03
    Author     : Ludamac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection,DbUtil.ConnectionManager,java.sql.Statement,java.sql.ResultSet,java.io.IOException,java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alle læremål</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% 
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM LEARNINGGOAL ORDER BY lg_id ASC;";
        //connect til db
    try {
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
          int id = rs.getInt("lg_id");
          //String lgName = rs.getString("lg_name");
          String lgString = rs.getString("lg_string");
          // kjøres for hver row med følgende format:
          sqlWriter.format("<li>Number:%s </br> Description: %s", id, lgString);
          sqlWriter.format("<br><form method=\"post\" action=\"DeleteGoalsServlet?UID=" + id +"\">");
          sqlWriter.println("<input type=\"submit\" value=\"SLETT LÆREMÅL\">");
          sqlWriter.println("</form>");
        }
         //lukker tilkoblingen
         stmt.close();
        
        //henter og sender feilmeldinger
    }
            catch (Exception e)
            {
              System.err.println("Got an exception!");
              System.err.println(e.getMessage());
            }
            %>
            </ul>
    
    </body>
</html>
