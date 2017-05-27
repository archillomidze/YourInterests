<%@page import="ge.mziuri.model.enums.SubjectTitle"%>
<%@page import="ge.mziuri.model.Article"%>
<%@page import="ge.mziuri.dao.ArticleElementDAOImpl"%>
<%@page import="ge.mziuri.dao.ArticleElementDAO"%>
<%@page import="ge.mziuri.dao.ArticleDAOImpl"%>
<%@page import="ge.mziuri.dao.ArticleDAO"%>
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
            ArticleDAO articleDAO = new ArticleDAOImpl();
            ArticleElementDAO articleElementDAO = new ArticleElementDAOImpl();
            List<Event> allartEvent = eventDAO.getAllEventBySubjectName("ART");

            for (Event event : allartEvent) {
                out.write("<p id=\"events_art\" >" + event.getName() + "___" + "</p>");
                out.write("<a href="+">"+"<p id=\"articles_art\" >"+articleDAO.getAllArticlesByEventID(event.getId())+"<a>");

            }
        %>
    </body>
</html>
