/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user_2
 */
public class Article {
    
    private int id;
    private String articletitle;
    private List<ArticleElement> ArticleElementsList = new ArrayList<>(); 

    public Article() {
    }

    public Article(int id, String articletitle) {
        this.id = id;
        this.articletitle = articletitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticletitle() {
        return articletitle;
    }

    public void setArticletitle(String articletitle) {
        this.articletitle = articletitle;
    }

    public List<ArticleElement> getArticleElementsList() {
        return ArticleElementsList;
    }

    public void setArticleElementsList(List<ArticleElement> ArticleElementsList) {
        this.ArticleElementsList = ArticleElementsList;
    }
    
    
    
}
