
package ge.mziuri.model;

import java.util.ArrayList;
import java.util.List;


public class Article {
    
    private int id;
    private String articletitle;
    private List<ArticleElement> ArticleElementsList = new ArrayList<>(); 
    private String description;

    public Article() {
    }

    public Article(String articletitle, String description) {
        this.articletitle = articletitle;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
