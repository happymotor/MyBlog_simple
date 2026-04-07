package com.myblog.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myblog.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
