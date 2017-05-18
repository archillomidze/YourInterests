
package ge.mziuri.dao;

import ge.mziuri.model.ArticleElement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArticleElementDAOImpl implements ArticleElementDAO{
    
    private static final String SPLITTER = "#@~";
    private Connection conn;
    private PreparedStatement pstmt;

    public ArticleElementDAOImpl() {
        conn = DatabaseUtil.getConnection();
    }
    
    @Override
    public void createArticleElement(ArticleElement articleElement, int articleId) {
        try {
            String sql = "INSERT INTO article_element (index, text, pictures, article_id) VALUES (?,?,?,?)";
            String text = "";
            for(int i = 0; i < articleElement.getTextList().size(); i++){
                text = text + articleElement.getTextList().get(i);
                if(i != articleElement.getTextList().size() - 1){
                    text = text + SPLITTER;
                }
            }
            String pictures = "";
            for(int i = 0; i < articleElement.getPicturesList().size(); i++){
                pictures = pictures + articleElement.getPicturesList().get(i);
                if(i != articleElement.getTextList().size() - 1){
                    pictures = pictures + SPLITTER;
                }
            }
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, articleElement.getIndex());
            pstmt.setString(2, text);
            pstmt.setString(3, pictures);
            pstmt.setInt(4, articleId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
