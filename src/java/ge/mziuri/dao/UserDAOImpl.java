package ge.mziuri.dao;

import ge.mziuri.model.User;
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
    public void addtoFavorites(int id) {
        String favourites;
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
    public void addtoWishlist(int id) {
        String wishlist;
        try {
            String sql = "UPDATE system_user set wishlist = concat(wishlist, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addtoAlreadyRead(int id) {
        String alreadyread;
        try {
            String sql = "UPDATE system_user set alreadyread = concat(alreadyread, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addtoMyList(int id) {
        String mylist;
        try {
            String sql = "UPDATE system_user set mylist = concat(mylist, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
