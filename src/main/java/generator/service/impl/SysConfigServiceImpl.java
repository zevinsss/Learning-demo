package generator.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.SysConfig;
import generator.service.SysConfigService;
import generator.mapper.SysConfigMapper;
import org.springframework.stereotype.Service;

/**
* @author LuoHongMiao
* @description 针对表【sys_config(系统配置信息表)】的数据库操作Service实现
* @createDate 2022-12-05 15:04:42
*/
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig>
implements SysConfigService{

}
