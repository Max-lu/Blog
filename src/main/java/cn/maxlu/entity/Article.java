package cn.maxlu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "article", schema = "blog")
public class Article {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 5, nullable = false)
    private Integer id;

    @Column(name = "title", length = 25, nullable = false)
    private String title;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "comment_amount", length = 5, nullable = false)
    private Integer commentAmount;

    @Column(name = "category", length = 25)
    private String category;

    @Column(name = "tag", length = 50)
    private String tag;

    @Column(name = "updated_date", nullable = false)
    private Date updatedDate;


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

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
