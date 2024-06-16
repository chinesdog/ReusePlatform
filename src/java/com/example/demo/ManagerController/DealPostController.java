package com.example.demo.ManagerController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.Mapper.BookMapper;
import com.example.demo.Mapper.PostMapper;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.entity.BookEntity;
import com.example.demo.entity.PostEntity;
import com.example.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

@RestController
public class DealPostController {
    @Autowired
    PostMapper postMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    BookMapper bookMapper;
    @PostMapping("/manager/dealposts")
    public String dealPost(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("postid") int postid,
            @RequestParam("tag")String tag
    ){
        if(check(username,password)){
            UpdateWrapper<PostEntity> updateWrapper=new UpdateWrapper<>();
            updateWrapper.eq("postid",postid);
            PostEntity updatepost=new PostEntity();
            updatepost.setTag(tag);
            updatepost.setPostid(postid);
            postMapper.update(updatepost,updateWrapper);

            if(tag.equals("accept")){
                QueryWrapper<PostEntity>wrapper2=new QueryWrapper<>();
                PostEntity post=postMapper.selectOne(wrapper2.eq("postid",postid));

                QueryWrapper<UserEntity>wrapper1=new QueryWrapper<>();
                UserEntity user=userMapper.selectOne(wrapper1.eq("userid",post.getUserid()));


                BookEntity book=new BookEntity();
                book.setDate(new Timestamp(new Date().getTime()));
                book.setName(post.getName());
                book.setPhone(user.getPhone());
                book.setPrice(post.getPrice());
                book.setUsername(user.getUsername());
                book.setPlace(user.getDealplace());
                book.setPhoto(post.getPhoto());
                bookMapper.insert(book);
            }


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
