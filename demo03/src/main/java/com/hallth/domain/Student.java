package com.hallth.domain;

public class Student {
    private Integer stuSeq;

    private String stuCode;

    private String stuName;

    private String stuGender;

    private Integer stuAge;

    private String stuClassNum;

    private String stuPassword;

    public Integer getStuSeq() {
        return stuSeq;
    }

    public void setStuSeq(Integer stuSeq) {
        this.stuSeq = stuSeq;
    }

    public String getStuCode() {
        return stuCode;
    }

    public void setStuCode(String stuCode) {
        this.stuCode = stuCode;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuClassNum() {
        return stuClassNum;
    }

    public void setStuClassNum(String stuClassNum) {
        this.stuClassNum = stuClassNum;
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuSeq=" + stuSeq +
                ", stuCode='" + stuCode + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuGender='" + stuGender + '\'' +
                ", stuAge=" + stuAge +
                ", stuClassNum='" + stuClassNum + '\'' +
                ", stuPassword='" + stuPassword + '\'' +
                '}';
    }
}