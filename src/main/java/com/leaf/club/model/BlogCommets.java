package com.leaf.club.model;

/**
 * @author LL
 */
public class BlogComments {
    private int id;
    private int commentBlogId;
    private int commentUserId;
    private long commentTime;
    private int commentPraiseCount;
    private String commentContent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommentBlogId() {
        return commentBlogId;
    }

    public void setCommentBlogId(int commentBlogId) {
        this.commentBlogId = commentBlogId;
    }

    public int getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(int commentUserId) {
        this.commentUserId = commentUserId;
    }

    public long getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(long commentTime) {
        this.commentTime = commentTime;
    }

    public int getCommentPraiseCount() {
        return commentPraiseCount;
    }

    public void setCommentPraiseCount(int commentPraiseCount) {
        this.commentPraiseCount = commentPraiseCount;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
