package com.example.demo.UserController;

import Obj.UserWanted;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Mapper.WantedMapper;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.WantedEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShowWantedController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    WantedMapper wantedMapper;
    @PostMapping("/getwanted")
    public List<UserWanted>getwanted(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("userid") int userid
    ){
       if(check(username,password,userid)){
           List<UserWanted>obj=new ArrayList<>();
           List<WantedEntity>res=wantedMapper.selectList(new QueryWrapper<WantedEntity>().eq("userid",userid));

           for(int i=0;i<res.size();i++){
               WantedEntity wanted=res.get(i);
               UserWanted t=new UserWanted();
               t.setName(wanted.getName());
               t.setDate(wanted.getDate().toString());
               t.setBookid(wanted.getBookid());
               t.setPrice(wanted.getPrice());
               t.setTag(wanted.getTag());
               t.setPhone(wanted.getPhone());
               obj.add(t);

           }
           return obj;


       }
       return  null;
    }

    public boolean check(String username,String password,int userid){

        QueryWrapper<UserEntity> wrapper=new QueryWrapper<>();
        UserEntity res=userMapper.selectOne(wrapper.eq("username",username));


        if(res!=null && res.getPassword().equals(password) && res.getUserid()==userid ){
            return true;
        }

        return false;
    }
}
