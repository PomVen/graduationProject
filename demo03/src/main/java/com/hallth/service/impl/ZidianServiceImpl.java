package com.hallth.service.impl;

import com.hallth.domain.ZidianWithBLOBs;
import com.hallth.mapper.ZidianMapper;
import com.hallth.service.ZidianService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ZidianServiceImpl implements ZidianService {
    @Resource
    private ZidianMapper zidianMapper;

    public List<ZidianWithBLOBs> selectZi(ZidianWithBLOBs zidianWithBLOBs){
        return  zidianMapper.selectZi(zidianWithBLOBs);
    }
}
