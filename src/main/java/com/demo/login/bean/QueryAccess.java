package com.demo.login.bean;

public class QueryAccess {
    private int id;
    private String name;
    private String time;
    private String user;

    public QueryAccess() {
    }

    public QueryAccess(int id, String name, String time, String user) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "QueryAccess{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
