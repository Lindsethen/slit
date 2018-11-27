/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LearningUtil;

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
public class EditSpecific extends HttpServlet {
    int goalID;
    String goalName;
    int moduleFK;
    String goalText;
    String idString;
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    String getQuery = null;
    String setQuery = null;
    String moduleName;
    String moduleID;
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
            idString = request.getParameter("GID");
            moduleID = request.getParameter("moduleID");
            getQuery = "SELECT * FROM LEARNINGGOAL, MODULE WHERE m_id = " + moduleID + " and lg_id = " + idString;
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
                moduleName = rs.getString("m_name");
                goalText = rs.getString("lg_string");
                PrintWriter htmlout = response.getWriter();
                htmlout.println("<h3>Registrert som:</h3>");
                htmlout.println("Nummer: " + idString);
                htmlout.println("<br>Modulnavn: " + moduleName);
                htmlout.println("<br>Beskrivelse: " + goalText);
                htmlout.println("<br>Modulnummer: " + moduleID);
                } 
                catch (SQLException ex) {
                out.println("Feil med tilkobling: " + ex); }
            out.println("<form action=\"../../EditGoalServlet\" method=\"post\">");
            out.println("<input type=\"text\" name=\"goalText\" placeholder=\"Beskrivelse\">");
            out.println("<br> <input type=\"text\" name=\"moduleID\" placeholder=\"Modulnummer\">");
            out.println("<input type=\"hidden\" name=\"GID\" value=\"" + idString + "\">");
            out.println("<br> <input type=\"submit\" value=\"ENDRE\"");
            out.println("</body>");
            out.println("</html>");
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
