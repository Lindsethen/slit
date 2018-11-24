/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleUtil;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



    /**
     *
     */
@WebServlet(name = "DeleteModuleServlet", urlPatterns = {"/DeleteModuleServlet"})
public class DeleteModuleServlet extends HttpServlet {
//int fordi det lagres som int i MySQL
int ModuleID;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

     //starter servlet (post/get metodene kjører void processRequest)
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //starter HTML Skriving / Lager printwriter som kalles ".out"
        try (PrintWriter out = response.getWriter()) {
            //Henter ID fra forrige side (/user/deleteuser.html) og gjør om til int fra string
            String idString = request.getParameter("UID");
            int ModuleID = Integer.parseInt(idString);
            //kjører DeleteModules.deleteID med int ModuleID som parameter. =new fordi deleteID er en statisk funksjon
            DeleteModules delClass = new DeleteModules();
            delClass.deleteID(ModuleID);
            //Printer mer HTML
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeleteModulesServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Slettet modul nummer " +idString);
            out.println("<h1>Servlet DeleteModulesServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
/**
 *
 * @author Ludamac
 */

