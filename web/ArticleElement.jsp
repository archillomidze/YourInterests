<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="Resources/Icon_T.ico">
        <link rel="stylesheet" href="ArticleElement.css" type="text/css">
        <title>Article Page</title>
    </head>
    <body>
          <h1 id="TopText">Add your content<h1>
                <hr>
                <form action="AddaNewArticleElementServlet" method="post" enctype="multipart/form-data">
                    <textarea rows="10" cols="100"></textarea>

                    <input id="inp2" type="file" accept="image/*" onchange="loadFile(event)"/>
                    <img id="inp1" src="Resources/No_Image.webp">
                    <script>
                        var output = document.getElementById('inp1');
                        output.setAttribute("top", "100px");
                        if (output && output.style) {
                            output.style.height = '200px';
                            output.style.width = '200px';
                            output.style.top = "190px";
                            output.style.left = "561px";
                        }
                        var loadFile = function (event) {
                            var output = document.getElementById('inp1');
                            output.src = URL.createObjectURL(event.target.files[0]);
                        };
                    </script>
                    <button id="submitbutton" type="submit">Submit</button>
                </form>
                </body>
                </html>
