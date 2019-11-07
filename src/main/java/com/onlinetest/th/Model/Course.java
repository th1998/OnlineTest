package com.onlinetest.th.Model;

public class Course {
    private Integer c_id;
    private String c_name;
    private String c_teacher;
    private Integer c_type;
    private Integer c_status;
    private String c_imgurl;
    private String c_videourl;
    private String c_explain;

    public String getC_imgurl() {
        return c_imgurl;
    }

    public void setC_imgurl(String c_imgurl) {
        this.c_imgurl = c_imgurl;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_teacher() {
        return c_teacher;
    }

    public void setC_teacher(String c_teacher) {
        this.c_teacher = c_teacher;
    }

    public Integer getC_type() {
        return c_type;
    }

    public void setC_type(Integer c_type) {
        this.c_type = c_type;
    }

    public Integer getC_status() {
        return c_status;
    }

    public void setC_status(Integer c_status) {
        this.c_status = c_status;
    }

    public String getC_videourl() {
        return c_videourl;
    }

    public void setC_videourl(String c_videourl) {
        this.c_videourl = c_videourl;
    }

    public String getC_explain() {
        return c_explain;
    }

    public void setC_explain(String c_explain) {
        this.c_explain = c_explain;
    }
}
