
package ge.mziuri.dao;

import ge.mziuri.model.User;

public interface UserDAO {
    
    void addUser(User user);
    
    User getUser(String username, String password);
    
    void addtoFavorites(int id);
    
    void addtoWishlist(int id);
    
    void addtoAlreadyRead(int id);
    
    void addtoMyList(int id);
    
}
