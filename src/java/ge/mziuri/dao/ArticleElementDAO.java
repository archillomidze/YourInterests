
package ge.mziuri.dao;

import ge.mziuri.model.ArticleElement;
import java.util.List;

public interface ArticleElementDAO {
    
    void createArticleElement(ArticleElement articleElement, int articleId); 
    
    List<ArticleElement> getArticleElementsByArticleId (int article_id);
}
