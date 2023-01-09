package com.example.demo.satoken.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.stp.StpUtil;
import com.example.demo.satoken.config.SatokenConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SatokenController {



    @RequestMapping("/login")
    public List<String> login(String id){
        StpUtil.login(id);
        String tokenValue = StpUtil.getTokenInfo().getTokenValue();
        String tokenName = StpUtil.getTokenInfo().getTokenName();
        String loginType = StpUtil.getTokenInfo().getLoginType();
        Object loginId = StpUtil.getTokenInfo().getLoginId();
        List<String> list = new ArrayList();
        list.add(tokenValue);
        list.add(tokenName);
        list.add(loginType);
        list.add(loginId.toString());
        return list;
    }
    @RequestMapping("/islogin")
    public boolean islogin(){
        return StpUtil.isLogin();
    }


    @SaCheckPermission
    @RequestMapping("/permission")
    public List<String> permission(String id){
        StpUtil.checkPermission("");
        String tokenValue = StpUtil.getTokenInfo().getTokenValue();
        String tokenName = StpUtil.getTokenInfo().getTokenName();
        String loginType = StpUtil.getTokenInfo().getLoginType();
        Object loginId = StpUtil.getTokenInfo().getLoginId();
        List<String> list = new ArrayList();
        list.add(tokenValue);
        list.add(tokenName);
        list.add(loginType);
        list.add(loginId.toString());
        return list;
    }

    @SaCheckPermission
    @RequestMapping ("/Role")
    public List<String> Role(String id){
        StpUtil.checkRole("admin");
        String tokenValue = StpUtil.getTokenInfo().getTokenValue();
        String tokenName = StpUtil.getTokenInfo().getTokenName();
        String loginType = StpUtil.getTokenInfo().getLoginType();
        Object loginId = StpUtil.getTokenInfo().getLoginId();
        List<String> list = new ArrayList();
        list.add(tokenValue);
        list.add(tokenName);
        list.add(loginType);
        list.add(loginId.toString());
        return list;
    }

}
