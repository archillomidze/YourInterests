
package ge.mziuri.dao;

import ge.mziuri.model.Article;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAOImpl implements ArticleDAO {
    
    private Connection conn;
    
    private PreparedStatement pstmt;
    
    public ArticleDAOImpl() {
        conn = DatabaseUtil.getConnection();
    }

    @Override
    public void crateArticle(Article article, int eventId) {
        try {
            String sql = "INSERT INTO article (articletitle, description, event_id) VALUES (?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, article.getArticletitle());
            pstmt.setString(2, article.getDescription());
            pstmt.setInt(3, eventId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public List<Article> getAllArticlesByEventID(int id){
        List<Article> articles = new ArrayList<>();
        try {
            String sql;
            sql = "SELECT * FROM article WHERE event_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String articletitle = rs.getString("articletitle");
                String description = rs.getString("description");
                Article article = new Article(articletitle, description); 
                article.setId(id);
                articles.add(article);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return articles;
    }

    @Override
    public Article getEventbyEventNameAndArticleName(String eventname, String articlename) {
        return null;
    }
    
}
