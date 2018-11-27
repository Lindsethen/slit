/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleUtil;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 *
 * @author Ludamac
 */
public class EditSpecificModule extends HttpServlet {
    String moduleID;
    int mID;
    String moduleDescription;
    String moduleDeadline;
    String moduleName;
    String getQuery;
    String published;
    boolean isPublished;
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
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
            moduleID = request.getParameter("MID");
            mID = Integer.parseInt(moduleID);
            getQuery = "SELECT * FROM MODULE WHERE m_id = " + mID + ";";
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditSpecific</title>");            
            out.println("</head>");
            out.println("<body>");
            try  {
                conn = DbUtil.ConnectionManager.getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery(getQuery);
                rs.next();
                moduleDescription = rs.getString("m_description");
                moduleName = rs.getString("m_name");
                moduleDeadline = rs.getString("m_deadline");
                isPublished = rs.getBoolean("m_published");
                    if (isPublished) 
                        { published = "Ja"; } else 
                          { published = "Nei"; }
                    
                PrintWriter htmlout = response.getWriter();
                htmlout.println("<h3>Registrert som:</h3>");
                htmlout.println("Modulnummer: " + moduleID);
                htmlout.println("<br>Modulnavn: " + moduleName);
                htmlout.println("<br>Beskrivelse: " + moduleDescription);
                htmlout.println("<br>Frist: " + moduleDeadline);
                htmlout.println("<br>Publisert: " + published);
                } 
                catch (SQLException ex) {
                    out.println("Feil med tilkobling: " + ex); }
            //form for å submitte endring via http
            out.println("<form action=\"EditModuleServlet\" method=\"post\">");
            out.println("<br> Nytt nummer:");
            out.println("<input type=\"text\" name=\"newNum\" placeholder=\"Nummer\">");
            out.println("<br> Modulnavn:");
            out.println("<input type=\"text\" name=\"nameString\" placeholder=\"Modulnavn\">");
            out.println("<br> Beskrivelse");
            out.println("<input type=\"text\" name=\"descriptionString\" placeholder=\"Beskrivelse\">");
            out.println("<br> Frist");
            out.println("<input type=\"text\" name=\"deadlineString\" placeholder=\"Frist\">");
            out.println("<br> <b>Publiser:</b>");
            out.println("<br><b>Ja</b><input type=\"radio\" name=\"published\" value=\"1\">");
            out.println("<br><b>Nei</b><input type=\"radio\" name=\"published\" value=\"0\">");
            out.println("<input type=\"hidden\" name=\"MID\" value=\"" + mID + "\">");
            out.println("<input type=\"submit\" value=\"ENDRE\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            //moduleString = request.getParameter("moduleString");
           // descriptionString = request.getParameter("descriptionString");
           // deadlineString = request.getParameter("deadlineString");
           // nameString = request.getParameter("nameString");
          //  ModuleID = Integer.parseInt("ModuleID");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
