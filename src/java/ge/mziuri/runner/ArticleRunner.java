
package ge.mziuri.runner;

import ge.mziuri.dao.ArticleDAOImpl;
import ge.mziuri.model.Article;

public class ArticleRunner {
    public static void main(String[] args) {
            
    Article article  = new Article();
    article.setArticletitle("raRaca moxda");
    article.setDescription("ragaca dros ragaca moxda");
    
    ArticleDAOImpl articledaoimpl = new ArticleDAOImpl();
    articledaoimpl.crateArticle(article, 1);
  
    }
  
}
