package com.yunsheng.springJdbcTemplate;

import java.util.List;

import javax.annotation.Resource;

import com.yunsheng.dao.UserDaoService;
import com.yunsheng.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by shengyun on 17/5/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class UserDaoServiceSpringImplTest {

    @Resource
    UserDaoService userDaoService;

    @Test
    public void insert() throws Exception {
        User user = new User();
        user.setUserId("200");
        user.setNickName("yunsheng200");
        int i = userDaoService.insert(user);
        Assert.assertEquals(1, i);
    }

    @Test
    public void query() throws Exception {
        List<User> userList = userDaoService.query();
        System.out.println(userList);
        Assert.assertNotNull(userList);
    }

}