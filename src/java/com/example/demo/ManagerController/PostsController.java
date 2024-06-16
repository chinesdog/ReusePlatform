package com.example.demo.ManagerController;

import Obj.MangerPost;
import Obj.UserPost;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Mapper.PostMapper;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.entity.PostEntity;
import com.example.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostsController {
    @Autowired
    PostMapper postMapper;

    @Autowired
    UserMapper userMapper;
    @PostMapping("/manager/getposts")
    public List<MangerPost> getposts(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ){
        if(check(username,password)){
            QueryWrapper<PostEntity>wrapper=new QueryWrapper<>();
            List<PostEntity>res=postMapper.selectList(wrapper.eq("tag","wait"));
            List<MangerPost>obj=new ArrayList<>();
            for(int i=0;i<res.size();i++){
                PostEntity apost=res.get(i);
                MangerPost t=new MangerPost();
                t.setUserid(apost.getUserid());
                t.setName(apost.getName());
                t.setPhone(apost.getPhone());
                t.setPhoto(apost.getPhoto());
                t.setPrice(apost.getPrice());
                t.setPostid(apost.getPostid());
                obj.add(t);
            }
            return obj;

        }


        return null;
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
