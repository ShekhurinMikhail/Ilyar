package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDao;
import web.model.User;
import java.util.List;

@Service
public class UserServiceHiberImpl implements UserService {
    @Qualifier("userDaoHiberImpl")
    @Autowired
    private UserDao userDao;
    @Transactional
    @Override
    public List<User> showAllUsers() {
        return userDao.showAllUsers();
    }
    @Transactional
    @Override
    public User showUserId(int id) {
        return userDao.showUserId(id);
    }
    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
    @Transactional
    @Override
    public void updateUser(User updateuser) {
        userDao.updateUser(updateuser);
    }
    @Transactional
    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
