package web.DAO;

import web.model.User;
import java.util.List;

public interface UserDao {
    List<User> showAllUsers();

    User showUserId(long id);

    void saveUser(User user);

    void updateUser(User updateuser);

    void deleteUser(long id);
}
