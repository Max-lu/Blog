package cn.maxlu.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentResponse {

    private Integer id;

    private Integer articleId;

    private String isTop;

    private Integer parentCommentId;

    private Date createdDate;

    private String content;

    private List<CommentResponse> childComment = new ArrayList<>();

    private String childCommentIds;

    private Integer level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    public Integer getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Integer parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<CommentResponse> getChildComment() {
        return childComment;
    }

    public void setChildComment(List<CommentResponse> childComment) {
        this.childComment = childComment;
    }

    public String getChildCommentIds() {
        return childCommentIds;
    }

    public void setChildCommentIds(String childCommentIds) {
        this.childCommentIds = childCommentIds;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
