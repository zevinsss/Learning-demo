package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.aspect.annotation.CheckValue;
import com.example.demo.aspect.annotation.SysLog;
import com.example.demo.dao.SysLogDao;
import com.example.demo.entity.SysLogEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {


    @Resource
    private SysLogDao sysLogDao;

    @Resource
    private UserService userService;

    //这里加上了注解，再调用该方法时就会进行aop的增强 进行日志记录
    @SysLog("查询用户列表")
    @CheckValue("2")
    @GetMapping("/list")
    public String getUserList(Integer age){
       /* List<SysLogEntity> userEntities = sysLogDao.selectList(new QueryWrapper<>());
        return userEntities.toString();*/

        List<UserEntity> list = userService.lambdaQuery().eq(UserEntity::getAge, age).list();
        return list.toString();
    }

    /*@SysLog("根据用户id查询用户")
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") Integer id){

    }

    @SysLog("添加用户")
    @PostMapping("/save")
    public String save(UserEntity userEntity){

    }*/


}
