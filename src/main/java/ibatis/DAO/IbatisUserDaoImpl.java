package ibatis.DAO;

import BaseDao.UserDao;
import Model.User;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IbatisUserDaoImpl extends SqlMapClientDaoSupport implements UserDao {

    @Resource(name = "sqlMapClient")
    private SqlMapClient sqlMapClient;

    @PostConstruct
    public void initSqlMapClient(){
        super.setSqlMapClient(sqlMapClient);
    }

    public void save(User user) {
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("username",user.getUsername());
        map.put("password",user.getPassword());
        getSqlMapClientTemplate().insert("addUser",map);
    }

    public void delete(String username) {
        getSqlMapClientTemplate().delete("deleteUser",username);
    }

    public User get(String username, String password) {
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("username",username);
        map.put("password",password);
        return (User) getSqlMapClientTemplate().queryForObject("findUser",map);
    }

    public List<User> list() {
        return (List<User>) getSqlMapClientTemplate().queryForList("findAllUser");
    }
}
