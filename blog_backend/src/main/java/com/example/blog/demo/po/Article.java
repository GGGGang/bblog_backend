package com.example.blog.demo.po;


import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author zhuqigang
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@TableName("article")
public class Article {
    private long id;
    private String title;
    private String mdContent;
    private String htmlContent;
    private String summary;
    private long cid;
    private long uid;
    private java.sql.Timestamp publishDate;
    private java.sql.Timestamp editTime;
    private long state;
    private long pageView;
}
