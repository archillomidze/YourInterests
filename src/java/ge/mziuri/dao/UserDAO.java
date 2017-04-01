
package ge.mziuri.dao;

import ge.mziuri.model.User;
import java.util.List;

public interface UserDAO {
    
    void addUser(User user);
    
    User getUser(String username, String password);
    
    void addtoFavorites(int id,User user);
    
    void addtoWishlist(int id,User user);
    
    void addtoAlreadyRead(int id,User user);
    
    void addtoMyList(int id,User user);
    
    List<Integer> getFavourites(User user);
    
    List getWishlist(User user);
    
    List getAlreadyRead(User user);
    
    List getMyList(User user);
    
}
