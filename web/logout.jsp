<%-- 
    Document   : logout
    Created on : Jan 28, 2015, 9:11:00 PM
    Author     : Maureen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
         session.invalidate();
            response.sendRedirect("index.jsp");%>
    </body>
</html>
