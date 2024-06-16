package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@TableName(value = "wanted")
@Table(name = "wanted", schema = "seconds", catalog = "")
public class WantedEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "bookid")
    private int bookid;
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
    @Column(name = "tag")
    private String tag;
    @Basic
    @Column(name = "userid")
    private Integer userid;
    @Basic
    @Column(name = "phone")
    private String phone;

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WantedEntity that = (WantedEntity) o;
        return bookid == that.bookid && Objects.equals(date, that.date) && Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(tag, that.tag) && Objects.equals(userid, that.userid) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookid, date, name, price, tag, userid, phone);
    }
}
