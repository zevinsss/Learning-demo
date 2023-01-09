package com.example.demo.test;

import java.util.HashMap;
import java.util.Map;

public class RepeatNumber {
    public static int duplicate (int[] numbers) {
        // write code here
        Map map = new HashMap();
        for(int i = 0 ; i <  numbers.length;i++){
            if(map.containsKey( String.valueOf(numbers[i]))){
                return numbers[i];
            }else{
                String key = String.valueOf(numbers[i]);
                map.put(key,numbers[i]);
                if(i==numbers.length-1){
                    return -1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(duplicate(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
