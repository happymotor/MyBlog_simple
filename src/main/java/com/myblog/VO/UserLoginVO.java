package com.myblog.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginVO {
    private String accessToken;
    private String refreshToken;
    private final String tokenType="Bearer";
    private final Integer expiresIn =Integer.valueOf(7200);//固定有效期 2h
    private UserInfoVO userInfoVO;
}
