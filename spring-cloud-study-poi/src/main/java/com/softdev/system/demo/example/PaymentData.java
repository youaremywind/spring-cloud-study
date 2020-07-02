package com.softdev.system.demo.example;

import com.deepoove.poi.data.MiniTableRenderData;
import com.deepoove.poi.data.PictureRenderData;
import com.deepoove.poi.el.Name;

import java.util.List;

public class PaymentData {

    private String name;
    private String telephone;
    private String addAmounts;
    private String averagePrice;
    private String allAmounts;
    private String total;
    private List<Course> courses;
//    private MiniTableRenderData order;
//    private String NO;
//    private String ID;
//    private String taitou;
//    private String consignee;
    @Name("detail_table")
    private DetailData detailTable;
//    private String subtotal;
//    private String tax;
//    private String transform;
//    private String other;
//    private String unpay;
//    private String total;
    private PictureRenderData logo;


    public void setDetailTable(DetailData detailTable) {
        this.detailTable = detailTable;
    }

    public DetailData getDetailTable() {
        return this.detailTable;
    }


    public PictureRenderData getLogo() {
        return logo;
    }

    public void setLogo(PictureRenderData logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddAmounts() {
        return addAmounts;
    }

    public void setAddAmounts(String addAmounts) {
        this.addAmounts = addAmounts;
    }

    public String getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(String averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getAllAmounts() {
        return allAmounts;
    }

    public void setAllAmounts(String allAmounts) {
        this.allAmounts = allAmounts;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}