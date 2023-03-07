package com.example.demo.elasticsearch.controller;


import com.example.demo.elasticsearch.common.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by AI码师 on 2019/4/19.
 * 关注公众号【AI码师】领取2021最新面试资料一份（很全）
 */
@RestController
@RequestMapping("/api")
public class ApiController {
    @RequestMapping("qwe")
    public R<String> addLog(@RequestParam(value = "param1",required = false) String param1){
        return R.success("你好，这段话将被日志记录");
    }
}
