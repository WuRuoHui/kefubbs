package com.wu.kefubbs.service;

import com.wu.kefubbs.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.wu.kefubbs.pojo.User user = userMapper.findUserByUsername(username);
        if (user == null) return null;
        String password = passwordEncoder.encode(user.getPassword());
        Collection<GrantedAuthority> authorities = authorities();
        return new User(username,password, authorities);
    }

    //给当前用户指定角色
    private Collection<GrantedAuthority> authorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("VIP"));
        authorities.add(new SimpleGrantedAuthority("USER"));
        return authorities;
    }
}
