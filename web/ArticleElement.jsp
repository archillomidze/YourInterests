<%@page import="ge.mziuri.util.CookieUtil"%>
<%@page import="ge.mziuri.model.ArticleElement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="Resources/Icon_T.ico">
        <link rel="stylesheet" href="ArticleElement.css" type="text/css">
        <title>Article Page</title>
    </head>
    <body onload="checkFirstVisit()">
        <h1 id="TopText">Add your content<h1>
                <hr>
                <form action="AddaNewArticleElementServlet" method="post" name="elementform" id="elementformid" enctype="multipart/form-data">
                    <%
                        int index = Integer.parseInt(CookieUtil.getCookieValue("elementIndex", request, true));
                        out.write("<font size=\"5\" id=\"pagecount\">" + "Page " + index + "</font>");
                    %>
                    <input id="inp2" type="file" name="file" accept="image/*" onchange="loadFile(event)"/>
                    <img id="inp1" src="Resources/No_Image.png">
                    <textarea name="text" rows="10" cols="110"></textarea>
                    <button id="hiddenbutton"><a id="nextpage" name="nextpage" value="confirm" href="#" type="submit"><font size="4">To the next page</font></a></button>
                    <script>
                        var output = document.getElementById('inp1');
                        output.setAttribute("top", "100px");
                        if (output && output.style) {
                            output.style.height = '400px';
                            output.style.width = '400px';
                            output.style.top = "190px";
                            output.style.left = "37%";
                        }
                        var loadFile = function (event) {
                            var output = document.getElementById('inp1');
                            output.src = URL.createObjectURL(event.target.files[0]);

                        };
                    </script>           
                    <pre id="rud">   </pre>
                </form>
                <form action="index.jsp">
                    <button id="submitbutton">Submit</button>
                </form>
                </body>
                </html>
