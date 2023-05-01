package com.example.blog.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.blog.demo.mapper.ArticleMapper;
import com.example.blog.demo.po.Article;

@SpringBootTest
public class MybatiesOlus {
    @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void testSelectList(){
        //List<Article> articles = articleMapper.selectList(null);
        //System.out.println(articles);
    }
}
