/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LearningUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author henlind
 */
@WebServlet(name = "ListGoalServlet", urlPatterns = {"/ListGoalServlet"})
public class ListGoalServlet extends HttpServlet {
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
            out.println("<title>Servlet ListGoalServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("<h1> Alle læremål: </h1>");
            //lager query
            String query = "SELECT * LEARNINGGOAL ORDER BY lg_id ASC;";
        //connect til db
        conn = DbUtil.ConnectionManager.getConnection();
        stmt = conn.createStatement();
        //executer query
        rs = stmt.executeQuery(query);

        // itererer gjennom hele listen (resultset rs)
        while (rs.next())
      {
        //lager ny printer med navn sqlWriter og skriver ut i HTML format
        PrintWriter sqlWriter = response.getWriter();
        //hvilke columns som skal kalles hva (SQL -> Java)
        int id = rs.getInt("lg_id");
        String lgName = rs.getString("lg_name");
        String lgString = rs.getString("lg_string");
        // kjøres for hver row med følgende format:
        sqlWriter.format("<h3>ID: %s</h3> <h5>Name: %s</h5>  Desc: %s </br>", id, lgName, lgString);
        sqlWriter.format("<br><form method=\"post\" action=\"DeleteGoalsServlet?GID=" + id +"\">");
        sqlWriter.println("<input type=\"submit\" value=\"SLETT LÆRERMÅL\">");
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

    /**
     * Handles the HTTP <code>POST</code> method.
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
