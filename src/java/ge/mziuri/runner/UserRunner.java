package ge.mziuri.runner;

import ge.mziuri.dao.UserDAOImpl;
import ge.mziuri.model.Article;
import ge.mziuri.model.User;

public class UserRunner {

    public static void main(String[] args) {
        User user = new User();
        user.setFirstame("firstname");
        user.setSurname("surname");
        user.setUsername("username");
        user.setPassword("password");
        Article article = new Article(1, "title", "description");
        UserDAOImpl userdaoimpl = new UserDAOImpl();

       // userdaoimpl.addUser(user);
        //userdaoimpl.addtoFavorites(1, user);
        //userdaoimpl.addtoAlreadyRead(1, user);
        //userdaoimpl.addtoWishlist(1, user);
        //userdaoimpl.addtoMyList(1, user);
        User user1 = userdaoimpl.getUser("username", "password");
        System.out.println(user1.getFirstname());
    }
}
