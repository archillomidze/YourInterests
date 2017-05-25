
package ge.mziuri.processor;

import ge.mziuri.dao.ArticleDAO;
import ge.mziuri.dao.ArticleDAOImpl;
import ge.mziuri.dao.ArticleElementDAO;
import ge.mziuri.dao.ArticleElementDAOImpl;
import ge.mziuri.dao.EventDAO;
import ge.mziuri.dao.EventDAOImpl;
import ge.mziuri.model.Article;
import ge.mziuri.model.Event;
import ge.mziuri.model.enums.SubjectTitle;
import java.util.ArrayList;
import java.util.List;

public class ArticleProcessor {
    
    private EventDAO eventDAO = new EventDAOImpl();
    
    public List<Article> getAllArticlesBySubjectTitle(SubjectTitle title) {
        List<Event> events = eventDAO.getAllEventBySubjectName(title.name());
        List<Article> articles = new ArrayList<>();
        for (Event event : events) {
            ArticleDAO articleDAO = new ArticleDAOImpl();
            articles.addAll(articleDAO.getAllArticlesByEventID(event.getId()));
        }
        for (Article article : articles) {
            ArticleElementDAO articleElementDAO = new ArticleElementDAOImpl();
            article.setArticleElementsList(articleElementDAO.getArticleElementsByArticleId(article.getId()));
        }
        return articles;
    }
}
