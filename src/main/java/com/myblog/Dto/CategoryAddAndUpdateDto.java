package com.myblog.Dto;

import com.myblog.Common.RegexPatternsConstants;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryAddAndUpdateDto {

    //栏目名称
    @NotEmpty
    @Pattern(regexp= RegexPatternsConstants.CATEGORY_NAME_REGEX)
    private  String categoryName;

    //栏目状态：1-启用，0-禁用
    private Byte status=1;
}
