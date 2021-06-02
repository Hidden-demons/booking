package com.hui.service;

import com.hui.pojo.Users;

public interface UserService {

    /*
    *
    *  @Description : 判断用户名是否存在
    *
    * */
    public boolean queryUsernameIsExist(String username);

    /*
    * @Description : 查询用户
    * */
    public Users queryUserForLogin(String userName,String pwd);

    /**
     * @Description: 用户注册
     */
    public Users saveUser(Users user);

}
