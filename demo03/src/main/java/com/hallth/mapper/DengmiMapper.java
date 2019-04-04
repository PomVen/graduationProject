package com.hallth.mapper;

import com.hallth.domain.Dengmi;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DengmiMapper {
    int deleteByPrimaryKey(Integer dengmiSeq);

    int insert(Dengmi record);

    int insertSelective(Dengmi record);

    Dengmi selectByPrimaryKey(Integer dengmiSeq);

    int updateByPrimaryKeySelective(Dengmi record);

    int updateByPrimaryKey(Dengmi record);

    int getMaxSeq();

    List<Dengmi> selectDengmi(Dengmi dengmi);

    List<Dengmi> selectDengmi(@Param("user") Dengmi dengmi, @Param("startSeq")int startSeq, @Param("pageSize") int pageSize);

    List<Dengmi> queryAllDengmiWithoutSeq();

    int updateSeq(Dengmi dengmi);

    int deleteDengmiBySeq(Dengmi dengmi);

    int deleteSeqNull();

    int countDengmi(Dengmi dengmi);
}