package com.yunsheng.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 管理数据库连接
 * Created by shengyun on 17/5/15.
 */
public class ConnectionUtil {

    public static Connection getConnection() throws SQLException {
        Properties pros = new Properties();
        InputStream is = null;
        String url = null;
        String userName = null;
        String passwd = null;
        String driverClass = null;

        try {
            is = ConnectionUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            pros.load(is);
            url = pros.getProperty("jdbc.url");
            driverClass = pros.getProperty("jdbc.driverClass");
            userName = pros.getProperty("jdbc.userName");
            passwd = pros.getProperty("jdbc.passwd");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // 记载jdbc驱动
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = DriverManager.getConnection(url, userName, passwd);

        return connection;
    }

    public static void realease(Connection connect, Statement statement, ResultSet resultSet) {
        if (null != resultSet) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (null != statement) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (null != connect) {
            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
