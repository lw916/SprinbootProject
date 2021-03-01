package com.demo.login.bean;

public class QueryUser {
    private String queryName;
    //分页设置
    private int pageStart;
    private int pageSize;

    public QueryUser() {
    }

    public QueryUser(String queryName, int pageStart, int pageSize) {
        this.queryName = queryName;
        this.pageStart = pageStart;
        this.pageSize = pageSize;
    }

    public String getQueryName() {
        return queryName;
    }

    public int getPageStart() {
        return pageStart;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "QueryUser{" +
                "queryName='" + queryName + '\'' +
                ", pageStart=" + pageStart +
                ", pageSize=" + pageSize +
                '}';
    }
}
