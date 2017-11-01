package com.leaf.club.model;

/**
 * @author LL
 */
public class WorkComments {
    private int id;
    private int commentWorkId;
    private int commentUserId;
    private long commentTime;
    private int commentPraiseCount;
    private String commentContent;
    private String extra;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommentWorkId() {
        return commentWorkId;
    }

    public void setCommentWorkId(int commentWorkId) {
        this.commentWorkId = commentWorkId;
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

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}