/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 *
 * @author Ludamac
 */
public class ModuleInspector extends HttpServlet {
String moduleID;
String moduleName;
String sqlQuery;
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
String gDesc;

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
                moduleName = request.getParameter("mName");
                sqlQuery = "SELECT lg_string FROM LEARNINGGOAL, MODULE WHERE fk_m_id = " + moduleID + " GROUP BY lg_id;";
            
                out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ModuleInspector</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Alle læremål for " + moduleName + "</h1>");
            
            try {
                conn = DbUtil.ConnectionManager.getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sqlQuery);
                PrintWriter sqlwriter = response.getWriter();
                while (rs.next()) 
                    {
                    gDesc = rs.getString("lg_string");
                    sqlwriter.println("<li>" + gDesc);
                    }
                } 
                    catch(SQLException sex) {
                    out.println("Det skjedde en feil med databasen: " + sex);
                    }
            out.println("<a href=AllModules.jsp>Tilbake</a>");
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
