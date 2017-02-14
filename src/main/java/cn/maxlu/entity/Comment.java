package cn.maxlu.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "comments", schema = "blog")
public class Comment {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 5, nullable = false)
    private Integer id;

    @Column(name = "article_id", length = 5, nullable = false)
    private Integer articleId;

    @Column(name = "is_top", length = 1, nullable = false)
    private String isTop;

    @Column(name = "parent_comment_id", length = 5, nullable = true)
    private Integer parentCommentId;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "child_comment_ids", nullable = true)
    private String childCommentIds;

    @Column(name = "level", nullable = false)
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
