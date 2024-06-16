package com.example.demo.ComController;

import Obj.UserCenter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Mapper.*;
import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserCenteController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    DealingMapper dealingMapper;
    @Autowired
    NoticeMapper noticeMapper;
    @Autowired
    WantedMapper wantedMapper;
    @Autowired
    PostMapper postMapper;

    @PostMapping("/getUserCenter")
    public UserCenter getUserCenter(
            @RequestParam("username") String username,
            @RequestParam("password") String password){

        if(check(username,password)){
            QueryWrapper<UserEntity>wrapper=new QueryWrapper<>();
            UserEntity res=userMapper.selectOne(wrapper.eq("username",username));
            UserCenter obj=new UserCenter();
            obj.setDealplace(res.getDealplace());
            obj.setName(res.getName());
            obj.setLiveplace(res.getLiveplace());
            obj.setPhone(res.getPhone());
            obj.setUserid(res.getUserid());
            obj.setUsername(res.getUsername());
            return obj;
        }
        return  null;

    }

    public boolean check(String username,String password){

        QueryWrapper<UserEntity> wrapper=new QueryWrapper<>();
        UserEntity res=userMapper.selectOne(wrapper.eq("username",username));


        if(res!=null && res.getPassword().equals(password)){
            return true;
        }

        return false;
    }

    @PostMapping("/manager/modify")
    public String modifyCenter(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("name") String name,
            @RequestParam("liveplace") String liveplace,
            @RequestParam("dealplace") String dealplace
    ){
        if(check(username,password)){
            UserEntity oriuser=userMapper.selectOne(new QueryWrapper<UserEntity>().eq("username",username));
            UserEntity user=new UserEntity();
            user.setName(name);
            user.setLiveplace(liveplace);
            user.setDealplace(dealplace);
            user.setUserid(oriuser.getUserid());
            userMapper.update(user,new QueryWrapper<UserEntity>().eq("userid",oriuser.getUserid()));

            List<BookEntity>bookEntityList=bookMapper.selectList(new QueryWrapper<BookEntity>().eq("username",username));
            for(int i=0;i<bookEntityList.size();i++){
                BookEntity book=new BookEntity();
                book.setBookid(bookEntityList.get(i).getBookid());
                book.setPlace(dealplace);
                bookMapper.update(book,new QueryWrapper<BookEntity>().eq("bookid",book.getBookid()));
            }


            return "success";
        }


        return "fail";
    }



}
