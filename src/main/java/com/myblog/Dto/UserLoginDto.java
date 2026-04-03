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
public class UserLoginDto {
    @NotEmpty(message = "用户名不能为空")
    @Pattern(regexp =RegexPatternsConstants.USERNAME_REGEX)
    private String username;
    @NotEmpty(message = "密码不能为空")
    @Pattern(regexp =RegexPatternsConstants.PASSWORD_REGEX)
    private String password;

    private Boolean rememberMe;
}
