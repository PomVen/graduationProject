package com.hallth.domain;

public class Dengmi {
    private Integer xuhao;

    private String mimian;

    private String mimumige;

    private String mizhu;

    private String midi;

    private String shangxi;

    private String author;

    public Integer getXuhao() {
        return xuhao;
    }

    public void setXuhao(Integer xuhao) {
        this.xuhao = xuhao;
    }

    public String getMimian() {
        return mimian;
    }

    public void setMimian(String mimian) {
        this.mimian = mimian;
    }

    public String getMimumige() {
        return mimumige;
    }

    public void setMimumige(String mimumige) {
        this.mimumige = mimumige;
    }

    public String getMizhu() {
        return mizhu;
    }

    public void setMizhu(String mizhu) {
        this.mizhu = mizhu;
    }

    public String getMidi() {
        return midi;
    }

    public void setMidi(String midi) {
        this.midi = midi;
    }

    public String getShangxi() {
        return shangxi;
    }

    public void setShangxi(String shangxi) {
        this.shangxi = shangxi;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dengmi dengmi = (Dengmi) o;

        if (xuhao != null ? !xuhao.equals(dengmi.xuhao) : dengmi.xuhao != null) return false;
        if (mimian != null ? !mimian.equals(dengmi.mimian) : dengmi.mimian != null) return false;
        if (mimumige != null ? !mimumige.equals(dengmi.mimumige) : dengmi.mimumige != null) return false;
        if (mizhu != null ? !mizhu.equals(dengmi.mizhu) : dengmi.mizhu != null) return false;
        if (midi != null ? !midi.equals(dengmi.midi) : dengmi.midi != null) return false;
        if (shangxi != null ? !shangxi.equals(dengmi.shangxi) : dengmi.shangxi != null) return false;
        return author != null ? author.equals(dengmi.author) : dengmi.author == null;
    }

    @Override
    public int hashCode() {
        int result = xuhao != null ? xuhao.hashCode() : 0;
        result = 31 * result + (mimian != null ? mimian.hashCode() : 0);
        result = 31 * result + (mimumige != null ? mimumige.hashCode() : 0);
        result = 31 * result + (mizhu != null ? mizhu.hashCode() : 0);
        result = 31 * result + (midi != null ? midi.hashCode() : 0);
        result = 31 * result + (shangxi != null ? shangxi.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Dengmi{" +
                "xuhao=" + xuhao +
                ", mimian='" + mimian + '\'' +
                ", mimumige='" + mimumige + '\'' +
                ", mizhu='" + mizhu + '\'' +
                ", midi='" + midi + '\'' +
                ", shangxi='" + shangxi + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    /**
     * 当谜面和谜底相同时，判定为同一条灯谜
     * */
    public boolean isSameAs(Object o){
        if (o == null || getClass() != o.getClass())
            return false;
        Dengmi dengmi = (Dengmi) o;
        if(mimian.equals(dengmi.mimian) && midi.equals(dengmi.midi))
            return true;
        return false;
    }
}