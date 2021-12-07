package com.vti.utils;

public class Filter {

    private Integer minMember;
    private Integer maxMember;

    public Filter( Integer minMember, Integer maxMember) {
        this.minMember = minMember;
        this.maxMember = maxMember;
    }

    public Filter() {
    }

    public Integer getMinMember() {
        return minMember;
    }

    public void setMinMember(Integer minMember) {
        this.minMember = minMember;
    }

    public Integer getMaxMember() {
        return maxMember;
    }

    public void setMaxMember(Integer maxMember) {
        this.maxMember = maxMember;
    }

}
