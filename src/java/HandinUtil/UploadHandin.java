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
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 4GB
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
         
        Connection conn = null; // connection to the database
        String message = null;  // message will be sent back to client
         
        try {
            // connects to the database
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
 
            // constructs SQL statement
            String sql = "INSERT INTO HANDIN (studentName, moduleNumber, handinHere) values (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, studentName);
            statement.setString(2, moduleNumber);
             
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(3, inputStream);
            }
 
            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                // closes the database connection
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            // sets the message in request scope
            request.setAttribute("Message", message);
             
            // forwards to the message page
            getServletContext().getRequestDispatcher("/Student/Handins/Message.jsp").forward(request, response);
        }
    }
}