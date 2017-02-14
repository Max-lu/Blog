package cn.maxlu.response;

import java.util.Date;
import java.util.List;

public class ArticleResponse {

    private Integer id;

    private String title;

    private Date createdDate;

    private String content;

    private Integer commentAmount;

    private String category;

    private String tag;

    private List<CommentResponse> commentResponses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getCommentAmount() {
        return commentAmount;
    }

    public void setCommentAmount(Integer commentAmount) {
        this.commentAmount = commentAmount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<CommentResponse> getCommentResponses() {
        return commentResponses;
    }

    public void setCommentResponses(List<CommentResponse> commentResponses) {
        this.commentResponses = commentResponses;
    }
}
