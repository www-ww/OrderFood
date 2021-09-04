package com.edu.ww.service.impl;

import com.edu.ww.mapper.OrderMapper;
import com.edu.ww.pojo.Order;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.Writer;
import java.util.List;

/**
 * @program:OrderFood
 * @description:文件导出类
 * @author:ww
 * @create:2021-09-02 15:31
 */
@Service
public class PoiService {
    @Autowired
    OrderMapper mapper;

    public Workbook queryExportUser() throws Exception{
        List<Order> list=mapper.getOrders();   //读取数据库数据
        String[] excelHeader={"订单号","用户id","订单状态","总价格","配送地址","下单时间"};  //设置Excel头部
        Workbook wb = new SXSSFWorkbook(1000);

        Sheet sheet = wb.createSheet("Sheet1");//创建工作表
        Row row = sheet.createRow(0);  //创建行，从0开始
        CellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);  //对齐方式

        //导入头部
        for (int i = 0; i < excelHeader.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(excelHeader[i]);
            cell.setCellStyle(style);
            sheet.setColumnWidth(1, (short) 6000);  //设置列宽
        }
        Order order=null;
        //导入数据
        for(int i=0 ; i<list.size();i++){
            row = sheet.createRow(i + 1);
            order=list.get(i);
            row.createCell(0).setCellValue(order.getOrderid());   //设置单元格内容
            row.createCell(1).setCellValue(order.getUserid());
            row.createCell(2).setCellValue(order.getState());
            row.createCell(3).setCellValue(order.getAllprice());
            row.createCell(4).setCellValue(order.getTo());
            row.createCell(5).setCellValue(order.getTime());
        }
        return wb;
    }

}
