package com.myblog.Controller;

import com.myblog.Common.Result;
import com.myblog.Common.RoleConstants;
import com.myblog.Dto.CategoryAddAndUpdateDto;
import com.myblog.Dto.CategoryQueryDto;
import com.myblog.Service.CategoryService;
import com.myblog.Utils.UserHolderUtil;
import com.myblog.VO.CategoryQueryVO;
import com.myblog.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    //栏目新增接口
    @PostMapping("/admin/category")
    public Result categoryAdd(@RequestBody @Validated CategoryAddAndUpdateDto categoryAddAndUpdateDto){
        //判断是否已经存在该栏目
        if(categoryService.getByCategoryName(categoryAddAndUpdateDto.getCategoryName())!=null){
            return Result.fail("不能新增已存在的栏目");
        }
        Category category=new Category();
        category.setCategoryName(categoryAddAndUpdateDto.getCategoryName());
        category.setStatus(categoryAddAndUpdateDto.getStatus());
        categoryService.categoryAdd(category);
        return Result.success();
    }

    //栏目列表查询（非分页）
    @GetMapping("/category/list")
    public Result<List<CategoryQueryVO>> categoryQuery(CategoryQueryDto categoryQueryDto){
        List<Long> roleIds= UserHolderUtil.getUserHolderRoleIds();

        Boolean hasAdminRole=roleIds.contains(RoleConstants.ROLE_ID_ADMIN)
                ||roleIds.contains(RoleConstants.ROLE_ID_ROOT);

        return Result.success(categoryService.categoryQuery(categoryQueryDto,hasAdminRole));
    }

    @PutMapping("/admin/category/{categoryId}")
    public Result categoryUpdate(@RequestBody @Validated CategoryAddAndUpdateDto categoryAddAndUpdateDto,
                                 @PathVariable Long categoryId){
        //判断是否已经存在该栏目
        if(categoryService.getByCategoryId(categoryId)==null){
            return Result.fail("不能修改不存在的栏目");
        }
        Category category=new Category();
        category.setCategoryId(categoryId);
        category.setCategoryName(categoryAddAndUpdateDto.getCategoryName());
        category.setStatus(categoryAddAndUpdateDto.getStatus());
        categoryService.categoryUpdate(category);
        return Result.success();
    }


}
