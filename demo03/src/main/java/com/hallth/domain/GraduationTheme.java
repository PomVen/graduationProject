package com.hallth.domain;

import java.util.Objects;

public class GraduationTheme {
    private String themeSeq;
    private String themeTitle;
    private String themeIntroduction;
    private String themeTeacher;

    public String getthemeSeq() {
        return themeSeq;
    }

    public void setthemeSeq(String themeSeq) {
        this.themeSeq = themeSeq;
    }

    public String getthemeTitle() {
        return themeTitle;
    }

    public void setthemeTitle(String themeTitle) {
        this.themeTitle = themeTitle;
    }

    public String getthemeIntroduction() {
        return themeIntroduction;
    }

    public void setthemeIntroduction(String themeIntroduction) {
        this.themeIntroduction = themeIntroduction;
    }

    public String getthemeTeacher() {
        return themeTeacher;
    }

    public void setthemeTeacher(String themeTeacher) {
        this.themeTeacher = themeTeacher;
    }

    @Override
    public String toString() {
        return "GraduationTheme{" +
                "themeSeq='" + themeSeq + '\'' +
                ", themeTitle='" + themeTitle + '\'' +
                ", themeIntroduction='" + themeIntroduction + '\'' +
                ", themeTeacher='" + themeTeacher + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraduationTheme that = (GraduationTheme) o;
        return Objects.equals(themeSeq, that.themeSeq) &&
                Objects.equals(themeTitle, that.themeTitle) &&
                Objects.equals(themeIntroduction, that.themeIntroduction) &&
                Objects.equals(themeTeacher, that.themeTeacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(themeSeq, themeTitle, themeIntroduction, themeTeacher);
    }
}
