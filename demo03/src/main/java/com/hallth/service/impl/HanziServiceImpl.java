package com.hallth.service.impl;

import com.hallth.domain.Hanzi;
import com.hallth.mapper.HanziMapper;
import com.hallth.service.HanziService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HanziServiceImpl implements HanziService {

    @Resource
    private HanziMapper hanziMapper;

    public List<Hanzi> selectHanzi(Hanzi hanzi){
        return hanziMapper.selectHanzi(hanzi);
    }
}
