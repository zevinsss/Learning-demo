package com.example.demo.controller;

import com.example.demo.aspect.annotation.CheckValue;
import com.example.demo.aspect.annotation.SysLog;
import com.example.demo.dao.SysLogDao;
import com.example.demo.entity.SysLogEntity;
import com.example.demo.exception.TransactionalT;
import com.example.demo.exception.Transaction;
import com.example.demo.satoken.config.RedisHelper;
import com.example.demo.service.UserService;
import lombok.SneakyThrows;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

@RestController
public class UserController {


    @Resource
    private SysLogDao sysLogDao;

    @Resource
    private UserService userService;

    @Resource
    RedisHelper redisHelper;

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

//    @SysLog("根据用户id查询用户")
//    @GetMapping("/user/{id}")
//    public String getUserById(@PathVariable("id") Integer id){
//
//    }

    @SysLog("添加用户")
    @PostMapping("/save")
    @Transactional
    public String save(String ddd){
        redisHelper.set("qwe","qwe");
        return redisHelper.get("qwe").toString();
    }


    @PostMapping("/getMsg")
    @Transactional
    public String getMsg(String ddd){
        String s = userService.dontKnow(ddd);
        return s;
    }


    @PostMapping("/setMsgThrowEx")
    @Transactional
    @SneakyThrows
    public String setMsgThrowEx(String ddd){
        redisHelper.del("qwe");
        throw new Exception("llala");
    }




    private static Map<String, ReentrantLock> lockMap = new ConcurrentHashMap<>();
    @GetMapping("thread")
    public void thread(String id) {
        ReentrantLock o = null;
        do {
            //开始执行先unlock
            if (o != null) {
                o.unlock();
            }
            o = lockMap.computeIfAbsent(id, k -> new ReentrantLock());
            //加锁
            o.lock();
            //新创建的被上一个线程remove掉了，或者新创建的对象和lockMap中已有的不是同一个对象，重试
        } while (lockMap.get(id) == null || o != lockMap.get(id));
        System.out.println(id + "进来了");
        try {
            //执行业务
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lockMap.remove(id);
        }
        System.out.println(id + "走了");
    }


    @PostMapping("/redisSet")
    @SneakyThrows
    public boolean redisSet(String key,String value){
        boolean b = redisHelper.setIfAbsent(key, value, 2);
        return b;
    }


    public static void main(String[] args) {
        try {
            String thumbUrl = java.net.URLEncoder.encode("weixin://dl/business/?t=6Duxb57yqOm", "UTF-8");
            System.out.println(thumbUrl);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
