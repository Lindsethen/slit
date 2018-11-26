/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HandinUtil;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author matjo
 */
public class OverviewServlet extends HttpServlet {
String userID;
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
String uid;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String uid)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        userID = uid;
        PrintWriter out = response.getWriter();
        out.println("<h1>" + userID + "</h1>");
        String query = "SELECT m_id, m_name, m_deadline, m_description, handin.hi_approved FROM MODULE, HANDIN WHERE m_published = 1 and handin.fk_u_id = " + userID + " and handin.fk_m_id = module.m_id ORDER BY m_id ASC;";
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
          boolean isApproved = rs.getBoolean("hi_approved");
          String approvedString;
            if (isApproved){
                approvedString = "Yes";
            } else { approvedString = "No, try again"; }
          String mName = rs.getString("m_name");
          String mDesc = rs.getString("m_description");
          String mDeadline = rs.getString("m_deadline");
          // kjøres for hver row med følgende format:
          sqlWriter.format("<li>Number:%s Name: %s</br> Description: %s <br> Deadline: %s <br> Approved: %s", id, mName, mDesc, mDeadline, approvedString);
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String uid= (String)session.getAttribute("username");
        session.getAttribute("username");
        processRequest(request, response, uid);

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
        processRequest(request, response, "YOLO");
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
