package com.softdev.system.demo.controller;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.data.*;
import com.deepoove.poi.data.style.Style;
import com.deepoove.poi.data.style.TableStyle;
import com.deepoove.poi.policy.HackLoopTableRenderPolicy;
import com.deepoove.poi.util.BytePictureUtils;
import com.softdev.system.demo.example.DetailData;
import com.softdev.system.demo.example.DetailTablePolicy;
import com.softdev.system.demo.example.PaymentData;
import com.softdev.system.demo.example.PaymentHackData;
import com.softdev.system.demo.util.ApiReturnObject;
import com.softdev.system.demo.util.ApiReturnUtil;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


@RestController
public class PoiController {
	@RequestMapping(method = RequestMethod.POST,value = "/paymentWord2",produces = "application/json;charset=UTF-8")
	public ApiReturnObject generateWord(@RequestBody PaymentHackData paymentHackData) throws IOException {
		String resource = "/Users/kingsley/Documents/payment.docx";
		PaymentHackData datas =new PaymentHackData();

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
		if (null!=paymentHackData.getName()){
			datas.setName(paymentHackData.getName());
		}
		if (null!=paymentHackData.getTelephone()){
			datas.setTelephone(paymentHackData.getTelephone());
		}
		if (null!=paymentHackData.getName()){
			datas.setAddAmounts(paymentHackData.getName());
		}
		if (null!=paymentHackData.getName()){
			datas.setAllAmounts(paymentHackData.getName());
		}
		if (null!=paymentHackData.getName()){
			datas.setAveragePrice(paymentHackData.getName());
		}
		if (null!=paymentHackData.getTotal()){
			datas.setTotal(paymentHackData.getTotal());
		}
		if (paymentHackData.getCourses().size()>0){
			datas.setCourses(paymentHackData.getCourses());
		}
		datas.setName("kkklll");
		datas.setTelephone("187xxxxxxxx");
		datas.setAddAmounts("1244");
		datas.setAllAmounts("212");
		datas.setAveragePrice("112");
		datas.setTotal("222000");



		//        输出文档
		HackLoopTableRenderPolicy hackLoopTableRenderPolicy = new HackLoopTableRenderPolicy();
		Configure config = Configure.newBuilder().bind("courses", hackLoopTableRenderPolicy).build();
		XWPFTemplate template = XWPFTemplate.compile(resource, config).render(new HashMap<String, Object>() {
			{
				put("datas", Arrays.asList(datas));
			}
		});
		template.writeToFile("out_example_payment_hack.docx");
		return ApiReturnUtil.success(null);
	}

}
