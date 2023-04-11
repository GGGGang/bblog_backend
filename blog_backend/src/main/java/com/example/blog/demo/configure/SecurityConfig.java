package com.example.blog.demo.configure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.blog.demo.service.MyUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author zhuqigang
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new MyPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                // 开启表单登陆
                .formLogin()
                // 重定向登陆页面
                //.loginPage("/login_page")
                // 登陆地址
                .loginProcessingUrl("/login")
                // 登陆成功的处理器
                .successHandler(new MyAuthenticationSuccessHandler())
                // 登陆失败的处理器
                .failureHandler(new MyAuthenticationFailureHandler())
                // 登陆时候用户密码的key
                .usernameParameter("username")
                .passwordParameter("password")
                // 与登陆有关的页面与接口直接通过
                .permitAll()
                .and()
                // 开启登出
                .logout()
                // 登出请求地址GET
                .logoutUrl("/logout")
                // 使session失效
                //.invalidateHttpSession(true)
                // 清楚认证信息
                //.clearAuthentication(true)
                // 登出成功地址
                //.logoutSuccessUrl("/123")
                .logoutSuccessHandler((req, resp, auth) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    Map<String, Object> result = new HashMap<>(4);
                    result.put("status", 200);
                    result.put("msg", "注销成功");
                    ObjectMapper om = new ObjectMapper();
                    String s = om.writeValueAsString(result);
                    resp.getWriter().write(s);
                })
                .permitAll()
                .and().cors()
                .configurationSource(this.configurationSource())
                //关闭csrf
                .and()
                .csrf().disable();
        // 开启允许iframe 嵌套
        //http.headers().frameOptions().disable();

    }

    CorsConfigurationSource configurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
        corsConfiguration.setAllowedMethods(Arrays.asList("*"));
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:8080"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }
}
