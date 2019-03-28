package com.hallth.service.impl;

import com.hallth.domain.Dengmi;
import com.hallth.mapper.DengmiMapper;
import com.hallth.service.DengmiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DengmiServiceImpl implements DengmiService {
    @Resource
    private DengmiMapper dengmiMapper;

    public List<Dengmi> queryAllDengmi(Dengmi dengmi){
        return dengmiMapper.selectDengmi(dengmi);
    }

    public int addDengmi(Dengmi dengmi){
        dengmi.setDengmiSeq(dengmiMapper.getMaxSeq()+1);
        int a = dengmiMapper.insert(dengmi);
        System.out.println("灯谜insert结果为：" + a);
        return a;
    }
}
