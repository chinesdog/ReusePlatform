package com.example.demo.ManagerController;

import Obj.ManagerBooks;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Mapper.BookMapper;
import com.example.demo.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ManagerBooksController {
    @Autowired
    BookMapper bookMapper;
    @GetMapping("manager/getbooks")
    public List<ManagerBooks> getbooks(){
        QueryWrapper<BookEntity> wrapper=new QueryWrapper<>();
        List<BookEntity>res=bookMapper.selectList(wrapper);

        List<ManagerBooks>obj=new ArrayList<>();
        for(int i=0;i<res.size();i++){
            BookEntity book=res.get(i);
            ManagerBooks t=new ManagerBooks();
            t.setName(book.getName());
            t.setBookid(book.getBookid());

            t.setPhoto(book.getPhoto());
            t.setPrice(book.getPrice());

            t.setUsername(book.getUsername());
            t.setDate(book.getDate().toString());
            obj.add(t);
        }
        return obj;

    }
}
