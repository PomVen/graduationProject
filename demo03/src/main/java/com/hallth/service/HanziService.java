package com.hallth.service;

import com.hallth.domain.Hanzi;

import java.util.List;

public interface HanziService {

    List<Hanzi> selectHanzi(Hanzi hanzi);

    int countHanzi(Hanzi hanzi);

    int insertList(List<Hanzi> hanziList);
}
