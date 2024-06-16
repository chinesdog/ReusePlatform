package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@TableName(value = "post")
@Table(name = "post", schema = "seconds", catalog = "")
public class PostEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "postid")
    private int postid;
    @Basic
    @Column(name = "date")
    private Date date;

    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "price")
    private Integer price;
    @Basic
    @Column(name = "photo")
    private String photo;
    @Basic
    @Column(name = "userid")
    private Integer userid;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "tag")
    private String tag;

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostEntity that = (PostEntity) o;
        return postid == that.postid && Objects.equals(date, that.date) && Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(photo, that.photo) && Objects.equals(userid, that.userid) && Objects.equals(phone, that.phone) && Objects.equals(tag, that.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postid, date, name, price, photo, userid, phone, tag);
    }
}
