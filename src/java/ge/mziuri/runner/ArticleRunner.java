/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.runner;

import ge.mziuri.dao.ArticleDAOImpl;
import ge.mziuri.model.Article;

/**
 *
 * @author user_2
 */
public class ArticleRunner {
    public static void main(String[] args) {
            
    Article article  = new Article();
    article.setArticletitle("raRaca moxda");
    article.setDescription("ragaca dros ragaca moxda");
    
    ArticleDAOImpl articledaoimpl = new ArticleDAOImpl();
    articledaoimpl.crateArticle(article, 1);
  
    }
  
}
