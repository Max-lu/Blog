package cn.maxlu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "blog")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id", length = 5, nullable = false)
    private Integer id;

    @Column(name = "user_name", length = 25, nullable = false)
    private String userName;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
