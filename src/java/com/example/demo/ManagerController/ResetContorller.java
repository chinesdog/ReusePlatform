package com.example.demo.ManagerController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResetContorller {
    @Autowired
    UserMapper userMapper;

    @PostMapping("/manager/reset")
    public String resetPassword(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("userid") int userid
    ){
        if(check(username,password)){
            UserEntity user=new UserEntity();
            user.setUserid(userid);
            user.setPassword("123");
            userMapper.update(user,new QueryWrapper<UserEntity>().eq("userid",userid));
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
