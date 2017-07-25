package jdbcTemplate.DAO;


import BaseDao.UserDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import Model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {


    /*
    public IbatisUserDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }*/

    public UserDaoImpl() {
    }





    public void save(User user) {
        String sql = "insert into users (username,password) values (?,?)";
        this.getJdbcTemplate().update(sql, user.getUsername(), user.getPassword());
    }

    public void delete(String username) {
        String sql = "delete from users where username = ?";
        this.getJdbcTemplate().update(sql, username);
    }

    public User get(final String username, String password) {
        String sql = "select * from users where username = '" + username + "' and password = '" + password + "'";

        return this.getJdbcTemplate().query(sql, new ResultSetExtractor<User>() {
            public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if (resultSet.next()) {
                    User user = new User();
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    return user;
                }
                return null;
            }
        });
    }

    public List<User> list() {
        String sql = "select * from users";
        List list = this.getJdbcTemplate().queryForList(sql);
        List<User> userlist = this.getJdbcTemplate().query(sql, new RowMapper<User>() {
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        });
        return userlist;
    }
}
