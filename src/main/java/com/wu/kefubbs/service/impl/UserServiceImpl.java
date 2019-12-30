/**
 * @program: kefubbs
 * @description: 用户服务实现类
 * @author: Wu
 * @create: 2019-12-12 23:59
 **/
package com.wu.kefubbs.service.impl;

import com.wu.kefubbs.commons.LayUIResult;
import com.wu.kefubbs.mapper.UserMapper;
import com.wu.kefubbs.pojo.User;
import com.wu.kefubbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public LayUIResult login(String username, String password) {
        User user = userMapper.findUserByUsername(username);
        if (user == null) {
            return LayUIResult.build(400,"用户名或密码错误");
        } else {
            if (!user.getPassword().equals(password.trim())) {
                return LayUIResult.build(400,"用户名或密码错误");
            }
                return LayUIResult.build(200,"登录成功");

        }
    }
}
