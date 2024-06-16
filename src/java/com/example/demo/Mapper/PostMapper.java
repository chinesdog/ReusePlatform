package com.example.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.PostEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface PostMapper extends BaseMapper<PostEntity> {
}
