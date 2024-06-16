package com.example.demo.ComController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@RestController
public class register {
    @Autowired
    UserMapper userMapper;
    @PostMapping("/register")
    public  String register(@RequestParam("username") String username ,
                         @RequestParam("password")String password,
                         @RequestParam("phone")String phone) {


        if(check(username,phone)){
            UserEntity a=new UserEntity();
            a.setUsername(username);
            a.setPhone(phone);
            a.setPassword(password);
            a.setRole("user");
            userMapper.insert(a);
            return "success";
        }

        return "fail";

    }

    public boolean check(String username,String phone){


        if(phone==null || phone.isEmpty())return false;
        //手机号校验
        if(!Pattern.matches("^1[3-9]\\d{9}$",phone)) return false;

        QueryWrapper<UserEntity>wrapper=new QueryWrapper<>();
        List<UserEntity> res1=userMapper.selectList( wrapper.eq("username",username).or().eq("phone",phone));
        if(res1.size() ==0){
            return true;
        }
        return false;
    }
}
