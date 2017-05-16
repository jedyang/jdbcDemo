package com.yunsheng.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yunsheng.dao.UserDaoService;
import com.yunsheng.domain.User;

/**
 * 使用最原始jdbc操作数据库
 * Created by shengyun on 17/5/15.
 */
public class UserDaoServiceImpl implements UserDaoService{

    public int insert(User user) {
        String sql = "insert into user (userId, nickName) values (?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserId());
            preparedStatement.setString(2, user.getNickName());
            int i = preparedStatement.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionUtil.realease(connection, preparedStatement, null);
        }
        return 0;
    }

    public List<User> query() {
        List<User> result = new ArrayList<User>();

        String sql = "select * from user";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if(null != resultSet){
                User user;
                while (resultSet.next()){
                    user = new User();
                    int id = resultSet.getInt("id");
                    String userId = resultSet.getString("userId");
                    String nickname = resultSet.getString("nickname");

                    user.setId(id);
                    user.setUserId(userId);
                    user.setNickName(nickname);

                    result.add(user);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionUtil.realease(connection, preparedStatement, resultSet);
        }
        return result;
    }
}
