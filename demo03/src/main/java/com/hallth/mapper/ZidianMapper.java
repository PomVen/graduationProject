package com.hallth.mapper;

import com.hallth.domain.Zidian;
import com.hallth.domain.ZidianWithBLOBs;

import java.util.List;

public interface ZidianMapper {
    int deleteByPrimaryKey(Float id);

    int insert(ZidianWithBLOBs record);

    int insertSelective(ZidianWithBLOBs record);

    ZidianWithBLOBs selectByPrimaryKey(Float id);

    int updateByPrimaryKeySelective(ZidianWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ZidianWithBLOBs record);

    int updateByPrimaryKey(Zidian record);

    List<ZidianWithBLOBs> selectZi(ZidianWithBLOBs zidianWithBLOBs);
}