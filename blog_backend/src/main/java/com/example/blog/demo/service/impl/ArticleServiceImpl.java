package com.example.blog.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.blog.demo.mapper.ArticleMapper;
import com.example.blog.demo.vo.ArticleVO;
import com.example.blog.demo.service.ArticleService;
import com.example.blog.demo.util.PageUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * @author zhuqigang
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleMapper articleMapper;

    public ArticleServiceImpl(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Override
    public List<ArticleVO> getArticlesByPage(Map<String, Object> param) {
        Map<String, Integer> pageParam = PageUtil.initPageNumAndSize(param);
        Page<ArticleVO> articles = PageHelper.startPage(pageParam.get(PageUtil.PAGE_NUM_KEY), pageParam.get(PageUtil.PAGE_SIZE_KEY))
                .doSelectPage(() -> getArticles(param));
        return (List<ArticleVO>) articles.getResult();
    }

    @Override
    public List<ArticleVO> getArticles(Map<String, Object> param) {
        return articleMapper.queryArticleList(param);
    }

}
