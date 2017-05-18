package ge.mziuri.runner;

import ge.mziuri.dao.UserDAOImpl;
import ge.mziuri.model.Article;
import ge.mziuri.model.User;
import java.util.List;

public class UserRunner {

    public static void main(String[] args) {
        User user = new User();
        //user.setId(1);
        //User user1 = new User();
//        user1.setId(1);
        // user1.setId(4);
//        User user2 = new User();
//        user2.setId(5);
//        user2.setFirstame("firstname123");
//      user2.setSurname("surname123");
//        user2.setUsername("username123");
//       user2.setPassword("password123");
//       Article article = new Article(1, "title", "description");
//        Article article1 = new Article(2, "title1", "description1");
        UserDAOImpl userdaoimpl = new UserDAOImpl();
        //userdaoimpl.addUser(user);
        // userdaoimpl.addtoFavorites(35, user2);
//        userdaoimpl.addtoAlreadyRead(1, user);
//        userdaoimpl.addtoWishlist(1, user);
//        userdaoimpl.addtoMyList(1, user);
        // System.out.println(user1.getFirstname());
        //System.out.println(userdaoimpl.getMyList(user));
    }
}
