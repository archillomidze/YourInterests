
package ge.mziuri.dao;

import ge.mziuri.model.Article;
import ge.mziuri.model.User;

public interface UserDAO {
    
    void addUser(User user);
    
    User getUser(String username, String password);
    
    void addtoFavorites(Article article);
    
    void addtoWishlist(Article article);
}
