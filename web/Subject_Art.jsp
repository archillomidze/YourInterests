<%@page import="ge.mziuri.model.Event"%>
<%@page import="ge.mziuri.dao.EventDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="ge.mziuri.dao.EventDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Art</title>
        <link rel="stylesheet" href="Subjects.css" type="text/css">
        <link rel="shortcut icon" href="Resources/Icon_T.ico">
    </head>
    <body id="artbody">
        <h1 id="TopTextart">Art</h1>
        <hr id="hrft">
            <%
                EventDAO eventDAO = new EventDAOImpl();
                List<Event> allartEvent = eventDAO.getAllEventBySubjectName("ART");
                for (Event event : allartEvent) {
                    out.write("<p id=\"RAGACA\" >" + event.getName() + "</p>");
                }
                %>
                
    </body>
</html>
