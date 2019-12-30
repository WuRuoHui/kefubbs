/**
 * @program: kefubbs
 * @description: 用户实体类
 * @author: Wu
 * @create: 2019-12-10 18:20
 **/
package com.wu.kefubbs.pojo;

import lombok.Data;

@Data
public class User {
   private Long id;          //主键ID
   private String username;     //登录用户名
   private String password;     //登录密码
   private Long gmtCreate;      //创建时间
   private Long gmtModified;    //修改时间
   private String avatarUrl;    //缩略图url
   private String vipLever;     //VIP等级
}
