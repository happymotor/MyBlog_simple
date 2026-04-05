package com.myblog.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myblog.Mapper.UserRoleMapper;
import com.myblog.Service.UserRoleService;
import com.myblog.pojo.UserRole;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {
}
