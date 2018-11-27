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
 * @author Ludamac
 */
public class EditModuleServlet extends HttpServlet {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    String moduleString;
    String descriptionString;
    String deadlineString;
    String nameString;
    int newNum;
    int moduleID;
    boolean isPublished;
    String published;
    

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
            out.println("<title>Servlet EditModuleServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
            try {

            
                    //Henter info fra EditModule siden
            moduleID = request.getIntHeader("MID");
            descriptionString = request.getParameter("descriptionString");
            deadlineString = request.getParameter("deadlineString");
            nameString = request.getParameter("nameString");
            moduleString = request.getParameter("newNum");
            newNum = Integer.parseInt(moduleString);
            published = request.getParameter("published");
                EditModule em = new EditModule();
                //sjekker om published har en verdi og endrer published om den har en verdi
                if (published != null) {
                    if ("1".equals(published)) {
                        (isPublished)=true; 
                        em.changePublished(isPublished, moduleID);} else{
                            (isPublished)=false;}
                            em.changePublished(isPublished, moduleID);
                    }
                if (moduleString != null) {
                em.changeID(newNum, moduleID); }
                if (descriptionString != null) {
                em.changeDescription(descriptionString, moduleID); }
                if (deadlineString != null) {
                em.changeDeadline(deadlineString, moduleID); }
                if (nameString != null) {
                em.changeName(nameString, moduleID); }
                out.println("<br>Endret følgende:");
                out.println("<br>Navn: " + nameString);
                out.println("<br>Nummer: " + moduleString);
                out.println("<br>Beskrivelse: " + descriptionString);
                out.println("<br>Frist: " + deadlineString);
            }
            catch (Exception e){
                    System.out.println("Noe gikk galt.");
                    System.out.println(e);
                    
            }
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