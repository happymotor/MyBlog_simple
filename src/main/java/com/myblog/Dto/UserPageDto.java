package com.myblog.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPageDto extends PageDto{
    //用户启用状态 1-启用 0-禁用
    //private Byte status=Byte.valueOf((byte) 1);
    //不应该设置默认参数，如果status不传参则为null，将sql查询时将不会拼接WHERE status=1，以达到查询全部状态的效果
    private Byte status;
}
