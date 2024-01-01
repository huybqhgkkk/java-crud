package com.spring.mongo.demo.utils;

import java.util.List;

public class PagedResponse<T> {
    private List<T> data;
    private int pageIndex;
    private int pageSize;
    private long total;

    // Constructors, getters, and setters

    public List<T> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = (List<T>) data;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}

