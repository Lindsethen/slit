/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HandinUtil;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Ludamac
 */
@WebServlet(name = "ListHandins", urlPatterns = {"/Teacher/Handins/ListHandins"})
public class ListHandins extends HttpServlet {
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
String handinText;
String dateDelivered;
String moduleName;
String userName;
String sqlQuery;
String fName;
String lName;
boolean hiApproved;
String isApproved;
int hiPoints;
int hiId;

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
            out.println("<title>Servlet ListHandins</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListHandins at " + request.getContextPath() + "</h1>");
            try {
                sqlQuery = "SELECT hi_id, u_fname, u_lname, m_name, hi_date, hi_approved, hi_comment, hi_points FROM user, handin, module WHERE handin.fk_u_id = user.u_id and handin.fk_m_id = module.m_id GROUP BY hi_id ORDER BY hi_date DESC;";
                conn = DbUtil.ConnectionManager.getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sqlQuery);
                while (rs.next()) {
                    fName = rs.getString("u_fname");
                    lName = rs.getString("u_lname");
                    userName = fName + " " + lName;
                    moduleName = rs.getString("m_name");
                    dateDelivered = rs.getString("hi_date");
                    hiApproved = rs.getBoolean("hi_approved");
                        if (hiApproved) { 
                            isApproved = "Ja";
                            } else { isApproved = "Nei"; }
                    handinText = rs.getString("hi_comment");
                    hiPoints = rs.getInt("hi_points");
                    hiId = rs.getInt("hi_id");
                    
                    out.format("<li>Modul: %s<br>Navn: %s<br>Levert: %s", moduleName, userName, dateDelivered);
                    out.format("<br>Poeng: %s  Godkjent: %s <br>Kommentar: %s", hiPoints, isApproved, handinText);
                    out.format("<form method=\"post\" action=\"Inspector.jsp?HID=%s\">", hiId);
                    out.println("<br><input type=\"submit\" value=\"Åpne\">");
                    out.println("</form>");
                    out.println("<form method=\"post\" action=\"Grader\">");
                    out.format("<input type=\"hidden\" name=\"HID\" value=\"%s\">", hiId);
                    out.println("<input type=\"hidden\" name=\"approved\" value=\"true\">");
                    out.println("<input type=\"submit\" value=\"Godkjenn\">");
                    out.format("<input type=\"hidden\" name=\"HID\" value=\"%s\">", hiId);
                    out.println("<input type=\"hidden\" name=\"approved\" value=\"false\">");
                    out.println("<input type=\"submit\" value=\"Avvis\">");
                }
            } catch (SQLException ex) 
            { out.println("Det skjedde en feil med databasen: " + ex); }
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
