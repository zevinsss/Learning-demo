package com.example.demo.service.imple;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncServiceImpl {

    // 指定使用beanname为doSomethingExecutor的线程池
    @Async("doSomethingExecutor")
    public String doSomething(String message) {
        log.info("do something, message={}", message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("do something error: ", e);
        }
        return message;
    }


}
