package com.myblog.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myblog.Mapper.RoleMapper;
import com.myblog.Mapper.UserMapper;
import com.myblog.Service.RoleService;
import com.myblog.pojo.Role;
import com.myblog.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Override
    public Role getRoleById(Long roleId) {
        return getById(roleId);
    }
}
