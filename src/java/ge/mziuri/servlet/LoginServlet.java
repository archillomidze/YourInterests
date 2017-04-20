package ge.mziuri.servlet;

import ge.mziuri.dao.UserDAO;
import ge.mziuri.dao.UserDAOImpl;
import ge.mziuri.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.getUser(username, Integer.toString(password.hashCode()));
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        if (user == null) {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            request.setAttribute("loginFailed", true);
            rd.forward(request, response);
        } else {
            Cookie cookie = new Cookie("userId", String.valueOf(user.getId()));
            response.addCookie(cookie);
            RequestDispatcher rd = request.getRequestDispatcher("LogedinIndex.jsp");
            request.setAttribute("user", user);
            rd.forward(request, response);
        }
    }
}
