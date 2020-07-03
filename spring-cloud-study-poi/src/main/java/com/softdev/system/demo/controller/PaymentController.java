package com.softdev.system.demo.controller;


import com.deepoove.poi.data.PictureRenderData;
import com.deepoove.poi.util.BytePictureUtils;
import com.softdev.system.demo.example.Course;
import com.softdev.system.demo.example.DetailData;
import com.softdev.system.demo.example.DetailTablePolicy;
import com.softdev.system.demo.example.PaymentData;
import com.softdev.system.demo.util.ApiReturnObject;
import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.softdev.system.demo.util.ApiReturnUtil;
import org.springframework.web.bind.annotation.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;


import com.deepoove.poi.data.MiniTableRenderData;
import com.deepoove.poi.data.RowRenderData;
import com.deepoove.poi.data.TextRenderData;
import com.deepoove.poi.data.style.Style;
import com.deepoove.poi.data.style.TableStyle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class PaymentController {
    @RequestMapping(method = RequestMethod.POST,value = "/paymentWord",produces = "application/json;charset=UTF-8")
    public ApiReturnObject generateWord(@RequestBody PaymentData paymentData) throws IOException {
//        String resource = "/Users/kingsley/Documents/payment.docx";
        String resource = "C:\\Users\\youar\\Desktop\\payment.docx";
        PaymentData datas = new PaymentData();

        Style headTextStyle = new Style();
        TableStyle headStyle = new TableStyle();
        TableStyle rowStyle = new TableStyle();
        headTextStyle.setFontFamily("Hei");
        headTextStyle.setFontSize(9);
        headTextStyle.setColor("ff0000");
        headTextStyle.setBold(true);

        headStyle.setBackgroundColor("F2F2F2");
        headStyle.setAlign(STJc.CENTER);

        rowStyle = new TableStyle();
        rowStyle.setAlign(STJc.CENTER);
        if (null!=paymentData.getName()){
            datas.setName(paymentData.getName());
        }
        if (null!=paymentData.getTelephone()){
            datas.setTelephone(paymentData.getTelephone());
        }
        if (null!=paymentData.getAddAmounts()){
            datas.setAddAmounts(paymentData.getAddAmounts());
        }
        if (null!=paymentData.getAllAmounts()){
            datas.setAllAmounts(paymentData.getAllAmounts());
        }
        if (null!=paymentData.getAveragePrice()){
            datas.setAveragePrice(paymentData.getAveragePrice());
        }
        if (null!=paymentData.getTotal()){
            datas.setTotal(paymentData.getTotal());
        }

        if (paymentData.getCourses().size()>0){
            datas.setCourses(paymentData.getCourses());
        }
        List<Course> lists =paymentData.getCourses();
//
//        RowRenderData header = RowRenderData.build(new TextRenderData("日期", headTextStyle),
//                new TextRenderData("订单编号", headTextStyle), new TextRenderData("销售代表", headTextStyle),
//                new TextRenderData("离岸价", headTextStyle), new TextRenderData("发货方式", headTextStyle),
//                new TextRenderData("条款", headTextStyle), new TextRenderData("税号", headTextStyle));
//        header.setRowStyle(headStyle);
//
//        RowRenderData row = RowRenderData.build("2018-06-12", "SN18090", "李四", "5000元", "快递", "附录A", "T11090");
//        row.setRowStyle(rowStyle);
//        MiniTableRenderData miniTableRenderData = new MiniTableRenderData(header, Arrays.asList(row),
//                MiniTableRenderData.WIDTH_A4_MEDIUM_FULL);
//        miniTableRenderData.setStyle(headStyle);
//        datas.setOrder(miniTableRenderData);
        List<RowRenderData> goods = new ArrayList<>();
        DetailData detailTable = new DetailData();
        RowRenderData good =null;
        for (Course c:lists
             ) {
            good = RowRenderData.build(new TextRenderData(c.getCourseName(), headTextStyle), new TextRenderData(c.getCoursePrices()+"元", headTextStyle),
                    new TextRenderData(c.getCourseAmounts()+"课时", headTextStyle), new TextRenderData(c.getCourseTotal()+"元", headTextStyle));
            good.setRowStyle(rowStyle);
            goods.add(good);
        }
//        RowRenderData labor = RowRenderData.build("油漆工", "2", "200", "400");
//        labor.setRowStyle(rowStyle);
        //        条数
//        List<RowRenderData> labors = Arrays.asList(labor, labor, labor, labor);
        detailTable.setGoods(goods);
//        detailTable.setLabors(labors);
        datas.setDetailTable(detailTable);
        //        输出文档
        Configure config = Configure.newBuilder().bind("detail_table", new DetailTablePolicy()).build();
        XWPFTemplate template = XWPFTemplate.compile(resource, config).render(datas);
        template.writeToFile("out_example_payment.docx");
        return ApiReturnUtil.success(null);
    }
}
