package com.example.demo.esayExcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.SneakyThrows;
import okhttp3.*;

public class EasyExcelLesner extends AnalysisEventListener<EsayExcelEntity> {
    public   static List<EsayExcelEntity> dataList = new ArrayList<>();
    @Override
    public void invoke(EsayExcelEntity esayExcelEntity, AnalysisContext analysisContext) {
        System.out.println(esayExcelEntity);
        dataList.add(esayExcelEntity);
//        post.setLoudong(esayExcelEntity.getLoudong());
//        List<EsayExcelEntity> list = new ArrayList<EsayExcelEntity>();
//        list.add(post);
    /*    EasyExcel.write("C:\\Users\\Hidou\\Desktop\\test.xlsx", EsayExcelEntity.class).sheet("写入方法一").doWrite(data(esayExcelEntity.getLoudong(), esayExcelEntity.getChuzuwu() ));*/
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头："+headMap);
    }



    @SneakyThrows
    public static List<EsayExcelEntity> data() {
        List<EsayExcelEntity> list = new ArrayList<EsayExcelEntity>();
        for (int i = 0; i < dataList.size()-1; i++) {

            EsayExcelEntity data = new EsayExcelEntity();
            EsayExcelEntity post = post(dataList.get(i).getChuzuwu());
            data.setLoudong(dataList.get(i).getLoudong());
            data.setJd(post.getJd());
            data.setWd(post.getWd());
            list.add(data);
        }
        return list;
    }
    @SneakyThrows
    public static EsayExcelEntity post(String addr){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http://api.map.baidu.com/geocoding/v3/?address="+addr+"&output=json&ak=ait2Dzf2n5UHcwyxbWo0hXCsoBuyUZ2Q&callback=showLocation")
                                .method("GET", null)
                                .build();
        Response response = client.newCall(request).execute();
        String st = response.body().string();
        String string = st.substring(27,st.length()-1);
        JSONObject resultObject = JSON.parseObject(string);
        String s = String.valueOf(resultObject.get("result"));
        JSONObject jsonObject = JSON.parseObject(s);
        String sd = String.valueOf(jsonObject.get("location"));
        JSONObject jsonObject2 = JSON.parseObject(sd);
        String lng = String.valueOf(jsonObject2.get("lng"));
        String lat = String.valueOf(jsonObject2.get("lat"));
        System.out.println(lng+"----"+lat);
        EsayExcelEntity esayExcelEntity = new EsayExcelEntity();
        esayExcelEntity.setWd(lat);
        esayExcelEntity.setJd(lng);
        return esayExcelEntity;
    }
}
