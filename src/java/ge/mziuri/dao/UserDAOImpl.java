
package ge.mziuri.dao;

import ge.mziuri.model.Article;
import ge.mziuri.model.User;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    
    private Connection conn;
    
    private PreparedStatement pstmt;
    
    public UserDAOImpl() {
        conn = DatabaseUtil.getConnection();
    }

    @Override
    public void addUser(User user) {
        try {
            String sql = "INSERT INTO system_user (firstname,surname,username,password,vipstatus) VALUES (?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getFirstname());
            pstmt.setString(2, user.getSurname());
            pstmt.setString(3, user.getUsername());
            pstmt.setString(4, user.getPassword());
            pstmt.setBoolean(5, false);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public User getUser(String username, String password) {
        try {
            String sql = "SELECT * FROM system_user WHERE username = ? AND password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String firstname = rs.getString("firstname");
                String surname = rs.getString("surname");
                boolean VIPStatus = rs.getBoolean("VIPStatus");
                User user = new User(firstname, surname, username, password, VIPStatus);
                return user;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public void addtoFavorites(Article article) {
        try {
            String sql = "INSERT INTO favourites (articletitle,ArticleElementsList,description) VALUES (?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, article.getArticletitle());
            for(int i=0; i<article.getArticleElementsList().size(); i++){
                pstmt.setArray(2, (Array) article.getArticleElementsList().get(i));
            }
            pstmt.setString(3, article.getDescription());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addtoWishlist(Article article) {
        try {
            String sql = "INSERT INTO wishlist (articletitle,ArticleElementsList,description) VALUES (?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, article.getArticletitle());
            for(int i=0; i<article.getArticleElementsList().size(); i++){
                pstmt.setArray(2, (Array) article.getArticleElementsList().get(i));
            }
            pstmt.setString(3, article.getDescription());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
