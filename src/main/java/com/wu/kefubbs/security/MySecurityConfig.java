package com.wu.kefubbs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder createPwdEncoder() {
        return new BCryptPasswordEncoder();
    }

  /*  @Bean
    public MyAuthenticationSuccessHandler myAuthenticationSuccessHandler() {
        return new MyAuthenticationSuccessHandler();
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()    //对登录请求放行
                .antMatchers("/res/**").permitAll()
                .antMatchers("/index/**").hasAnyAuthority("VIP")
                .antMatchers("/**")   //拦截根目录以及根目录下的子目录
                .fullyAuthenticated()  //对所有的资源进行请求拦截
                .and()
                .formLogin()   //以表单验证的方式对所有的拦截资源进行认证
                .loginPage("/login")   //自定义登录页面
                .successHandler(new MyAuthenticationSuccessHandler())  //登录成功返回json信息
                .failureHandler(new MyAuthenticationFailureHandler())  //登录失败返回json信息
                .and()
//                .csrf().disable()   //关闭跨域访问
        ;

    }

}
