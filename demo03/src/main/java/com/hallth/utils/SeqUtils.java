package com.hallth.utils;

import com.hallth.mapper.DengmiMapper;
import com.hallth.service.DengmiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SeqUtils {

    @Resource
    private DengmiMapper dengmiMapper;

    public int getNextDengmiSeq(){
        return dengmiMapper.getMaxSeq();
    }

}
