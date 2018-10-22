package com.hallth.mapper;

import com.hallth.domain.Dengmi;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface DengmiMapper {
    int deleteByPrimaryKey(Integer xuhao);

    int insert(Dengmi record);

    int insertSelective(Dengmi record);

    Dengmi selectByPrimaryKey(Integer xuhao);

    int updateByPrimaryKeySelective(Dengmi record);

    int updateByPrimaryKey(Dengmi record);

    List<Dengmi> selectDengmiByPage(Dengmi dengmi);

    Long getDengmiCount(Dengmi dengmi);

    List<Dengmi> findByPage(HashMap<String, Object> map);

    int selectCount();
}