package com.hallth.mapper;

import com.hallth.domain.SeqTab;

public interface SeqTabMapper {
    int insert(SeqTab record);

    int insertSelective(SeqTab record);

    int getNextSeq(SeqTab record);

    int updateNextSeq(SeqTab seqTab);
}