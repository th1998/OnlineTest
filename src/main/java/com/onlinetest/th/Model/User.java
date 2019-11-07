package com.onlinetest.th.Model;

public class User {
    private Integer Id;
    private String UserName;
    private String UserPass;
    private String UserNo;
    private String UserClass;
    private Integer UserRole;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPass() {
        return UserPass;
    }

    public void setUserPass(String userPass) {
        UserPass = userPass;
    }

    public String getUserNo() {
        return UserNo;
    }

    public void setUserNo(String userNo) {
        UserNo = userNo;
    }

    public String getUserClass() {
        return UserClass;
    }

    public void setUserClass(String userClass) {
        UserClass = userClass;
    }

    public Integer getUserRole() {
        return UserRole;
    }

    public void setUserRole(Integer userRole) {
        UserRole = userRole;
    }
}
