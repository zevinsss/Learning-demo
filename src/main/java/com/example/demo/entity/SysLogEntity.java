package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("sys_log")
public class SysLogEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Long id;
    //用户名
    @TableField("username")
    private String username;
    //用户操作
    @TableField("operation")
    private String operation;
    @TableField("method")
    //请求方法
    private String method;
    @TableField("params")
    //请求参数
    private String params;
    @TableField("time")
    //执行时长(毫秒)
    private Long time;
    @TableField("ip")
    //IP地址
    private String ip;
    @TableField("createDate")
    //创建时间
    private Date createDate;

}


