package com.example.demo.ManagerController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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

@RestController
public class OffShelfController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    NoticeMapper noticeMapper;
    @Autowired
    WantedMapper wantedMapper;
    @Autowired
    BookMapper bookMapper;

    @PostMapping("/manager/offshelf")
    public String offshelf(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("bookid") int bookid
    ){
        if(check(username,password)){
            WantedEntity wanted=new WantedEntity();
            wanted.setBookid(bookid);
            wanted.setTag("offshelf");
            wantedMapper.update(wanted,new UpdateWrapper<WantedEntity>().eq("bookid",bookid));

            noticeMapper.delete(new QueryWrapper<NoticeEntity>().eq("bookid",bookid));
            bookMapper.delete(new QueryWrapper<BookEntity>().eq("bookid",bookid));
            return "success";

        }


        return "fail";
    }


    public boolean check(String username,String password){

        QueryWrapper<UserEntity> wrapper=new QueryWrapper<>();
        UserEntity res=userMapper.selectOne(wrapper.eq("username",username));


        if(res!=null && res.getPassword().equals(password) && res.getRole().equals("manager")){
            return true;
        }

        return false;
    }

}
