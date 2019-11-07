package com.onlinetest.th.Model;



import java.util.List;

public class pageBean {
    private Integer pageSize;
    private List<User> userList;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
