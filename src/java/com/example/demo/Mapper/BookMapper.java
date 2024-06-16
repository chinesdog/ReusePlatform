package com.example.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.BookEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMapper extends BaseMapper<BookEntity> {
}
