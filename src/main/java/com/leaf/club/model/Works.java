package com.leaf.club.model;

/**
 * @author LL
 */

public class Work {
    private int id;
    private long workCreateTime;
    private String workUrl;
    private String workTitle;
    private String workDescribe;
    private int workType;
    private String workTypeName;
    private String workTag;
    private int workStatus;
    private int workCommentCount;
    private int workPraiseCount;
    private int workFavoriteCount;
    private int workReadCount;
    private long workUpdataTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getWorkCreateTime() {
        return workCreateTime;
    }

    public void setWorkCreateTime(int workCreateTime) {
        this.workCreateTime = workCreateTime;
    }

    public String getWorkUrl() {
        return workUrl;
    }

    public void setWorkUrl(String workUrl) {
        this.workUrl = workUrl;
    }

    public String getWorkTitle() {
        return workTitle;
    }

    public void setWorkTitle(String workTitle) {
        this.workTitle = workTitle;
    }

    public String getworkDescribe() {
        return workDescribe;
    }

    public void setworkDescribe(String workDescribe) {
        this.workDescribe = workDescribe;
    }

    public int getWorkType() {
        return workType;
    }

    public void setWorkType(int workType) {
        this.workType = workType;
    }

    public String getWorkTypeName() {
        return workTypeName;
    }

    public void setWorkTypeName(String workTypeName) {
        this.workTypeName = workTypeName;
    }

    public String getWorkTag() {
        return workTag;
    }

    public void setWorkTag(String workTag) {
        this.workTag = workTag;
    }

    public int getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(int workStatus) {
        this.workStatus = workStatus;
    }

    public int getWorkCommentCount() {
        return workCommentCount;
    }

    public void setWorkCommentCount(int workCommentCount) {
        this.workCommentCount = workCommentCount;
    }

    public int getWorkPraiseCount() {
        return workPraiseCount;
    }

    public void setWorkPraiseCount(int workPraiseCount) {
        this.workPraiseCount = workPraiseCount;
    }

    public int getWorkFavoriteCount() {
        return workFavoriteCount;
    }

    public void setWorkFavoriteCount(int workFavoriteCount) {
        this.workFavoriteCount = workFavoriteCount;
    }

    public int getWorkReadCount() {
        return workReadCount;
    }

    public void setWorkReadCount(int workReadCount) {
        this.workReadCount = workReadCount;
    }

    public long getWorkUpdataTime() {
        return workUpdataTime;
    }

    public void setWorkUpdataTime(long workUpdataTime) {
        this.id = workUpdataTime;
    }
}