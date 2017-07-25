package ibatis.DAO;

import Model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.List;

public class IbatisUserDaoImplTest {
    @Test
    public void save() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IbatisUserDaoImpl udl = (IbatisUserDaoImpl) applicationContext.getBean("IbatisUserDao");
        udl.save(new User("abcd","1234"));
        List<User> list = udl.list();
        for(User u:list){
            System.out.println(u.getUsername());
        }
    }

    @Test
    public void delete() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IbatisUserDaoImpl udl = (IbatisUserDaoImpl) applicationContext.getBean("IbatisUserDao");
        udl.delete("abcd");
        List<User> list = udl.list();
        for(User u:list){
            System.out.println(u.getUsername());
        }
    }

    @Test
    public void get() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IbatisUserDaoImpl udl = (IbatisUserDaoImpl) applicationContext.getBean("IbatisUserDao");
        User user = udl.get("admin","admin");
        System.out.println(user.getUsername() + ":" + user.getPassword());
    }

    @Test
    public void list() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IbatisUserDaoImpl udl = (IbatisUserDaoImpl) applicationContext.getBean("IbatisUserDao");
        List<User> list = udl.list();
        for(User u:list){
            System.out.println(u.getUsername());
        }
    }

}