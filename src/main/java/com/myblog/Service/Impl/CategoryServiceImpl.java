package com.myblog.Service.Impl;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myblog.Dto.CategoryQueryDto;
import com.myblog.Mapper.CategoryMapper;
import com.myblog.Service.CategoryService;
import com.myblog.VO.CategoryQueryVO;
import com.myblog.pojo.Category;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {


    @Override
    public Category getByCategoryName(String categoryName) {
        return lambdaQuery()
                .eq(Category::getCategoryName,categoryName)
                .one();

    }

    @Override
    public void categoryAdd(Category category) {
        this.save(category);
    }

    @Override
    public List<CategoryQueryVO> categoryQuery(CategoryQueryDto categoryQueryDto, Boolean hasAdminRole) {
        //如果没有传任何参数，先对categoryQueryDto进行判空操作
        String keyword=null;
        Byte status=null;
        if(categoryQueryDto!=null){
             keyword= categoryQueryDto.getKeyword();
        }
        if(Boolean.FALSE.equals(hasAdminRole)){
             status=(byte)1;
        }else if(categoryQueryDto!=null){
            status=categoryQueryDto.getStatus();
        }

        List<Category> categoryList = lambdaQuery()
                //MyBatis-Plus 的`like`方法默认不做非空判断
                .like(StringUtils.hasText(keyword),Category::getCategoryName, keyword)
                //MyBatis-Plus都不会自动做非空判断
                .eq(Objects.nonNull(status),Category::getStatus, status)
                .list();


        return BeanUtil.copyToList(categoryList, CategoryQueryVO.class);
    }
}
