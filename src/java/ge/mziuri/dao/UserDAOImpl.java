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
    public List getFavourites(List<String> favourites) {
        try {
            String sql = "SELECT * FROM system_user favourites";
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String favouritesM[] = rs.getString("favourites").split(",");
                favourites = Arrays.asList(favouritesM);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return favourites;
    }

    @Override
    public List getWishlist(List<String> wishlist) {
        try {
            String sql = "SELECT * FROM system_user wishlist";
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String wishlistM[] = rs.getString("wishlist").split(",");
                wishlist = Arrays.asList(wishlistM);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return wishlist;
    }

    @Override
    public List getAlreadyRead(List<String> alreadyread) {
        try {
            String sql = "SELECT * FROM system_user alreadyread";
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String alreadyreadM[] = rs.getString("alreadyread").split(",");
                alreadyread = Arrays.asList(alreadyreadM);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return alreadyread;
    }

    @Override
    public List getMyList(List<String> mylist) {
        try {
            String sql = "SELECT * FROM system_user mylist";
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String mylistM[] = rs.getString("alreadyread").split(",");
                mylist = Arrays.asList(mylistM);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return mylist;
    }

}
