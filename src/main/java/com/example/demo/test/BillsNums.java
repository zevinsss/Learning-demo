package com.example.demo.test;

import lombok.Data;

@Data
public class BillsNums {
    public String id;
    public int nums;
    public int sums;

    public BillsNums(String id, int nums, int sums) {
        this.id = id;
        this.nums = nums;
        this.sums = sums;
    }

    public BillsNums() {
    }
}
