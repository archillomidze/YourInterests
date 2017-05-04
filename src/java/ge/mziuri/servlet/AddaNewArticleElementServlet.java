package ge.mziuri.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddaNewArticleElementServlet extends HttpServlet {
    
    private String imagePath;
    private String filePath;

//    private String name;
   // private String cookingway;
    public void init() {
        // Get the file location where it would be stored.
        filePath
                = getServletContext().getInitParameter("file-upload");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String text = request.getParameter("text");
        String picture = request.getParameter("picture");
    }
}
