<%@page import="ge.mziuri.dao.EventDAOImpl"%>
<%@page import="ge.mziuri.dao.EventDAO"%>
<%@page import="ge.mziuri.model.Event"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add an Article</title>
        <link rel="stylesheet" href="AddaNew.css" type="text/css">
        <link rel="shortcut icon" href="Resources/Icon_T.ico">
    </head>
    <body>
        <h1 id="TopText">Add an Article</h1>
        <form action="AddaNewArticleServlet" method="post">
            <div class="boxed">
                <select id="SelectID" name="SelectID" style = "color: black;">
                    <option value="choose">Choose Subject</option>
                    <option value="SPORT">Sport</option>  
                    <option value="POLITICS">Politics</option>  
                    <option value="COOKBOOK">Cookbook</option>  
                    <option value="MUSIC">Music</option>  
                    <option value="ART">Art</option>  
                    <option value="FAIRY_TALE">Fairy Tail</option>  
                </select>
                <div id="boxinbox">
                    <input list="datalist" name="datalist" placeholder="Choose an Event ">
                    <datalist id="datalist" >
                        <%
                            EventDAO eventDAO = new EventDAOImpl();
                            List<Event> allEvent = eventDAO.getAllEventBySubjectName(null);
                            for (Event event : allEvent) {
                                out.write("<option value=\"" + event.getName() + "\" id=\"" + event.getSubjectTitle() + "_" + event.getName() + " \">");
                            }
                        %>  
                    </datalist>
                </div>
                <input id="title" type="text" name="title" placeholder="Choose Title.."/> <br>
                <textarea id="description" name="description" rows="4" cols="50" placeholder="Write some brief information"></textarea>
            </div>
                    <button id="sbbutton" type="submit">Continue</button>
        </form>


    </body>
</html>
