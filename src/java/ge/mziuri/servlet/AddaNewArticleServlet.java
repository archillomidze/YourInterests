package ge.mziuri.servlet;

import ge.mziuri.dao.ArticleDAO;
import ge.mziuri.dao.ArticleDAOImpl;
import ge.mziuri.dao.EventDAO;
import ge.mziuri.dao.EventDAOImpl;
import ge.mziuri.model.Article;
import ge.mziuri.model.Event;
import ge.mziuri.model.enums.SubjectTitle;
import ge.mziuri.util.CookieUtil;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddaNewArticleServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String subjecttitle = request.getParameter("SelectID");
        String selectedEventName = request.getParameter("datalist");
        String articletitle = request.getParameter("title");
        String description = request.getParameter("description");
        ArticleDAO articleDAO = new ArticleDAOImpl();
        Article article = new Article();
        article.setArticletitle(articletitle);
        article.setDescription(description);
        EventDAO eventDAO = new EventDAOImpl();
        List<Event> allEvent = eventDAO.getAllEventBySubjectName(null);
        Event event = null;
        for (Event e : allEvent) {
            if (selectedEventName.equals(e.getName())) {
                event = e;
                break;
            }
        }
        if (event != null) {
            articleDAO.crateArticle(article, event.getId());
        } else {
            Event selectedEvent = new Event();
            selectedEvent.setName(selectedEventName);
            selectedEvent.setSubjectTitle(SubjectTitle.valueOf(subjecttitle));
            int eventId = eventDAO.addEvent(selectedEvent);
            articleDAO.crateArticle(article, eventId);
        }
        CookieUtil.addCookie("elementIndex", "1", response);
        RequestDispatcher rd = request.getRequestDispatcher("ArticleElement.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
