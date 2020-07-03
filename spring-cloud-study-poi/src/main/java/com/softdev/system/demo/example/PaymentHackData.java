package com.softdev.system.demo.example;

import java.util.List;

public class PaymentHackData {
    private String name;
    private String telephone;
    private String addAmounts;
    private String averagePrice;
    private String allAmounts;
    private String total;
    private List<Course> courses;

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

    class Course{
        private String courseName;
        private String courseAmounts;
        private String coursePrices;
        private String courseTotal;

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getCourseAmounts() {
            return courseAmounts;
        }

        public void setCourseAmounts(String courseAmounts) {
            this.courseAmounts = courseAmounts;
        }

        public String getCoursePrices() {
            return coursePrices;
        }

        public void setCoursePrices(String coursePrices) {
            this.coursePrices = coursePrices;
        }

        public String getCourseTotal() {
            return courseTotal;
        }

        public void setCourseTotal(String courseTotal) {
            this.courseTotal = courseTotal;
        }
    }
}
