package com.leaf.club.model;

/**
 * @author LL
 */
public class UserFavoritesBlogs {
    private int id;
    private int userId;
    private int favoriteBlogId;
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

    public int getFavoriteBlogId() {
        return favoriteBlogId;
    }

    public void setFavoriteBlogId(int favoriteBlogId) {
        this.favoriteBlogId = favoriteBlogId;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}