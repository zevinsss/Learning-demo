package com.example.demo.satoken.config;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class SatokenConfig implements StpInterface {
    @Resource
    private RedisHelper redisHelper;

    @Override
    public List<String> getPermissionList(Object o, String s) {
        // 本list仅做模拟，实际项目中要根据具体业务逻辑来查询权限
        List<String> list = new ArrayList<String>();
        list.add("101");
        list.add("user-add");
        list.add("user-delete");
        list.add("user-update");
        list.add("user-get");
        list.add("article-get");
        return list;
    }

    @Override
    public List<String> getRoleList(Object o, String s) {
        // 本list仅做模拟，实际项目中要根据具体业务逻辑来查询角色
        List<String> list = new ArrayList<String>();
        list.add("admin");
        list.add("super-admin");
        return list;
    }
}
