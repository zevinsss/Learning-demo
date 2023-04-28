package com.example.demo.service.imple;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
    @Override
    @SneakyThrows
    public  String dontKnow(String str) {
        System.out.println("come");

            synchronized (str.intern()){
                System.out.println("进到方法里了");
                Thread.sleep(7000);
            }
            System.out.println("strout");


//        Thread.sleep(10000);

        return "success";
    }
}
