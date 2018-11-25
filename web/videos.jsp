<%-- 
    Document   : videos
    Created on : Nov 25, 2018, 11:44:41 AM
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
        

<iframe width="560" height="315" src="https://www.youtube.com/embed/Y64EiUSjOfg" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

        
        <h1>"Quotes on the internet are often not true" - Abe Lincoln"</h1>
    </body>
</html>
