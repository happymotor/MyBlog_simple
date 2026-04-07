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
@TableName("tb_category")
public class Category {

    @TableId(type = IdType.AUTO)
    private Long categoryId;

    private String categoryName;


    private Byte status;


    private Integer articleCount;


    private LocalDateTime createTime;


    private LocalDateTime updateTime;

    @TableField("is_deleted")
    private Boolean isDeleted;
}
