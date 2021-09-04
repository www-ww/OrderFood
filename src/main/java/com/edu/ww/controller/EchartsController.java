package com.edu.ww.controller;

import com.edu.ww.pojo.Address;
import com.edu.ww.pojo.Detail;
import com.edu.ww.service.AddressService;
import com.edu.ww.service.DetailService;
import com.edu.ww.service.FoodService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @program:OrderFood
 * @description:echarts图表接口
 * @author:ww
 * @create:2021-09-02 17:29
 */
@Controller
public class EchartsController {

    @Autowired
    DetailService detailService;

    @Autowired
    FoodService foodService;

    @GetMapping("/toBar")
    public String toBar(HttpServletRequest request, Model model) {
        return "echarts/myecharts";
    }

    @RequestMapping("/queryForList")
    @ResponseBody
    public String queryForList() throws Exception {
        // 取得数据库的数据，使用list方式存储，因为折线图接收的数据结构是list的[1,2,...,]
        List<Map<String, Object>> list_map =new ArrayList<>();
        Map<String, Object> map = setData();
        Set<String> set=map.keySet();
        for(String s:set)
        {
            Map<String,Object> map1=new LinkedHashMap<>();
            map1.put("name",s);
            map1.put("value",map.get(s));
            list_map.add(map1);
        }

        JSONArray json_data = JSONArray.fromObject(list_map);// 转换为json数据格式
        String data = json_data.toString();
        return data;
    }

    public Map<String,Object> setData() throws Exception {
        List<Detail> details = detailService.getsSer();
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for(Detail detail:details)
        {
            if(!map.keySet().contains(detail.getFoodid()))
            {
                map.put(detail.getFoodid(),detail.getNumber());
            }
            else
            {
                map.put(detail.getFoodid(),detail.getNumber()+map.get(detail.getFoodid()));
            }
        }
        Set<Integer> foodid=map.keySet();
        Map<String,Object> data=new LinkedHashMap<String,Object>();
        for(int i:foodid)
        {
            data.put(foodService.getByidSer(i).getFoodname()+i,map.get(i));
        }
        return data;
    }

}
