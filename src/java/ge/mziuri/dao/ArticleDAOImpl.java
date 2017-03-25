
package ge.mziuri.dao;

import ge.mziuri.model.Article;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    
}
