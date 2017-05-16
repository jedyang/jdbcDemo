package com.yunsheng.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Created by shengyun on 17/5/15.
 */
public class User {

    private int id;

    private String userId;

    private String nickName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
