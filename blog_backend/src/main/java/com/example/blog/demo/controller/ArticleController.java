package com.example.blog.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.demo.po.Article;
import com.example.blog.demo.service.ArticleService;

/**
 * @author zhuqigang
 */
@RestController
@RequestMapping("article")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/get-list/by-page")
    public List<Article> getArticlesByPage(@RequestParam Map<String,Object> param){
        return articleService.getArticlesByPage(param);
    }

    @GetMapping("/get-list")
    public List<Article> getArticles(@RequestParam Map<String,Object> param){
        return articleService.getArticles(param);
    }
}
