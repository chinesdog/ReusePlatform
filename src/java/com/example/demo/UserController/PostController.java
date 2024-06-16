package com.example.demo.UserController;

import Obj.UserPost;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Mapper.PostMapper;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.entity.PostEntity;
import com.example.demo.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    PostMapper postMapper;
    @PostMapping("/getPosts")
    public List<UserPost> getPosts(
            @RequestParam("username") String username,
            @RequestParam("password") String password){

        if(check(username,password)){

            QueryWrapper<PostEntity>wrapper=new QueryWrapper<>();
            QueryWrapper<UserEntity>wrapper2=new QueryWrapper<>();
            UserEntity a=userMapper.selectOne(wrapper2.eq("username",username));

            List<PostEntity>res=postMapper.selectList(wrapper.eq("userid",a.getUserid()));

            List<UserPost>obj=new ArrayList<>();
            for(int i=0;i<res.size();i++){
                UserPost t=new UserPost();
                PostEntity apost=res.get(i);
                t.setBookid(apost.getPostid());
                t.setDate(apost.getDate().toString());
                t.setTag(apost.getTag());
                t.setName(apost.getName());
                t.setPrice(apost.getPrice());
                obj.add(t);
            }
            return obj;

        }
        return null;
    }

    public boolean check(String username,String password){

        QueryWrapper<UserEntity> wrapper=new QueryWrapper<>();
        UserEntity res=userMapper.selectOne(wrapper.eq("username",username));


        if(res!=null && res.getPassword().equals(password)){
            return true;
        }

        return false;
    }
    @PostMapping("/postPosts")
    public String postPosts(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("photo")String photo,
            @RequestParam("name")String name,
            @RequestParam("price")int price
    ){
        if(check(username,password)){
            QueryWrapper<UserEntity>wrapper=new QueryWrapper<>();
            UserEntity tmp=userMapper.selectOne(wrapper.eq("username",username));
            PostEntity res=new PostEntity();
            Date date=new Date();
            res.setDate(new java.sql.Date(date.getTime()));
            res.setName(name);
            res.setPrice(price);
            res.setPhoto(photo);
            res.setTag("wait");
            res.setUserid(tmp.getUserid());
            res.setPhone(tmp.getPhone());

            postMapper.insert(res);
            return "success";
        }


        return "fail";
    }

}
