package com.leaf.club.model;

/**
 * @author LL
 */
public class UserFavoritesWorks {
    private int id;
    private int userId;
    private int favoriteWorkId;
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

    public int getFavoriteWorkId() {
        return favoriteWorkId;
    }

    public void setFavoriteWorkId(int favoriteWorkId) {
        this.favoriteWorkId = favoriteWorkId;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}