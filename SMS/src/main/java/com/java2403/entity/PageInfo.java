package com.java2403.entity;

import lombok.Data;

import java.util.List;

@Data
public class PageInfo<T> {

    private int  pageIndex; // 当前页
    private int  pageSize; // 一页几条
    private int  totalPage; // 总页数  一共几页
    private int  totalData; // 总条数 一共几条数据
    private List<T> data; //  存数据（当前页 的 几条实际数据 ）
}
