package com.vti.utils;

public class Sort {
    private String nameSort;
    private String typeSort;

    public Sort(String nameSort, String typeSort) {
        this.nameSort = nameSort;
        this.typeSort = typeSort;
    }

    public Sort() {
    }

    public String getNameSort() {
        return nameSort;
    }

    public void setNameSort(String nameSort) {
        this.nameSort = nameSort;
    }

    public String getTypeSort() {
        return typeSort;
    }

    public void setTypeSort(String typeSort) {
        this.typeSort = typeSort;
    }
}
