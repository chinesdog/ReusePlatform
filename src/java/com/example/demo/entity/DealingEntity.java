package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@TableName(value = "dealing")
@Table(name = "dealing", schema = "seconds", catalog = "")
public class DealingEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dealingid")
    private int dealingid;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "bookid")
    private Integer bookid;
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
    @Column(name = "phone")
    private String phone;

    @Basic
    @Column(name = "userid")
    private int userid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getDealingid() {
        return dealingid;
    }

    public void setDealingid(int dealingid) {
        this.dealingid = dealingid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
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
        DealingEntity that = (DealingEntity) o;
        return dealingid == that.dealingid && Objects.equals(date, that.date) && Objects.equals(bookid, that.bookid) && Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(photo, that.photo) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dealingid, date, bookid, name, price, photo, phone);
    }
}
