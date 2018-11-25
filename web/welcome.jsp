<%--
    Document   : welcome
    Created on : Nov 24, 2018, 5:50:39 PM
    Author     : josteinvagarygg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            if (session.getAttribute("username")==null)
            {
                response.sendRedirect("login.jsp");
            }

        %>
          Welcome ${username}

          <a href="videos.jsp"> Vil du ha et visdomsord?</a>
    
          <form action="LogoutServlet">
              
              <input type="submit" value="Logout">
          
          </form>
    </body
</html>