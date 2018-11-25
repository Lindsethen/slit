/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author matjo
 */
public class ListModuleServlet extends HttpServlet {
        private Connection conn = null;
        private Statement stmt = null;
        private ResultSet rs = null;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListUserServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Alle moduler:</h1>");
            //lager query
        String query = "SELECT m_id, m_name, m_deadline, m_description FROM MODULE WHERE m_published = 1 ORDER BY m_id ASC;";
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
        }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
