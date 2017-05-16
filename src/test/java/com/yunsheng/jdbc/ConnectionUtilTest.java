package com.yunsheng.jdbc;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shengyun on 17/5/15.
 */
public class ConnectionUtilTest {
    @Test
    public void getConnection() throws Exception {

        Connection connection = ConnectionUtil.getConnection();

        Assert.assertNotNull(connection);

        ConnectionUtil.realease(connection, null, null);

    }


}