package com.example.demo.ManagerController;

import Obj.ManagerUsers;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShowUsersController {
    @Autowired
    UserMapper userMapper;
    @GetMapping("manager/getusers")
    public List<ManagerUsers>getusers(){

        List<UserEntity>res=userMapper.selectList(new QueryWrapper<UserEntity>());
        List<ManagerUsers>obj=new ArrayList<>();
        for (int i=0;i<res.size();i++){
            ManagerUsers t=new ManagerUsers();
            UserEntity user=res.get(i);
            t.setName(user.getName());
            t.setDealplace(user.getDealplace());
            t.setUserid(user.getUserid());
            t.setUsername(user.getUsername());
            t.setLiveplace(user.getLiveplace());
            obj.add(t);
        }
        return obj;

    }
}
