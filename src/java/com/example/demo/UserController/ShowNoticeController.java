package com.example.demo.UserController;

import Obj.UserWanted;
import Obj.Usernotice;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Mapper.NoticeMapper;
import com.example.demo.Mapper.UserMapper;
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
public class ShowNoticeController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    NoticeMapper noticeMapper;
    @PostMapping("/getnotice")
    public List<Usernotice> getnotice(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("userid") int userid
    ){
        if(check(username,password,userid)){
            List<NoticeEntity>res=noticeMapper.selectList(new QueryWrapper<NoticeEntity>().eq("userid",userid));
            List<Usernotice>obj=new ArrayList<>();
            for(int i=0;i<res.size();i++){
                NoticeEntity wanted=res.get(i);
                Usernotice t=new Usernotice();
                t.setName(wanted.getName());
                t.setDate(wanted.getDate().toString());
                t.setBookid(wanted.getBookid());


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
