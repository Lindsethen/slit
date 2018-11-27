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
            
            int mId;
            String moduleId;
            String mName;
            String mDesc;
            String mDeadline;
            String mPublished;
            
            //Henter info fra forrige side
            //Gjør om string til int
            moduleId = request.getParameter("moduleId");
            mId = Integer.parseInt(moduleId);
            mName = request.getParameter("mName");
            mDesc = request.getParameter("mDesc");
            mDeadline = request.getParameter("mDeadline");
            mPublished = request.getParameter("mPublished");
            


            
            out.print("Data retrieved about: " + mName +"!");
            out.print("<br>");
            out.print("Svar fra MySQLdriver: ");


            NewModule dbtool = new NewModule();
            //logIn(out) skriver ut ex fra DbUtil
            dbtool.logIn(out);
            dbtool.newModule(mId, mName, mDesc, mDeadline, mPublished, out);
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