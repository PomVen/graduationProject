package com.hallth.domain;

import java.util.Objects;

public class Teacher {
    private int teacherSeq;
    private String teacherName;
    private String teacherId;
    private int teacherAge;
    private String teacherGender;
    private String teacherPhone;
    private String teacherMajor;
    private String teacherAddress;
    private String teacherEmail;
    private String teacherPassword;

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public int getteacherSeq() {
        return teacherSeq;
    }

    public void setteacherSeq(int teacherSeq) {
        this.teacherSeq = teacherSeq;
    }

    public String getteacherName() {
        return teacherName;
    }

    public void setteacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getteacherId() {
        return teacherId;
    }

    public void setteacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public int getteacherAge() {
        return teacherAge;
    }

    public void setteacherAge(int teacherAge) {
        this.teacherAge = teacherAge;
    }

    public String getteacherGender() {
        return teacherGender;
    }

    public void setteacherGender(String teacherGender) {
        this.teacherGender = teacherGender;
    }

    public String getteacherPhone() {
        return teacherPhone;
    }

    public void setteacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getteacherMajor() {
        return teacherMajor;
    }

    public void setteacherMajor(String teacherMajor) {
        this.teacherMajor = teacherMajor;
    }

    public String getteacherAddress() {
        return teacherAddress;
    }

    public void setteacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public String getteacherEmail() {
        return teacherEmail;
    }

    public void setteacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return teacherSeq == teacher.teacherSeq &&
                Objects.equals(teacherName, teacher.teacherName) &&
                Objects.equals(teacherId, teacher.teacherId) &&
                Objects.equals(teacherAge, teacher.teacherAge) &&
                Objects.equals(teacherGender, teacher.teacherGender) &&
                Objects.equals(teacherPhone, teacher.teacherPhone) &&
                Objects.equals(teacherMajor, teacher.teacherMajor) &&
                Objects.equals(teacherAddress, teacher.teacherAddress) &&
                Objects.equals(teacherEmail, teacher.teacherEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherSeq, teacherName, teacherId, teacherAge, teacherGender, teacherPhone, teacherMajor, teacherAddress, teacherEmail);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherSeq=" + teacherSeq +
                ", teacherName='" + teacherName + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", teacherAge='" + teacherAge + '\'' +
                ", teacherGender='" + teacherGender + '\'' +
                ", teacherPhone='" + teacherPhone + '\'' +
                ", teacherMajor='" + teacherMajor + '\'' +
                ", teacherAddress='" + teacherAddress + '\'' +
                ", teacherEmail='" + teacherEmail + '\'' +
                '}';
    }
}
