/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.model;

import ge.mziuri.model.enums.ArticleTitle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user_2
 */
public class Article {
    
    private int id;
    private ArticleTitle articletitle;
    private List<ArticleElement> ArticleElementsList = new ArrayList<>(); 

    public Article() {
    }

    public Article(int id, ArticleTitle articletitle) {
        this.id = id;
        this.articletitle = articletitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArticleTitle getArticletitle() {
        return articletitle;
    }

    public void setArticletitle(ArticleTitle articletitle) {
        this.articletitle = articletitle;
    }

    public List<ArticleElement> getArticleElementsList() {
        return ArticleElementsList;
    }

    public void setArticleElementsList(List<ArticleElement> ArticleElementsList) {
        this.ArticleElementsList = ArticleElementsList;
    }
    
    
    
}
