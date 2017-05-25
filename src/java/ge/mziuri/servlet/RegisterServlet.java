package ge.mziuri.servlet;

import ge.mziuri.dao.UserDAO;
import ge.mziuri.dao.UserDAOImpl;
import ge.mziuri.model.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        int x = 17;
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = Integer.toString(request.getParameter("password").hashCode());
        UserDAO userDAO = new UserDAOImpl();
        User user = new User(firstname, lastname, username, password);
        userDAO.addUser(user);
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
