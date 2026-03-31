package com.myblog.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoVO {
    private Integer userId;
    private String username;
    private String nickname;
    private String email;
    private List<String> roles;
    private Byte status;
    private LocalDateTime createTime;
}
