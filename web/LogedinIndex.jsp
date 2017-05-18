<%@page import="java.nio.channels.SelectionKey"%>
<%@page import="ge.mziuri.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <title>Your Interests</title>
        <link rel="stylesheet" href="indexStyle.css" type="text/css">
        <link rel="shortcut icon" href="Resources/Icon_T.ico">
    </head>
    <body>
        <div class="wrapper row2">
            <div id="container" class="clear">
                <div>
                    <select id="green" style = "color: black;">
                        <option value="user"><%=((User) request.getAttribute("user")).getUsername()%></option>
                        <option value="MyArticles" onclick="location.href = 'MyArticles.jsp'">My Articles</option>
                        <option value="Favourites" onclick="location.href = 'Favourites.jsp'">Favourities</option>
                        <option value="WanttoRead" onclick="location.href = 'WanttoRead.jsp'">Want to Read</option>
                        <option value="AlreadyRead" onclick="location.href = 'AlreadyRead.jsp'">Already Read</option>
                        <option value="AddNew" onclick="location.href = 'AddaNew.jsp'">Add New+</option> 
                    </select>
                </div>
                <div class="logo">
                    <section id="slider" class="clear">
                        <figure>
                            <img src="Resources/logo.png" class="logoclas " alt="img.logo">
                            <form id="tfnewsearch" method="get" action="http://www.google.com">
                                <br><br>
                                <input type="text" class="tftextinput"  name="q" size="21" maxlength="120"><input type="submit" value="search" class="tfbutton">
                            </form>
                            <br>
                        </figure>
                    </section>
                </div>
                <!-- main content -->
                <div id="homepage">
                    <!-- Services -->
                    <section id="services" class="clear">
                        <article class="one_third">
                            <figure>
                                <figcaption>
                                    <footer class="more"><a href="Subject_Sport.jsp"><img src="Resources/sportV2.jpg" width="290" height="180" alt=""></a></footer>
                                    <footer class="more"><a href="Subject_Music.jsp"><img src="Resources/music.jpg" width="290" height="180" alt=""></a></footer>
                                </figcaption>
                            </figure>
                        </article>
                        <article class="one_third">
                            <figure>
                                <figcaption>
                                    <footer class="more"><a href="Subject_Politics.jsp"><img src="Resources/POLITICS1.jpg" width="290" height="180" alt=""></a></footer>
                                    <footer class="more"><a href="Subject_Art.jsp"><img src="Resources/art.jpg" width="290" height="180" alt=""></a></footer>
                                </figcaption>
                            </figure>
                        </article>
                        <article class="one_third lastbox">
                            <figure>
                                <figcaption>
                                    <footer class="more"><a href="Subject_CookBook.jsp"><img src="Resources/7eTModoin.gif" width="290" height="180" alt=""></a></footer>
                                    <footer class="more"><a href="Subject_FairyTale.jsp"><img src="Resources/fairy_tale.jpg" width="290" height="180" alt=""></a></footer>

                                </figcaption>
                            </figure>
                        </article>
                    </section>
                </div>
            </div>
        </div>
    </body>
</html>

