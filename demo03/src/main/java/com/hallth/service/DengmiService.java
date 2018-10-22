package com.hallth.service;

import com.hallth.domain.Dengmi;
import com.hallth.domain.PageBean;

import java.util.HashMap;
import java.util.List;

public interface DengmiService {
    List<Dengmi> selectDengmiByPage(Dengmi dengmi);

    long getDengmiCount(Dengmi dengmi);

    PageBean<Dengmi> findByPage(int currentPage);
}
