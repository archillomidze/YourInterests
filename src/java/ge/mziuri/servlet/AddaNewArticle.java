/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.servlet;

import ge.mziuri.dao.ArticleDAO;
import ge.mziuri.dao.ArticleDAOImpl;
import ge.mziuri.model.Article;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class AddaNewArticle extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
         
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String subjecttitle = request.getParameter("subjecttitle");
        String name = request.getParameter("name");
        String articletitle = request.getParameter("articletitle");
        String description = request.getParameter("description");
        ArticleDAO aricleDAO = new ArticleDAOImpl();
        Article article = new Article();
        article.setArticletitle(articletitle);
        article.setDescription(description);
        
    }
    
}
