package com.yunsheng.jdbc;

import java.util.List;

import com.yunsheng.dao.UserDaoService;
import com.yunsheng.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by shengyun on 17/5/15.
 */
public class UserDaoServiceIMplTest {
    UserDaoService impl;

    @Before
    public void beforeClass(){
       impl = new UserDaoServiceImpl();
    }

    @Test
    public void insert() throws Exception {
        User user = new User();
        user.setUserId("100");
        user.setNickName("yunsheng");
        int i = impl.insert(user);
        Assert.assertEquals(1, i);
    }

    @Test
    public void query() throws Exception {
        List<User> userList = impl.query();
        Assert.assertNotNull(userList);
    }

}