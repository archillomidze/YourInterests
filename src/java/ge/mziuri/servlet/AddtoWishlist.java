/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.servlet;

import ge.mziuri.dao.UserDAO;
import ge.mziuri.dao.UserDAOImpl;
import ge.mziuri.model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user_2
 */
public class AddtoWishlist extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("articleId"));
        int userId = 0;
        Cookie[] cockies = request.getCookies();
        if (cockies != null) {
            for (Cookie cookie : cockies) {
                if (cookie.getName().equals("userId")) {
                    userId = Integer.parseInt(cookie.getValue());
                }
            }
        }
        User user = new User();
        user.setId(userId);
        UserDAO userdao = new UserDAOImpl();
        userdao.addtoWantToRead(id, user);
    }

}
