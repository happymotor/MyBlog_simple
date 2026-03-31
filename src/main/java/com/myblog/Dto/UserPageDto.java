package com.myblog.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPageDto extends PageDto{
    //用户启用状态 1-启用 0-禁用
    private Byte status=Byte.valueOf((byte) 1);
}
