package com.leaf.club.model;

/**
 * @author LL
 */
public class WorkReplies {
    private int id;
    private int replyCommentId;
    private int replyUserId;
    private int repliedUserId;
    private int replyPraiseCount;
    private String replyContent;
    private long replyTime;
    private String extra;

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

    public long getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(long replyTime) {
        this.replyTime = replyTime;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}