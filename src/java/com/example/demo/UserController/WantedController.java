package com.example.demo.UserController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Mapper.BookMapper;
import com.example.demo.Mapper.NoticeMapper;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Mapper.WantedMapper;
import com.example.demo.entity.BookEntity;
import com.example.demo.entity.NoticeEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.WantedEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
public class WantedController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    WantedMapper wantedMapper;
    @Autowired
    NoticeMapper noticeMapper;
    @PostMapping("/selectWanted")
    public String selectWanted(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("bookid") int bookid
    ){
        if(check(username,password)){
            QueryWrapper<BookEntity>wrapper=new QueryWrapper<>();
            QueryWrapper<UserEntity>wrapper1=new QueryWrapper<>();
            QueryWrapper<UserEntity>oppwrapper=new QueryWrapper<>();
            BookEntity book=bookMapper.selectOne(wrapper.eq("bookid",bookid));
            UserEntity user=userMapper.selectOne(wrapper1.eq("username",username));


            WantedEntity wanted=new WantedEntity();
            wanted.setName(book.getName());
            wanted.setDate(new Date(book.getDate().getTime()));
            wanted.setPrice(book.getPrice());
            wanted.setTag("wait");
            wanted.setPhone(book.getPhone());
            wanted.setUserid(user.getUserid());
            wanted.setBookid(bookid);

            QueryWrapper<NoticeEntity>wrapper2=new QueryWrapper<>();
            NoticeEntity notice=new NoticeEntity();
            UserEntity oppuser=userMapper.selectOne(oppwrapper.eq("username",book.getUsername()));
            notice.setDate(new Date(new java.util.Date().getTime()));
            notice.setBookid(bookid);
            notice.setName(book.getName());
            notice.setPhone(user.getPhone());
            notice.setUserid(oppuser.getUserid());

            wantedMapper.insert(wanted);
            noticeMapper.insert(notice);
            return "success";
        }


        return "fail";
    }


    public boolean check(String username,String password){

        QueryWrapper<UserEntity> wrapper=new QueryWrapper<>();
        UserEntity res=userMapper.selectOne(wrapper.eq("username",username));


        if(res!=null && res.getPassword().equals(password)){
            return true;
        }

        return false;
    }
}
