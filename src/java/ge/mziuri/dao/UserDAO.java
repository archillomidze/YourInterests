
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
    
    List getFavourites(List<String>favourites,User user);
    
    List getWishlist(List<String>wishlist,User user);
    
    List getAlreadyRead(List<String>alreadyread,User user);
    
    List getMyList(List<String>mylist,User user);
    
}
