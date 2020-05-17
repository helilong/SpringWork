package com.xiaohe.pojo;

import org.omg.DynamicAny.DynUnionOperations;

import javax.swing.*;

public class Record {
    private Integer id;
    private  int uid;
    private Spring uname;
    private double salay;
    private  Spring opt_type;
    private String opt_time;
    private User user;

    public Record(String uname, double salary, String s, String date) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Spring getUname() {
        return uname;
    }

    public void setUname(Spring uname) {
        this.uname = uname;
    }

    public double getSalay() {
        return salay;
    }

    public void setSalay(double salay) {
        this.salay = salay;
    }

    public Spring getOpt_type() {
        return opt_type;
    }

    public void setOpt_type(Spring opt_type) {
        this.opt_type = opt_type;
    }

    public String getOpt_time() {
        return opt_time;
    }

    public void setOpt_time(String opt_time) {
        this.opt_time = opt_time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", uid=" + uid +
                ", uname=" + uname +
                ", salay=" + salay +
                ", opt_type=" + opt_type +
                ", opt_time='" + opt_time + '\'' +
                '}';
    }
}
