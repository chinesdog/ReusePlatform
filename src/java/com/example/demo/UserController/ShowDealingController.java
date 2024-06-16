package com.example.demo.UserController;

import Obj.UserDealing;
import Obj.Usernotice;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Mapper.DealingMapper;
import com.example.demo.Mapper.NoticeMapper;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Mapper.WantedMapper;
import com.example.demo.entity.DealingEntity;
import com.example.demo.entity.NoticeEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.WantedEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShowDealingController {

    @Autowired
    UserMapper userMapper;
    @Autowired
    DealingMapper dealingMapper;
    @Autowired
    WantedMapper wantedMapper;
    @PostMapping("/getDealing")
    public List<UserDealing> getDealing(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("userid") int userid
    ){
        if(check(username,password,userid)){
//            UserEntity user=userMapper.selectOne(new QueryWrapper<UserEntity>().eq("userid",userid));
//            WantedEntity wantedEntity=wantedMapper.selectOne(new QueryWrapper<WantedEntity>().eq("userid",userid));
            List<DealingEntity>res=dealingMapper.selectList(new QueryWrapper<DealingEntity>().eq("userid",userid));
            List<UserDealing>obj=new ArrayList<>();
            for(int i=0;i<res.size();i++){
                DealingEntity wanted=res.get(i);
                UserDealing t=new UserDealing();

                t.setDate(wanted.getDate().toString());
                t.setBookid(wanted.getBookid());
                t.setPrice(wanted.getPrice());
                t.setPhoto(wanted.getPhoto());

                t.setPhone(wanted.getPhone());
                obj.add(t);

            }
            return obj;


        }
        return null;
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
