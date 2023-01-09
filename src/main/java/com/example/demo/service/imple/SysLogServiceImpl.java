package com.example.demo.service.imple;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.SysLogDao;
import com.example.demo.entity.SysLogEntity;
import com.example.demo.service.SysLogService;
import org.springframework.stereotype.Service;

@Service("SysLogService")
public class SysLogServiceImpl extends ServiceImpl<SysLogDao, SysLogEntity> implements SysLogService {

}