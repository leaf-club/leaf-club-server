package com.leaf.club.model;

public class PraiseBlog {

    private int id;
    private int userId;
    private int BlogId;
    private String extra;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBlogId() {
        return BlogId;
    }

    public void setBlogId(int blogId) {
        BlogId = blogId;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
