package com.wu.kefubbs.security;

import com.wu.kefubbs.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;


@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService myUserDetailService;
    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder createPwdEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl persistentTokenRepository = new JdbcTokenRepositoryImpl();
        persistentTokenRepository.setDataSource(dataSource);
        return persistentTokenRepository;
    }

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
                .rememberMe().tokenValiditySeconds(86400)
//                .tokenRepository(persistentTokenRepository())
                .userDetailsService(myUserDetailService)
                .and()
                .logout().deleteCookies("remember-me")
        ;
//                .csrf().disable()   //关闭跨域访问
        ;
    }

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new MyUserDetailService());
    }*/
}
