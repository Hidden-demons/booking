package com.hui.service.impl;

import com.hui.mapper.UsersMapper;
import com.hui.pojo.Users;
import com.hui.service.UserService;
import org.apache.commons.io.FileUtils;
import org.n3r.importer.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper userMapper;

    @Autowired
    private Sid sid;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {

        Users user = new Users();
        user.setUserName(username);

        Users result = userMapper.selectOne(user);

        return result != null;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users queryUserForLogin(String userName, String pwd) {
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("userName",userName);
        criteria.andEqualTo("password",pwd);

        return userMapper.selectOneByExample(example);
    }

    @Override
    public Users saveUser(Users user) {

        String userId = sid.nextShort();

        // 为每个用户生成一个唯一的二维码
//        String qrCodePath = "C://user" + userId + "qrcode.png";
        // muxin_qrcode:[username]
//        qrCodeUtils.createQRCode(qrCodePath, "muxin_qrcode:" + user.getUsername());
//        MultipartFile qrCodeFile = FileUtils.fileToMultipart(qrCodePath);
//
//        String qrCodeUrl = "";
//        try {
//            qrCodeUrl = fastDFSClient.uploadQRCode(qrCodeFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        user.setQrCode("");

        user.setId(userId);
        userMapper.insert(user);

        return user;
    }
}
