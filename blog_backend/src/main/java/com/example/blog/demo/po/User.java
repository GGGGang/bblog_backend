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
@TableName("user")
public class User {

    private long id;
    private String username;
    private String nickname;
    private String password;
    private long enabled;
    private String email;
    private String userface;
    private java.sql.Timestamp regTime;

}
