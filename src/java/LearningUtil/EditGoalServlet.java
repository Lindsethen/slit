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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ludamac
 */
public class EditGoalServlet extends HttpServlet {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    String idString;
    String goalText;
    String moduleString;
    int moduleID;
    int goalID;
  

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
            out.println("<title>Servlet EditGoalServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            try{

                
                //Henter info fra forrige side
                idString = request.getParameter("GID");
                moduleString = request.getParameter("moduleID");
                goalText = request.getParameter("goalText");
                
                goalID = Integer.parseInt(idString);
                moduleID = Integer.parseInt(moduleString);
                
                EditGoal eg = new EditGoal();
                eg.changeGoaltext(goalText, goalID);
                eg.changeModule(moduleID, goalID);
                out.println("<br>Endret nummer " + idString + " sin beskrivelse til: " + goalText);
            }
                catch (Exception e){
                
                System.out.println("Noe gikk galt.");
                System.out.println(e);
            }
            
            out.println("<br><a href=Teacher/LearningGoals/AllGoals.jsp>Tilbake til læremål</a>");
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
