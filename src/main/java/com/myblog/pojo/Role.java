package com.myblog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_role")
public class Role {

    //角色id
    @TableId(type= IdType.AUTO)
    private Long roleId;
    //角色名称
    private String roleName;
    //角色标识
    private String roleCode;

    private String description;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    //逻辑删除：0-未删除，1-已删除
    @TableField("is_deleted")
    private Boolean isDeleted;

}
