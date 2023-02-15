package web.service;

import web.model.User;
import java.util.List;

public interface UserService {
    List<User> showAllUsers();

    User showUserId(int id);

    void saveUser(User user);

    void updateUser(User updateuser);

    void deleteUser(int id);
}
