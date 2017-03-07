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
        <h1 id="TopText">Add an Artice</h1>
        <form>
            <div class="boxed">
                <select id="SelectID" style = "color: black;">
                    <option value="choose">Choose Subjet</option>
                    <option value="sport">Sport</option>  
                    <option value="politics">Politics</option>  
                    <option value="cookbook">Cookbook</option>  
                    <option value="music">Music</option>  
                    <option value="art">Art</option>  
                    <option value="fairy_tale">Fairy Tale</option>  
                </select>
                <input id="title" type="text" name="title" placeholder="Choose Title.."/> <br>
                <textarea id="description" name="description" rows="4" cols="50" placeholder="Write some brief information"></textarea>
            </div>
            <button id="sbbutton" type="submit" action="index.jsp">Submit</button>
        </form>
        
        
    </body>
</html>
