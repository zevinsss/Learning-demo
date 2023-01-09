package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MainCenter {
    public static void main(String[] args) {

        List<BillsNums> billsNumsList = new ArrayList<>();
        BillsNums billsNums = new BillsNums();
        billsNums.setId("1001");
        billsNums.setNums(2);
        billsNums.setSums(100);
        billsNumsList.add(billsNums);

        BillsNums billsNums2 = new BillsNums();
        billsNums2.setId("1001");
        billsNums2.setNums(3);
        billsNums2.setSums(100);
        billsNumsList.add(billsNums2);

/*        List<BillsNums> result = merge(billsNumsList);
        System.out.println("result:" + JSON.toJSONString(result, true));*/


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是新的线程"+Thread.currentThread().getName());
            }
        }).start();

        new Thread(()->{
            System.out.println("我是新线程"+Thread.currentThread().getName());
        }).start();


        Consumer<String> conm = (d)->{};


    }




}
