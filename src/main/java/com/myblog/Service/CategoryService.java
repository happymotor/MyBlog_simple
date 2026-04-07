package com.myblog.Service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.myblog.Common.RegexPatternsConstants;
import com.myblog.pojo.Category;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public interface CategoryService extends IService<Category> {
    Category getByCategoryName(@NotEmpty @Pattern(regexp= RegexPatternsConstants.CATEGORY_NAME_REGEX) String categoryName);

    void categoryAdd(Category category);
}
