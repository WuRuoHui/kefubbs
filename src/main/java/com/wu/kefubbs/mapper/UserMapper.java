package com.wu.kefubbs.mapper;

import com.wu.kefubbs.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from bbs_user where username = #{username} ")
    User findUserByUsername(String username);
}
