package com.example.demo.UserController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.Mapper.*;
import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
public class NoticeController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    DealingMapper dealingMapper;
    @Autowired
    NoticeMapper noticeMapper;
    @Autowired
    WantedMapper wantedMapper;
    @PostMapping("/dealNotice")
    public String dealNotice(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("tag") String tag,
            @RequestParam("bookid")int bookid
    ){
        if(check(username,password)){

            if(tag.equals("accept")){
                QueryWrapper<BookEntity>wrapper=new QueryWrapper<>();
                QueryWrapper<UserEntity>wrapper1=new QueryWrapper<>();
                QueryWrapper<UserEntity>wrapper2=new QueryWrapper<>();
                BookEntity book=bookMapper.selectOne(wrapper.eq("bookid",bookid));
                UserEntity user1=userMapper.selectOne(wrapper1.eq("username",username));
                NoticeEntity noticeEntity=noticeMapper.selectOne(new QueryWrapper<NoticeEntity>().eq("bookid",bookid));


                UserEntity oppeuser=userMapper.selectOne(wrapper2.eq("phone",noticeEntity.getPhone()));

                DealingEntity dealing=new DealingEntity();
                dealing.setDate(new Date(new java.util.Date().getTime()));
                dealing.setBookid(bookid);
                dealing.setName(book.getName());
                dealing.setPrice(book.getPrice());
                dealing.setPhoto(book.getPhoto());
                dealing.setPhone(user1.getPhone());
                dealing.setUserid(oppeuser.getUserid());

                DealingEntity dealing2=new DealingEntity();
                dealing2.setDate(new Date(new java.util.Date().getTime()));
                dealing2.setBookid(bookid);
                dealing2.setName(book.getName());
                dealing2.setPrice(book.getPrice());
                dealing2.setPhoto(book.getPhoto());
                dealing2.setPhone(oppeuser.getPhone());
                dealing2.setUserid(user1.getUserid());

                dealingMapper.insert(dealing);
                dealingMapper.insert(dealing2);


                WantedEntity wanted=new WantedEntity();
                wanted.setBookid(bookid);
                wanted.setTag("accept");
                wantedMapper.update(wanted,new UpdateWrapper<WantedEntity>().eq("bookid",bookid));

                bookMapper.delete(new QueryWrapper<BookEntity>().eq("bookid",bookid));
                noticeMapper.delete(new QueryWrapper<NoticeEntity>().eq("bookid",bookid));
            }
            else if(tag.equals("reject")){

                WantedEntity wanted=new WantedEntity();
                wanted.setBookid(bookid);
                wanted.setTag("reject");
                wantedMapper.update(wanted,new UpdateWrapper<WantedEntity>().eq("bookid",bookid));

                noticeMapper.delete(new QueryWrapper<NoticeEntity>().eq("bookid",bookid));


            }
            return "success";

        }


        return "fail";
    }

    public boolean check(String username,String password){

        QueryWrapper<UserEntity> wrapper=new QueryWrapper<>();
        UserEntity res=userMapper.selectOne(wrapper.eq("username",username));


        if(res!=null && res.getPassword().equals(password)){
            return true;
        }

        return false;
    }
}
