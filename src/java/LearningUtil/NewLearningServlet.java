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
            String idString;
            String lgName;
            String lgDesc;
            int lgNum;
            
            //Henter info fra forrige side
            idString = request.getParameter("lgNum");
            lgName = request.getParameter("lgName");
            lgDesc = request.getParameter("lgDesc");
            //Gjør om string til int
            lgNum = Integer.parseInt(idString); 
            //Printer pynt
            out.print("Data retrieved about: " + lgName +"!");
            out.print("<br>");
            out.print("Svar fra MySQLdriver: ");
            out.print("<h6>(JDBC driver)</h6>");


            NewLearning dbtool = new NewLearning();
            //logIn(out) skriver ut ex fra DbUtil
            dbtool.logIn(out);
            dbtool.newLearning(lgNum, lgName, lgDesc, out);
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
