package com.hallth.service;

import com.hallth.domain.Dengmi;

import java.util.List;

public interface DengmiService {

    List<Dengmi> queryAllDengmi(Dengmi dengmi);

    int addDengmi(Dengmi dengmi);
}
