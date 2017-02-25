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
public class Event {
    
    private int id;
    private String name;
    private List<Article> ArticlesList = new ArrayList<>(); 

    public Event() {
    }

    public Event(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Article> getArticlesList() {
        return ArticlesList;
    }

    public void setArticlesList(List<Article> ArticlesList) {
        this.ArticlesList = ArticlesList;
    }
    
    
    
}
