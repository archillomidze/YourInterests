<%@page import="ge.mziuri.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <title>Your Interests</title>
        <link rel="stylesheet" href="indexStyle.css" type="text/css">
    </head>
    <body>
        <div class="wrapper row2">
            <div id="container" class="clear">
                <div>
                    <button  class="mybtn" style = "color: black;"><%=((User)request.getAttribute("user")).getFirstname()%></button>

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
                                    <footer class="more"><a href="#"><img src="Resources/sportV2.jpg" width="290" height="180" alt=""></a></footer>
                                    <footer class="more"><a href="#"><img src="Resources/music.jpg" width="290" height="180" alt=""></a></footer>
                                </figcaption>
                            </figure>
                        </article>
                        <article class="one_third">
                            <figure>
                                <figcaption>
                                    <footer class="more"><a href="#"><img src="Resources/POLITICS1.jpg" width="290" height="180" alt=""></a></footer>
                                    <footer class="more"><a href="#"><img src="Resources/art.jpg" width="290" height="180" alt=""></a></footer>
                                </figcaption>
                            </figure>
                        </article>
                        <article class="one_third lastbox">
                            <figure>
                                <figcaption>
                                    <footer class="more"><a href="#"><img src="Resources/7eTModoin.gif" width="290" height="180" alt=""></a></footer>
                                    <footer class="more"><a href="#"><img src="Resources/fairy_tale.jpg" width="290" height="180" alt=""></a></footer>

                                </figcaption>
                            </figure>
                        </article>
                    </section>
                </div>
            </div>
        </div>
    </body>
</html>

