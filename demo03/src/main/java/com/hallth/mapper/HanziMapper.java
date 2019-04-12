package com.hallth.mapper;

import com.hallth.domain.Hanzi;

import java.util.List;

public interface HanziMapper {
    int insert(Hanzi record);

    int insertSelective(Hanzi record);

    List<Hanzi> selectHanzi(Hanzi hanzi);

    int insertList(List<Hanzi> hanziList);
}