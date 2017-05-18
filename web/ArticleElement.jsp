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
                <form action="AddaNewArticleElementServlet" method="post">
                    <%
                        ArticleElement articleElement = new ArticleElement();
                        out.write("<font size=\"5\" id=\"pagecount\">" + "Page " + articleElement.getIndex() + "</font>");
                    %>
                    <input id="inp2" type="file" name="file" accept="image/*" onchange="loadFile(event)"/>
                    <img id="inp1" src="Resources/No_Image.png">
                    <textarea name="text" rows="10" cols="110"></textarea>
                    <button><a id="nextpage" name="nextpage" value="confirm" href="#" type="submit"><font size="4">To the next page</font></a></button>
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
                        function checkFirstVisit() {
                            var i = 0;
                            if (document.cookie.indexOf('mycookie') === -1) {

                                document.cookie = 'mycookie=1';
                            } else {
                                i++;
                            }
                            return i;
                        }
                    </script>           
                    <pre id="rud">   </pre>
                </form>
                <form action="index.jsp">
                    <button id="submitbutton">Submit</button>
                    <%
                        Cookie[] cookies = request.getCookies();
                        int userId = 0;
                        if (cookies != null) {
                            for (Cookie cookie : cookies) {
                                if (cookie.getName().equals("userId")) {
                                    userId = Integer.parseInt(cookie.getValue());
                                }
                            }
                    %>
                </form>
                </body>
                </html>
