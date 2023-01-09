package com.example.demo.esayExcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class EsayExcelEntity {
    @ExcelProperty(value = "楼栋编号",index = 0)
    private String loudong;
    @ExcelProperty(value ="出租屋名称",index = 1)
    private String chuzuwuname;
    @ExcelProperty(value ="出租屋地址",index = 2)
    private String chuzuwu;
    @ExcelProperty(value ="村居名称",index = 3)
    private String cunju;
    @ExcelProperty(value ="房东手机号",index = 4)
    private String fangdong;
    @ExcelProperty(value ="房东名称",index = 5)
    private String fdmc;
    @ExcelProperty(value ="村居编号",index = 6)
    private String cjbh;
    @ExcelProperty(value ="经度",index = 7)
    private String jd;
    @ExcelProperty(value ="纬度",index = 8)
    private String wd;
    @ExcelProperty(value ="街镇编号",index = 9)
    private String jzbh;
    @ExcelProperty(value ="设备数量",index = 10)
    private String sbsl;
}
