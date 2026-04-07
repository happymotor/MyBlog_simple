package com.myblog.Controller;

import com.myblog.Common.Result;
import com.myblog.Dto.CategoryAddDto;
import com.myblog.Service.CategoryService;
import com.myblog.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    //栏目新增接口
    @PostMapping("/admin/category")
    public Result categoryAdd(@RequestBody @Validated CategoryAddDto categoryAddDto){
        //判断是否已经存在该栏目
        if(categoryService.getByCategoryName(categoryAddDto.getCategoryName())!=null){
            return Result.fail("不能新增已存在的栏目");
        }
        Category category=new Category();
        category.setCategoryName(categoryAddDto.getCategoryName());
        category.setStatus(categoryAddDto.getStatus());
        categoryService.categoryAdd(category);
        return Result.success();
    }

}
