package com.example.demo.testModels;

import lombok.Data;

@Data
class BillsNums {
    private String id;
    private int nums;
    private int sums;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getNums() {
        return nums;
    }
    public void setNums(int nums) {
        this.nums = nums;
    }
    public int getSums() {
        return sums;
    }
    public void setSums(int sums) {
        this.sums = sums;
    }
}
