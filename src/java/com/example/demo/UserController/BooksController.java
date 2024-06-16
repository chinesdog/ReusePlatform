package com.example.demo.UserController;

import Obj.UserBooks;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Mapper.BookMapper;
import com.example.demo.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BooksController {
    @Autowired
    BookMapper bookMapper;
    @GetMapping("/getbooks")
    public List<UserBooks> getbooks(){
        QueryWrapper<BookEntity>wrapper=new QueryWrapper<>();
        List<BookEntity>res=bookMapper.selectList(wrapper);

        List<UserBooks>obj=new ArrayList<>();
        for(int i=0;i<res.size();i++){
            BookEntity book=res.get(i);
            UserBooks t=new UserBooks();
            t.setName(book.getName());
            t.setBookid(book.getBookid());
            t.setPhone(book.getPhone());
            t.setPhoto(book.getPhoto());
            t.setPrice(book.getPrice());
            t.setDealplace(book.getPlace());
            t.setUsername(book.getUsername());
            obj.add(t);
        }
        return obj;
    }
}
