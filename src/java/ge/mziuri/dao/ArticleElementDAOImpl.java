package ge.mziuri.dao;

import ge.mziuri.model.ArticleElement;
import ge.mziuri.util.StringUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleElementDAOImpl implements ArticleElementDAO {

    private Connection conn;
    private PreparedStatement pstmt;

    public ArticleElementDAOImpl() {
        conn = DatabaseUtil.getConnection();
    }

    @Override
    public void createArticleElement(ArticleElement articleElement, int articleId) {
        try {
            String sql = "INSERT INTO article_element (index, text, pictures, article_id) VALUES (?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, articleElement.getIndex());
            pstmt.setString(2, StringUtil.getStringFromList(articleElement.getTextList()));
            pstmt.setString(3, StringUtil.getStringFromList(articleElement.getPicturesList()));
            pstmt.setInt(4, articleId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<ArticleElement> getArticleElementsByArticleId(int article_id) {
        List<ArticleElement> articleelements = new ArrayList<>();
        try {
            String sql;
            sql = "SELECT * FROM articleelement WHERE article_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, article_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int index = rs.getInt("index");
                ArticleElement articleelement = new ArticleElement();
                articleelement.setId(article_id);
                articleelement.setIndex(index);
                articleelement.setTextList(StringUtil.getStringListFromString(rs.getString("text")));
                articleelement.setPicturesList(StringUtil.getStringListFromString(rs.getString("pictures")));
                articleelements.add(articleelement);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return articleelements;
    }
}
