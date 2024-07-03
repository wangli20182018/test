package com.example.demo.service;

/**
 * @description:
 * @author: wl
 * @createDate: 2024/2/20 5:43 PM
 */
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("account_id")
    private String accountId;

    @JsonProperty("create_time")
    private long createTime;

    @JsonProperty("user_level")
    private String userLevel;

    // 构造函数、getter 和 setter 方法发发发

    @Override
    public String toString() {
        return "User{" +
                "accountId='" + accountId + '\'' +
                ", createTime=" + createTime +
                ", userLevel='" + userLevel + '\'' +
                '}';
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }
}

