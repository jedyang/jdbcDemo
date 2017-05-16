package com.yunsheng.dao;

import java.util.List;

import com.yunsheng.domain.User;

/**
 * Created by shengyun on 17/5/15.
 */
public interface UserDaoService {

    int insert(User user);

    List<User> query();
}
