package com.example.demo.ComController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class login {
    @Autowired(required = true)
    private UserMapper userMapper;
    @PostMapping("/login")
    public  int Login(@RequestParam("username") String username ,
                        @RequestParam("password")String password,
                        @RequestParam("role")String role){

        if(check(username,password,role)){
            UserEntity res=userMapper.selectOne(new QueryWrapper<UserEntity>().eq("username",username));
            return res.getUserid();
//            return "success";
        }
        return -1;
    }
    public boolean check(String username,String password,String role){

        QueryWrapper<UserEntity>wrapper=new QueryWrapper<>();
        UserEntity res=userMapper.selectOne(wrapper.eq("username",username));


        if(res!=null && res.getPassword().equals(password) && res.getRole().equals(role)){
            return true;
        }

        return false;
    }






}
