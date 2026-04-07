package com.myblog.Service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myblog.Mapper.CategoryMapper;
import com.myblog.Service.CategoryService;
import com.myblog.pojo.Category;

import org.springframework.stereotype.Service;

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
}
