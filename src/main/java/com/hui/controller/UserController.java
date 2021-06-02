package com.hui.controller;

import com.hui.pojo.Users;
import com.hui.pojo.vo.UsersVO;
import com.hui.service.UserService;
import com.hui.utils.IMoocJSONResult;
import com.hui.utils.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("u")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/racistOrLogin")
    public IMoocJSONResult racistOrLogin(@RequestBody Users users) throws Exception{
        String name = users.getUserName();
        String pwd = users.getPassword();

        if (StringUtils.isBlank(name) || StringUtils.isBlank(pwd)){
            return IMoocJSONResult.errorMsg("用户名或者密码不能为空...");
        }

        //判断用户名是否存在,如果存在就登录，如果不存在则注册
        boolean usernameIsExist = userService.queryUsernameIsExist(name);

        Users userResult;

        if (usernameIsExist){
            //登录
            userResult  = userService.queryUserForLogin(name, MD5Utils.getMD5Str(pwd));
            if (userResult == null){
                return IMoocJSONResult.errorMsg("用户名或者密码不正确...");
            }
        }else {
            //注册
            users.setNickName(users.getUserName());
            users.setFaceImage("");
            users.setFaceImageBig("");
            users.setPassword(MD5Utils.getMD5Str(users.getPassword()));
            userResult = userService.saveUser(users);
        }
        UsersVO userVO = new UsersVO();
        BeanUtils.copyProperties(userResult, userVO);

        return IMoocJSONResult.ok(userVO);
    }
}
