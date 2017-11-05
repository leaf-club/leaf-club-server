package com.leaf.club.model;

/**
 * @author LL
 */
public class Blog {
    private int id;
    private int blogAuthorId;
    private long blogCreateTime;
    private String blogTitle;
    private String blogExcerpt;
    private String blogContent;
    private String blogSource;
    private String blogFileUrl;
    private int blogType;
    private String blogTypeName;
    private String blogTag;
    private String blogDescribe;
    private int blogStatus;
    private int blogCommentCount;
    private int blogPraiseCount;
    private int blogFavoritesCount;
    private int blogReadCount;
    private long blogUpdateTime;
    private String extra;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlogAuthorId() {
        return blogAuthorId;
    }

    public void setBlogAuthorId(int blogAuthorId) {
        this.blogAuthorId = blogAuthorId;
    }

    public long getBlogCreateTime() {
        return blogCreateTime;
    }

    public void setBlogCreateTime(long blogCreateTime) {
        this.blogCreateTime = blogCreateTime;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogExcerpt() {
        return blogExcerpt;
    }

    public void setBlogExcerpt(String blogExcerpt) {
        this.blogExcerpt = blogExcerpt;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public String getBlogSource() {
        return blogSource;
    }

    public void setBlogSource(String blogSource) {
        this.blogSource = blogSource;
    }

    public String getBlogFileUrl() {
        return blogFileUrl;
    }

    public void setBlogFileUrl(String blogFileUrl) {
        this.blogFileUrl = blogFileUrl;
    }

    public int getBlogType() {
        return blogType;
    }

    public void setBlogType(int blogType) {
        this.blogType = blogType;
    }

    public String getBlogTypeName() {
        return blogTypeName;
    }

    public void setBlogTypeName(String blogTypeName) {
        this.blogTypeName = blogTypeName;
    }

    public String getBlogTag() {
        return blogTag;
    }

    public void setBlogTag(String blogTag) {
        this.blogTag = blogTag;
    }

    public String getBlogDescribe() {
        return blogDescribe;
    }

    public void setBlogDescribe(String blogDescribe) {
        this.blogDescribe = blogDescribe;
    }

    public int getBlogStatus() {
        return blogStatus;
    }

    public void setBlogStatus(int blogStatus) {
        this.blogStatus = blogStatus;
    }

    public int getBlogCommentCount() {
        return blogCommentCount;
    }

    public void setBlogCommentCount(int blogCommentCount) {
        this.blogCommentCount = blogCommentCount;
    }

    public int getBlogPraiseCount() {
        return blogPraiseCount;
    }

    public void setBlogPraiseCount(int blogPraiseCount) {
        this.blogPraiseCount = blogPraiseCount;
    }

    public int getBlogFavoritesCount() {
        return blogFavoritesCount;
    }

    public void setBlogFavoritesCount(int blogFavoritesCount) {
        this.blogFavoritesCount = blogFavoritesCount;
    }

    public int getBlogReadCount() {
        return blogReadCount;
    }

    public void setBlogReadCount(int blogReadCount) {
        this.blogReadCount = blogReadCount;
    }

    public long getBlogUpdateTime() {
        return blogUpdateTime;
    }

    public void setBlogUpdateTime(long blogUpdateTime) {
        this.blogUpdateTime = blogUpdateTime;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

}