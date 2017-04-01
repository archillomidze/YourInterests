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
                <form>
                    <textarea rows="10" cols="100"></textarea>

                    <input id="inp2" type="file" accept="image/*" onchange="loadFile(event)">
                    <img id="inp1"/>
                    <script>
                        var loadFile = function (event) {
                            var output = document.getElementById('inp1');
                            output.src = URL.createObjectURL(event.target.files[0]);
                        };
                    </script>
                </form>
                </body>
                </html>
