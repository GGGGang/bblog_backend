package com.example.blog.demo.service;


import java.util.List;
import java.util.Map;

import com.example.blog.demo.vo.ArticleVO;

/**
 * @author zhuqigang
 */
public interface ArticleService {

    /**
     * 获取分页文章列表
     *
     * @param param 包含基础分页信息与查询参数
     * @return 文章列表
     */
    List<ArticleVO> getArticlesByPage(Map<String, Object> param);

    /**
     * 获取文章列表
     *
     * @param param 包含基础查询数据
     * @return 文章列表
     */
    List<ArticleVO> getArticles(Map<String, Object> param);
}
