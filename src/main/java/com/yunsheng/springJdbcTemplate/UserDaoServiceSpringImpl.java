package com.yunsheng.springJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import com.yunsheng.dao.UserDaoService;
import com.yunsheng.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * 使用spring template处理数据库操作
 * 可以很明显的感受到spring template使代码简化了很多
 * Created by shengyun on 17/5/16.
 */
public class UserDaoServiceSpringImpl implements UserDaoService{

    @Resource
    private JdbcTemplate jdbcTemplate;

    public int insert(User user) {
        String sql = "insert into user (userId, nickName) values (?,?)";
        int i = jdbcTemplate.update(sql, user.getUserId(), user.getNickName());
        return i;
    }

    public List<User> query() {
        String sql = "select * from user";
        List<User> users = jdbcTemplate.query(sql, new RowMapper<User>() {
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserId(resultSet.getString("userId"));
                user.setNickName(resultSet.getString("nickName"));
                return user;
            }
        });
        return users;
    }
}
