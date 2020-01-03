package com.wu.kefubbs.service;

import com.wu.bbscommon.common.utils.LayUIResult;
import com.wu.kefubbs.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    LayUIResult list();

    LayUIResult insertUser(User user);
}
