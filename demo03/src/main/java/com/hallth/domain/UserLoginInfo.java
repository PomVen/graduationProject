package com.hallth.domain;

import java.util.Date;

public class UserLoginInfo {
    private String loginUserId;

    private String loginUserName;

    private String loginUserRole;

    private String loginUserOrg;

    private Date loginTime;

    public String getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(String loginUserId) {
        this.loginUserId = loginUserId;
    }

    public String getLoginUserName() {
        return loginUserName;
    }

    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName;
    }

    public String getLoginUserRole() {
        return loginUserRole;
    }

    public void setLoginUserRole(String loginUserRole) {
        this.loginUserRole = loginUserRole;
    }

    public String getLoginUserOrg() {
        return loginUserOrg;
    }

    public void setLoginUserOrg(String loginUserOrg) {
        this.loginUserOrg = loginUserOrg;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}