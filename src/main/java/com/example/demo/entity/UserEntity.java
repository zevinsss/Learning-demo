package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Long id;
    //用户名
    @TableField("name")
    private String name;
    @TableField("age")
    private Integer age;
    @TableField("high")
    private Integer high;
}
