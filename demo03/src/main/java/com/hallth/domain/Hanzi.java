package com.hallth.domain;

public class Hanzi {
    private String hanzi;

    private String shengmu;

    private String yunmu;

    private Integer shengdiao;

    private String ziyi;

    private Integer bihuashu;

    private Integer pageSize;

    private Integer pageNum;

    private Integer startSeq;

    public Integer getStartSeq(){
        return  startSeq;
    }

    public void setStartSeq(Integer startSeq){
        this.startSeq = startSeq;
    }

    public Integer getPageSize(){
        return  pageSize;
    }

    public void setPageSize(Integer pageSize){
        this.pageSize = pageSize;
    }

    public Integer getPageNum(){
        return  pageNum;
    }

    public void setPageNum(Integer pageNum){
        this.pageNum = pageNum;
    }

    public Integer getBihuashu(){
        return  bihuashu;
    }

    public void setBihuashu(Integer bihuashu){
        this.bihuashu = bihuashu;
    }

    public String getHanzi() {
        return hanzi;
    }

    public void setHanzi(String hanzi) {
        this.hanzi = hanzi;
    }

    public String getShengmu() {
        return shengmu;
    }

    public void setShengmu(String shengmu) {
        this.shengmu = shengmu;
    }

    public String getYunmu() {
        return yunmu;
    }

    public void setYunmu(String yunmu) {
        this.yunmu = yunmu;
    }

    public Integer getShengdiao() {
        return shengdiao;
    }

    public void setShengdiao(Integer shengdiao) {
        this.shengdiao = shengdiao;
    }

    public String getZiyi() {
        return ziyi;
    }

    public void setZiyi(String ziyi) {
        this.ziyi = ziyi;
    }
}