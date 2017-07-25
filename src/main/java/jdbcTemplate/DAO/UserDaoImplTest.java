package jdbcTemplate.DAO;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import Model.User;

import java.util.List;

public class UserDaoImplTest {
    @Test
    public void save() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void get() throws Exception {
    }

    @Test
    public void list() throws Exception {
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory factory=new XmlBeanFactory(resource);
        UserDaoImpl user = (UserDaoImpl) factory.getBean("userDao");
        List<User> list= user.list() ;
        for(User u:list){
            System.out.println(u.getUsername());
        }

    }

    @Test
    public void setJdbcTemplate() throws Exception {
    }

    @Test
    public void getJdbcTemplate() throws Exception {
    }

}