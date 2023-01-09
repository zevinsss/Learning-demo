package com.example.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.demo.testModels.ScopeRequest;

import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

public class MapUtils {



    /** * 使用Path2D创建一个多边形
     * @param polygon 经纬度 集合
     * @return 返回Path2D.Double
     */
    private static Path2D.Double create(List<ScopeRequest> polygon) {

        //创建path2D对象

        Path2D.Double generalPath = new Path2D.Double();

        //获取第一个起点经纬度的坐标

        ScopeRequest first = polygon.get(0);

        //通过移动到以double精度指定的指定坐标，把第一个起点添加到路径中

        generalPath.moveTo(first.getLongitude(), first.getLatitude());

        //把集合中的第一个点删除防止重复添加

        polygon.remove(0);

        //循环集合里剩下的所有经纬度坐标

        for (ScopeRequest d : polygon) {

            //通过从当前坐标绘制直线到以double精度指定的新指定坐标，将路径添加到路径。

            //从第一个点开始，不断往后绘制经纬度点

            generalPath.lineTo(d.getLongitude(), d.getLatitude());

        }

        // 最后要多边形进行封闭，起点及终点

        generalPath.lineTo(first.getLongitude(), first.getLatitude());

        //将直线绘制回最后一个 moveTo的坐标来关闭当前子路径。

        generalPath.closePath();

        return generalPath;

    }



    /**
     * 判断点是否在区域内
     * @param polygon  区域经纬度json字符串
     * @param longitude 经度
     * @param latitude  纬度
     * @return 返回true跟false
     */

    public static boolean isPoint(String polygon, double longitude, double latitude) {

        JSONArray jsonArray = JSON.parseArray(polygon);

        //将json转换成对象

        List<ScopeRequest> list = JSON.parseArray(jsonArray.toJSONString(), ScopeRequest.class);

        Path2D path2D = create(list);

        //true如果指定的坐标在Shape边界内; 否则为false 。

        return path2D.contains(longitude, latitude);

    }

    public static void main(String[] args) {

        ScopeRequest scopeRequest1 = new ScopeRequest();
        scopeRequest1.setLatitude(23.165123991852738);
        scopeRequest1.setLongitude(114.70034107820189);
        ScopeRequest scopeRequest2 = new ScopeRequest();
        scopeRequest2.setLatitude(23.152528056314512);
        scopeRequest2.setLongitude(114.70005630966605);
        ScopeRequest scopeRequest3 = new ScopeRequest();
        scopeRequest3.setLatitude(23.152747507953688);
        scopeRequest3.setLongitude(114.71785434315736);
        ScopeRequest scopeRequest4 = new ScopeRequest();
        scopeRequest4.setLatitude(23.15511756249086);
        scopeRequest4.setLongitude(114.71049782264761);
        ScopeRequest scopeRequest5 = new ScopeRequest();
        scopeRequest5.setLatitude(23.160033095963534);
        scopeRequest5.setLongitude(114.708314597206);
        ScopeRequest scopeRequest6 = new ScopeRequest();
        scopeRequest6.setLatitude(23.158672564780844);
        scopeRequest6.setLongitude(114.72407178952366);
        ScopeRequest scopeRequest7 = new ScopeRequest();
        scopeRequest7.setLatitude(23.165123991852738);
        scopeRequest7.setLongitude(114.70034107820189);


        List<ScopeRequest> list = new ArrayList<>();
        list.add(scopeRequest1);
        list.add(scopeRequest2);
        list.add(scopeRequest3);
        list.add(scopeRequest4);
        list.add(scopeRequest5);
        list.add(scopeRequest6);

        Path2D.Double aDouble = create(list);


        boolean contains = aDouble.contains(114.72379254935062,23.15872117680336);
        System.out.println(contains);
    }

}
