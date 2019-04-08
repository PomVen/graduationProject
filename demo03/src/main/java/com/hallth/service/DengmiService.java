package com.hallth.service;

import com.github.pagehelper.Page;
import com.hallth.domain.Dengmi;

import java.util.List;

public interface DengmiService {

    List<Dengmi> queryAllDengmi(Dengmi dengmi);

    int countDengmi(Dengmi dengmi);

    List<Dengmi> queryDengmi(Dengmi dengmi, int pageNum, int pageSize);

    int deleteSeqNull();

    int addDengmi(Dengmi dengmi);

    int getMaxSeq();

    List<Dengmi> queryAllDengmiWithoutSeq();

    int updateSeq(Dengmi dengmi);

    int deleteDengmiBySeq(Dengmi dengmi);

    int insertList(List<Dengmi> insertList);
}
