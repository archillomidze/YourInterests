
package ge.mziuri.dao;

import ge.mziuri.model.User;
import java.util.ArrayList;
import java.util.List;

public interface UserDAO {
    
    void addUser(User user);
    
    User getUser(String username, String password);
    
    void addtoFavorites(int id,User user);
    
    void addtoWishlist(int id,User user);
    
    void addtoAlreadyRead(int id,User user);
    
    void addtoMyList(int id,User user);
    
    List getFavourites(List<String>favourites);
    
    List getWishlist(List<String>wishlist);
    
    List getAlreadyRead(List<String>alreadyread);
    
    List getMyList(List<String>mylist);
    
}
