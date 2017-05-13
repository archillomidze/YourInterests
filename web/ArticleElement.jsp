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
                <form action="AddaNewArticleElementServlet" method="post">
                    <input id="inp2" type="file" name="file" accept="image/*" onchange="loadFile(event)"/>
                    <img id="inp1" src="Resources/No_Image.png">
                    <textarea name="text" rows="10" cols="110"></textarea>
                    <button><a id="nextpage" href="#" type="submit"><font size="4">To the next page</font></a></button>
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
                    <button id="submitbutton">Submit</button>
                    <pre id="rud">   </pre>
                </form>
                </body>
                </html>
