package com.example.demo.test;

import com.example.demo.testModels.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {


    public static void main(String args[]){
        List<Student> list = new ArrayList<>();
        list.add(new Student(1,25,"关羽"));
        list.add(new Student(2,21,"张飞"));
        list.add(new Student(3,18,"刘备"));
        list.add(new Student(4,32,"袁绍"));
        list.add(new Student(5,36,"赵云"));
        list.add(new Student(6,16,"曹操"));
        System.out.println("排序前:");
        for (Student student : list) {
            System.out.println(student.toString());
        }
        //使用默认排序
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getId() - o1.getId();
            }
        });
        System.out.println("默认排序后:");
        for (Student student : list) {
            System.out.println(student.toString());
        }
    }



}
