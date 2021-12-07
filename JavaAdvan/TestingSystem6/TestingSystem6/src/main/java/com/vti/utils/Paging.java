package com.vti.utils;

public class Paging {

    private Integer page;
    private Integer size;

    public Paging(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }

    public Paging() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
