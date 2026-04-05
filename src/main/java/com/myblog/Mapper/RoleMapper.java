package com.myblog.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myblog.pojo.Role;
import com.myblog.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}
