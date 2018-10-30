package com.demo.dao.imp;
import com.demo.entity.User;
import com.demo.dao.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDaoImp implements dao {

    @Autowired
    private JdbcTemplate jdbcTemplate;//定义了一个private对象，只有这个类的对象才能用

    @Override
    public int insert(User user) {
        String sql = "insert into t_user(id,username,password) values(?,?,?)";
        /*sql语句 user 代表的是访问的 Mysql数据库中的user表
        原理：本质上 我在配置文件连接了mysql数据库，这里是利用 sql的insert语句向mysql数据库中的t_user表
        （选择其中的id,username,password）插入相应的value值，下面通过调用user.getId()等等获得相应值，然后传入
        （这里是在其他地方对Id,Username等事先赋了值的）
        */
        return this.jdbcTemplate.update(    //JbdcTemplate这个类下的jdbcTemplate对象下，执行update方法，查阅 JbdcTemplate.class库文件
                sql,
                user.getId(),
                user.getUsername(),
                user.getPassword()

        );
    }

    @Override
    public int deleteById(Integer id) {
        String sql = "delete from t_user where id = ?";
        return this.jdbcTemplate.update(sql, id);
    }

    @Override
    public int update(User user) {
        String sql = "update t_user set password = ? where id = ?";
        return this.jdbcTemplate.update(
                sql,
                user.getPassword(),
                user.getId()
        );
    }

    @Override
    public User getById(Integer id) {
        String sql = "select * from t_user where id = ?";
        return this.jdbcTemplate.queryForObject(sql, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }

        }, id);
    }

}
