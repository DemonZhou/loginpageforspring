package BaseDao;

import Model.User;

import java.util.List;

public interface UserDao {

    public void save(User user);

    public void delete(String username);

    public User get(String username,String password);

    public List<User> list();

}
