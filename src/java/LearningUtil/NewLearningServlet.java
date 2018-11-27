package LearningUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NewLearningServlet", urlPatterns = {"/NewLearningServlet"})
public class NewLearningServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>RegisterUser</title>");
            out.println("</head>");
            out.println("<body>");

            //lager strings å sende til serveren
            String lg_string;
            String moduleString;
            int m_id;
            
            //Henter info fra forrige side
            lg_string = request.getParameter("lg_string");
            moduleString = request.getParameter("m_id");
            //Gjør om string til int
            m_id = Integer.parseInt(moduleString);
            //Printer pynt
            out.print("Læringsmål ble lag til i modul: " + m_id +"!");
            out.print("<br>");
            out.print("Svar fra MySQLdriver: ");
            out.print("<h6>(JDBC driver)</h6>");


            NewLearning dbtool = new NewLearning();
            //logIn(out) skriver ut ex fra DbUtil
            dbtool.logIn(out);
            dbtool.newLearning(lg_string, m_id, out);
            dbtool.commit();
            dbtool.close();

            out.println("</body>");
            out.println("</html>");

        }
    }








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
