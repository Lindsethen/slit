<%-- 
    Document   : AllModules
    Created on : 26-Nov-2018, 10:37:53
    Author     : matjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection,DbUtil.ConnectionManager,java.sql.Statement,java.sql.ResultSet,java.io.IOException,java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alle moduler</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query = "SELECT m_id, m_name, m_deadline, m_description FROM MODULE WHERE m_published = 1 ORDER BY m_id ASC;";
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
          int id = rs.getInt("m_id");
          String mName = rs.getString("m_name");
          String mDesc = rs.getString("m_description");
          String mDeadline = rs.getString("m_deadline");
          // kjøres for hver row med følgende format:
          sqlWriter.format("<li>Number:%s Name: %s</br> Description: %s <br> Deadline: %s", id, mName, mDesc, mDeadline);
          sqlWriter.format("<br><form method=\"post\" action=\"DeleteModuleServlet?UID=" + id +"\">");
          sqlWriter.println("<input type=\"submit\" value=\"SLETT MODUL\">");
          sqlWriter.println("</form>");
        }
    
      //lukker tilkoblingen
         stmt.close();
             //henter og sender feilmeldinger. Foreløpig går de kun til console i IDE
    }
            catch (Exception e)
            {
              System.err.println("Det oppstod en feil! ");
              System.err.println(e.getMessage());
            }
            %>
            </ul>
           
    </body>
</html>
