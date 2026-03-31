package com.myblog.Service.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myblog.Dto.PageDto;
import com.myblog.Dto.UserPageDto;
import com.myblog.Dto.UserRegisterDto;
import com.myblog.Mapper.UserMapper;
import com.myblog.Service.UserService;

import com.myblog.Utils.Md5Util;
import com.myblog.VO.PageVO;
import com.myblog.VO.UserInfoVO;
import com.myblog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    private UserMapper userMapper;


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
    public PageVO<UserInfoVO> userQueryPages(UserPageDto userPageDto) {
        String keyword = userPageDto.getKeyword();
        Byte status = userPageDto.getStatus();
        //1.构建分页条件
        Page<User> page=Page.of(userPageDto.getPageNum(),userPageDto.getPageSize());
        //排序规则
        page.addOrder( OrderItem.desc("update_time"));

        //2.分页查询
        Page<User> p = lambdaQuery().eq(status != null, User::getStatus, status)
                                    .like(keyword != null, User::getUsername, keyword)
                                    .page(page);

        //3.封装VO结果
        PageVO<UserInfoVO> vo=new PageVO<>();
        //总条数
        vo.setTotal(p.getTotal());
        //当前页数据
        if(CollUtil.isEmpty(p.getRecords())){
            vo.setList(Collections.emptyList());
            return vo;
        }
        List<UserInfoVO> list= BeanUtil.copyToList(p.getRecords(),UserInfoVO.class);
        vo.setList(list);
        //页号
        vo.setPageNum(userPageDto.getPageNum());
        //每页条数
        vo.setPageSize(userPageDto.getPageSize());
        //总页数
        vo.setPages(p.getPages());

        vo.calculatePageInfo();
        //4.返回
        return vo;
    }
}
