/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.dao;

import ge.mziuri.model.Article;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author user_2
 */
public class ArticleDAOImpl implements ArticleDAO {
    
    private Connection conn;
    
    private PreparedStatement pstmt;
    
    public ArticleDAOImpl() {
        conn = DatabaseUtil.getConnection();
    }

    @Override
    public void crateArticle(Article article) {
        
    }
    
}
