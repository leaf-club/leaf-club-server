package com.leaf.club.model;

/**
 * @author LL
 */
public class BlogReplies {
    private int id;
    private int replyCommentId;
    private int replyUserId;
    private int repliedUserId;
    private int replyPraiseCount;
    private String replyContent;
    private long replyTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReplyCommentId() {
        return replyCommentId;
    }

    public void setReplyCommentId(int replyCommentId) {
        this.replyCommentId = replyCommentId;
    }

    public int getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(int replyUserId) {
        this.replyUserId = replyUserId;
    }

    public int getRepliedUserId() {
        return repliedUserId;
    }

    public void setRepliedUserId(int repliedUserId) {
        this.repliedUserId = repliedUserId;
    }

    public int getReplyPraiseCount() {
        return replyPraiseCount;
    }

    public void setReplyPraiseCount(int replyPraiseCount) {
        this.replyPraiseCount = replyPraiseCount;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public long getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(long commentTime) {
        this.commentTime = commentTime;
    }
}