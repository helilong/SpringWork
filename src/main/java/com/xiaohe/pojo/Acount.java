package com.xiaohe.pojo;

public class Acount {
    private Integer id;
    private double salary;
    private int uid;

    private User user;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Acount(double salary) {
        this.salary = salary;
    }

    public Acount() {
    }

    @Override
    public String toString() {
        return "Acount{" +
                "id=" + id +
                ", salary='" + salary + '\'' +
                ", uid=" + uid +
                '}';
    }
}
