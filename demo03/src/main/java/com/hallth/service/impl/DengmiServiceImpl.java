package com.hallth.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hallth.domain.Dengmi;
import com.hallth.mapper.DengmiMapper;
import com.hallth.service.DengmiService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DengmiServiceImpl implements DengmiService {
    @Resource
    private DengmiMapper dengmiMapper;

    public List<Dengmi> queryAllDengmi(Dengmi dengmi){
        dengmi.setPageSize(10);
        dengmi.setStartSeq(0);
        return dengmiMapper.selectDengmi(dengmi);
    }

    public int countDengmi(Dengmi dengmi){
        return dengmiMapper.countDengmi(dengmi);
    }

    public List<Dengmi> queryDengmi(Dengmi dengmi, int pageNum, int pageSize){
//        Page page = PageHelper.startPage(pageNum,pageSize);
        int startSeq = (pageNum-1) * pageSize;
        dengmi.setStartSeq(startSeq);
        dengmi.setPageSize(pageSize);
        return dengmiMapper.selectDengmi(dengmi);
    }

    public int deleteSeqNull(){
        return dengmiMapper.deleteSeqNull();
    }

    public int addDengmi(Dengmi dengmi){
        dengmi.setDengmiSeq(dengmiMapper.getMaxSeq()+1);
        int a = dengmiMapper.insert(dengmi);
        System.out.println("灯谜insert结果为：" + a);
        return a;
    }

    public int getMaxSeq(){
        return dengmiMapper.getMaxSeq();
    };

    public List<Dengmi> queryAllDengmiWithoutSeq(){
        return dengmiMapper.queryAllDengmiWithoutSeq();
    }

    public int updateSeq(Dengmi dengmi){
        return dengmiMapper.updateSeq(dengmi);
    }

    public int deleteDengmiBySeq(Dengmi dengmi){
        return dengmiMapper.deleteDengmiBySeq(dengmi);
    }

    public int insertList(List<Dengmi> insertList){
        return dengmiMapper.insertList(insertList);
    }
}
