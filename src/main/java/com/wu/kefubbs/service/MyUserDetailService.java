package com.wu.kefubbs.service;

import com.wu.kefubbs.mapper.UserMapper;
import com.wu.kefubbs.pojo.UserExample;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class MyUserDetailService implements UserDetailsService {

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        com.wu.kefubbs.pojo.User user = userMapper.selectByExample(example).get(0);
        if (user == null) return null;
        Collection<GrantedAuthority> authorities = authorities();
        return user;
//        return new User(user.getUsername(),user.getPassword(), authorities);
    }

    //给当前用户指定角色
    private Collection<GrantedAuthority> authorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("VIP"));
        authorities.add(new SimpleGrantedAuthority("USER"));
        return authorities;
    }
}
