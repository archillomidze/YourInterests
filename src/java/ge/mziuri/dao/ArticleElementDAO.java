/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.dao;

import ge.mziuri.model.ArticleElement;
import java.util.List;

/**
 *
 * @author user_2
 */
public interface ArticleElementDAO {
    void createArticleElement(ArticleElement articleElement, int articleId); 
}
