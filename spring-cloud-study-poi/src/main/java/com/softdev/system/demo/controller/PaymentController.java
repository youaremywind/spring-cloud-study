package com.softdev.system.demo.controller;


import com.deepoove.poi.data.PictureRenderData;
import com.deepoove.poi.util.BytePictureUtils;
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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class PaymentController {
    @RequestMapping(method = RequestMethod.POST,value = "/paymentWord",produces = "application/json;charset=UTF-8")
    public ApiReturnObject generateWord(@RequestBody PaymentData paymentData) throws IOException {
        String resource = "/Users/kingsley/Documents/payment.docx";
        PaymentData datas = new PaymentData();

        Style headTextStyle = new Style();
        TableStyle headStyle = new TableStyle();
        TableStyle rowStyle = new TableStyle();
        headTextStyle.setFontFamily("Hei");
        headTextStyle.setFontSize(9);
        headTextStyle.setColor("7F7F7F");

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
        if (null!=paymentData.getName()){
            datas.setAddAmounts(paymentData.getName());
        }
        if (null!=paymentData.getName()){
            datas.setAllAmounts(paymentData.getName());
        }
        if (null!=paymentData.getName()){
            datas.setAveragePrice(paymentData.getName());
        }
        if (null!=paymentData.getTotal()){
            datas.setTotal(paymentData.getTotal());
        }
        if (paymentData.getCourses().size()>0){
            datas.setCourses(paymentData.getCourses());
        }
        datas.setName("kkklll");
        datas.setTelephone("187xxxxxxxx");
        datas.setAddAmounts("1244");
        datas.setAllAmounts("212");
        datas.setAveragePrice("112");
        datas.setTotal("222000");
//        datas.setSubtotal("8000");
//        datas.setTax("600");
//        datas.setTransform("120");
//        datas.setOther("250");
//        datas.setUnpay("6600");
//        datas.setTotal("总共：7200");
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

        DetailData detailTable = new DetailData();
        RowRenderData good = RowRenderData.build("English", "204", "60", "12240");
        good.setRowStyle(rowStyle);
        List<RowRenderData> goods = Arrays.asList(good, good, good);
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
