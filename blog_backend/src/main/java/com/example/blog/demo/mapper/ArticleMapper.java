package com.example.blog.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.demo.po.Article;

/**
 * @author zhuqigang
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
