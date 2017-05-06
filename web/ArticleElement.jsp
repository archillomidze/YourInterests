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

                    <input id="inp2" type="file" accept="image/*" onchange="loadFile(event)">
                    <img id="inp1"/>
                    <script>
                        var loadFile = function (event) {
                            var output = document.getElementById('inp1');
                            output.src = URL.createObjectURL(event.target.files[0]);
                        };

//                        var img = document.getElementById("inp1");
//
//                        if (img.complete) {
//                            var x = document.createElement("TEXTAREA");
//                            document.body.appendChild(x);
//                            x.setAttribute("style", "position:absolute; left:" + 280 + "px; top:" + 200 + "px");
//                            x.setAttribute("rows", "10");
//                            x.setAttribute("cols", "100");
//                        } else {
//                            img.addEventListener('load', loaded);
//                            img.addEventListener('error', function () {
//                                alert('error');
//                            });
//                        }
                    </script>
                    <button id="submitbutton" type="submit">Submit</button>
                </form>
                </body>
                </html>
