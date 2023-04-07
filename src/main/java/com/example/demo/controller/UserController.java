package com.example.demo.controller;

import com.example.demo.aspect.annotation.CheckValue;
import com.example.demo.aspect.annotation.SysLog;
import com.example.demo.dao.SysLogDao;
import com.example.demo.entity.SysLogEntity;
import com.example.demo.exception.TransactionalT;
import com.example.demo.exception.Transaction;
import com.example.demo.service.UserService;
import lombok.SneakyThrows;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {


    @Resource
    private SysLogDao sysLogDao;

    @Resource
    private UserService userService;

    //这里加上了注解，再调用该方法时就会进行aop的增强 进行日志记录
    @SysLog("查询用户列表")
    @CheckValue("2")
    @RequestMapping("/list")
    @SneakyThrows
    @Transactional(rollbackFor = {Transaction.class})
    public String getUserList(Integer age){
       /* List<SysLogEntity> userEntities = sysLogDao.selectList(new QueryWrapper<>());
        return userEntities.toString();*/
//
//        List<UserEntity> list = userService.lambdaQuery().eq(UserEntity::getAge, age).list();
//        return list.toString();


       SysLogEntity a= new SysLogEntity();
       a.setId(123L);
       a.setIp("asdasd");
        sysLogDao.insert(a);
        if (age<10){
            throw new TransactionalT();
        }
        if (age>18){
            throw new Transaction();
        }
        System.out.println(age);

        return "yes";
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
