<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="ArticleView.css" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="rightpanel">
            
            <form action="AddtoFavouritesServlet" method="post"><Button id="favourites">Add to Favourites</Button></form>
            
            <form action="AddtoAlreadyReadServlet" method="post"><Button id="alreadyRead">Add to AlreadyRead</Button></form>
            
            <form action="AddtoWishlistServlet" method="post"><Button id="wishlist">Add to Wishlist</Button></form>
        </div>
    </body>
</html>
