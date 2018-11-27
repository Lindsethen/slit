/*
 * Vi har brukt codejava.net for å lage denne servleten.
 * "Uplaod files to database (Servlet + JSP + MySQL)":
 * https://www.codejava.net/coding/upload-files-to-database-servlet-jsp-mysql
 * Author = Henlind + CodeJava
 */
package HandinUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
 
@WebServlet(name ="UploadHandin")
@MultipartConfig(maxFileSize = 16177215)    // upload files up to 16MB (16,777,215 characters)
public class UploadHandin extends HttpServlet {
     
    // database connection settings
    private String dbURL = "jdbc:mysql://localhost:3306"
            + "/example";
    private String dbUser = "file";
    private String dbPass = "secret";
     
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // gets values of text fields
        String studentName = request.getParameter("studentName");
        String moduleNumber = request.getParameter("muduleNumber");
         
        InputStream inputStream = null;
         
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("handinHere");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
         
        Connection conn = null; // kobler til databasen
        String message = null;  // returerer varsel til bruker
         
        try {
            // kobler til databasen
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
 
            String sql = "INSERT INTO HANDIN (studentName, moduleNumber, handinHere) values (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, studentName);
            statement.setString(2, moduleNumber);
             
            if (inputStream != null) {
                statement.setBlob(3, inputStream);
            }
 
            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "Opplastning vellykket!";
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                // frakobler databasen
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            request.setAttribute("Message", message);
             
            getServletContext().getRequestDispatcher("/Student/Handins/Message.jsp").forward(request, response);
        }
    }
}