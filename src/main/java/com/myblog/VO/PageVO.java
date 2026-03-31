package com.myblog.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PageVO<T>{
    //总记录数
    private Long total;
    //当前页数据列表
    private List<T> list;
    //当前页码
    private Long pageNum;
    //每页条数
    private Long pageSize;
    //总页数
    private Long pages;
    //是否有下一页
    private  Boolean hasNext=Boolean.TRUE;
    //是否有上一页
    private  Boolean hasPrevious=Boolean.TRUE;

    public PageVO(Long total, List<T> list, Long pageNum, Long pageSize, Long pages, Boolean hasNext, Boolean hasPrevious) {
        this.total = total;
        this.list = list;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pages = pages;
        this.hasNext = hasNext;
        this.hasPrevious = hasPrevious;
        calculatePageInfo();
    }


    public void calculatePageInfo() {
        // 1. 计算 hasPrevious（是否有上一页：当前页 > 1）
        this.hasPrevious = this.pageNum != null && this.pageNum > 1;

        // 2. 计算 hasNext（是否有下一页：当前页 < 总页数）
        this.hasNext = this.pageNum != null && this.pages != null && this.pageNum < this.pages;
    }



}
