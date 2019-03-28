package com.hallth.mapper;

import com.hallth.domain.Dengmi;

public interface DengmiMapper {
    int deleteByPrimaryKey(Integer dengmiSeq);

    int insert(Dengmi record);

    int insertSelective(Dengmi record);

    Dengmi selectByPrimaryKey(Integer dengmiSeq);

    int updateByPrimaryKeySelective(Dengmi record);

    int updateByPrimaryKey(Dengmi record);

    int getMaxSeq();
}