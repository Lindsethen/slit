package ModuleUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NewModuleServlet", urlPatterns = {"/NewModuleServlet"})
public class NewModuleServlet extends HttpServlet {
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
            //String numString;
            String mName;
            String mDesc;
            //int mNum;
            
            //Henter info fra forrige side
            //numString = request.getParameter("mNum");
            mName = request.getParameter("mName");
            mDesc = request.getParameter("mDesc");
            //Gjør om string til int
            //mNum = Integer.parseInt(numString); 
            //Printer pynt
            out.print("Data retrieved about: " + mName +"!");
            out.print("<br>");
            out.print("Svar fra MySQLdriver: ");


            NewModule dbtool = new NewModule();
            //logIn(out) skriver ut ex fra DbUtil
            dbtool.logIn(out);
            dbtool.newModule(mName, mDesc, out);
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
