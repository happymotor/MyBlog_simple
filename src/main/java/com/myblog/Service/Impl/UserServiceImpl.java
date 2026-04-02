package com.myblog.Service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.myblog.Dto.UserRegisterDto;
import com.myblog.Mapper.UserMapper;
import com.myblog.Service.UserService;

import com.myblog.Utils.JwtUtil;
import com.myblog.Utils.Md5Util;

import com.myblog.Common.RedisPrefixConstants;
import com.myblog.pojo.User;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public User getByUserName(String username) {
        return userMapper.getByUserName(username);
    }

    @Override
    public void userRegister(UserRegisterDto userRegisterDto) {
        User user = new User();
        user.setUsername(userRegisterDto.getUsername());
        user.setPassword(Md5Util.getMD5String(userRegisterDto.getPassword()));
        user.setNickname(userRegisterDto.getNickname());
        user.setEmail(userRegisterDto.getEmail());
        userMapper.insert(user);
    }

    @Override
    public void userLogout(HttpServletRequest request) {
        //获取请求头，令牌验证
        //去掉“Bearer ”
        String accessToken=request.getHeader("Authorization").substring(7);
        JwtUtil.addTokenToBlackList(accessToken);
    }


}
