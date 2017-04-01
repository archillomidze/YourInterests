package ge.mziuri.dao;

import ge.mziuri.model.Article;
import ge.mziuri.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private Connection conn;

    private PreparedStatement pstmt;

    public UserDAOImpl() {
        conn = DatabaseUtil.getConnection();
    }

    @Override
    public void addUser(User user) {
        try {
            String sql = "INSERT INTO system_user (firstname,surname,username,password) VALUES (?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getFirstname());
            pstmt.setString(2, user.getSurname());
            pstmt.setString(3, user.getUsername());
            pstmt.setString(4, user.getPassword());
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
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String surname = rs.getString("surname");
                User user = new User(firstname, surname, username, password);
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
    public void addtoFavorites(int id, User user) {
        try {
            String sql = "UPDATE system_user set favourites = concat(favourites, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addtoWishlist(int id, User user) {
        List<Article> wishlist = new ArrayList<>();
        try {
            String sql = "UPDATE system_user set wishlist = concat(wishlist, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            user.setWantToRead(wishlist);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addtoAlreadyRead(int id, User user) {
        List<Article> alreadyread = new ArrayList<>();
        try {
            String sql = "UPDATE system_user set alreadyread = concat(alreadyread, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            user.setAlreadyRead(alreadyread);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addtoMyList(int id, User user) {
        List<Article> mylist = new ArrayList<>();
        try {
            String sql = "UPDATE system_user set mylist = concat(mylist, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            user.setMyArticles(mylist);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List getFavourites(List<String> favourites,User user) {
        try {
            String sql = "SELECT * FROM system_user favourite WHERE username = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String username=rs.getString("username");
                String favouritesM[] = rs.getString("favourites").split(",");
                favourites = Arrays.asList(favouritesM);
                user.setUsername(username);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return favourites;
    }

    @Override
    public List getWishlist(List<String> wishlist,User user) {
        try {
            String sql = "SELECT * FROM system_user wishlist WHERE username = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String username=rs.getString("username");
                String wishlistM[] = rs.getString("wishlist").split(",");
                wishlist = Arrays.asList(wishlistM);
                user.setUsername(username);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return wishlist;
    }

    @Override
    public List getAlreadyRead(List<String> alreadyread,User user) {
        try {
            String sql = "SELECT * FROM system_user alreadyread WHERE username = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String username=rs.getString("username");
                String alreadyreadM[] = rs.getString("alreadyread").split(",");
                alreadyread = Arrays.asList(alreadyreadM);
                user.setUsername(username);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return alreadyread;
    }

    @Override
    public List getMyList(List<String> mylist,User user) {
        try {
            String sql = "SELECT * FROM system_user mylist WHERE username = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String username=rs.getString("username");
                String mylistM[] = rs.getString("alreadyread").split(",");
                mylist = Arrays.asList(mylistM);
                user.setUsername(username);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return mylist;
    }

}
