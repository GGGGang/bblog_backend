package com.example.blog.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.demo.po.Article;
import com.example.blog.demo.vo.ArticleVO;

/**
 * @author zhuqigang
 */
public interface ArticleMapper  {

    /**
     * 查询文档列表
     *
     * @param filter 过滤参数
     * @return 简单文章列表
     */
    List<ArticleVO> queryArticleList(Map<String,Object> filter);
}
