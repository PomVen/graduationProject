package com.hallth.utils;

import com.hallth.domain.SeqTab;
import com.hallth.mapper.SeqTabMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SeqUtil {
    @Resource
    private SeqTabMapper seqTabMapper;

    public int getNextSeq(String tabName){
        SeqTab seqTab = new SeqTab();
        seqTab.setTabName(tabName);
        int next = seqTabMapper.getNextSeq(seqTab);
        seqTab.setNextSeq(next + 1);
        updateNextSeq(seqTab);
        return next;
    }

    private int updateNextSeq(SeqTab seqTab){
        return seqTabMapper.updateNextSeq(seqTab);
    }
}
