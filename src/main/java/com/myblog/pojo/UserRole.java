package com.myblog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_user_role")
public class UserRole {
    @TableId(type= IdType.AUTO)
    private Long id;
    private Long userId;
    private Long roleId;
    private LocalDateTime createTime=LocalDateTime.now();
}
