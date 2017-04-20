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
            String sql = "UPDATE system_user set favourites = concat(favourites, ?) WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "," + id);
            pstmt.setInt(2, user.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addtoWantToRead(int id, User user) {
        List<Article> wishlist = new ArrayList<>();
        try {
            String sql = "UPDATE system_user set wishlist = concat(wishlist, ?) WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "," + id);
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
            String sql = "UPDATE system_user set alreadyread = concat(alreadyread, ?) WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "," + id);
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
            String sql = "UPDATE system_user set mylist = concat(mylist, ?) WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(1, "," + id);
            user.setMyArticles(mylist);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Integer> getFavourites(User user) {
        List<Integer> favorities = new ArrayList<>();
        try {
            String sql = "SELECT * FROM system_user favourite WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String favouritesM[] = rs.getString("favourites").split(",");
                for (String s : favouritesM) {
                    if (s != null && !s.isEmpty()) {
                        favorities.add(Integer.parseInt(s));
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return favorities;
    }

    @Override
    public List getWishlist(User user) {
        List<Integer> wishlist = new ArrayList<>();
        try {
            String sql = "SELECT * FROM system_user wishlist WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String wishlistM[] = rs.getString("wishlist").split(",");
                for (String s : wishlistM) {
                    if (s != null && !s.isEmpty()) {
                        wishlist.add(Integer.parseInt(s));
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return wishlist;
    }

    @Override
    public List getAlreadyRead(User user) {
        List<Integer> alreadyread = new ArrayList<>();
        try {
            String sql = "SELECT * FROM system_user alreadyread WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String alreadyreadM[] = rs.getString("alreadyread").split(",");
                for (String s : alreadyreadM) {
                    if (s != null && !s.isEmpty()) {
                        alreadyread.add(Integer.parseInt(s));
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return alreadyread;
    }

    @Override
    public List getMyList(User user) {
        List<Integer> mylist = new ArrayList<>();
        try {
            String sql = "SELECT * FROM system_user mylist WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String mylistM[] = rs.getString("mylist").split(",");
                for (String s : mylistM) {
                    if (s != null && !s.isEmpty()) {
                        mylist.add(Integer.parseInt(s));
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return mylist;
    }

}
