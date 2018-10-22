package com.hallth.service.impl;

import com.hallth.domain.Dengmi;
import com.hallth.domain.PageBean;
import com.hallth.mapper.DengmiMapper;
import com.hallth.service.DengmiService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class DengmiServiceImpl implements DengmiService {
    private static Logger logger = Logger.getLogger(DengmiServiceImpl.class.getName());

    @Resource
    private DengmiMapper dengmiMapper;

    public List<Dengmi> selectDengmiByPage(Dengmi dengmi){
        List<Dengmi> dengmis = dengmiMapper.selectDengmiByPage(dengmi);
        return  dengmis;
    }

    public long getDengmiCount(Dengmi dengmi){
        long count = dengmiMapper.getDengmiCount(dengmi);
        return  count;
    }

    public PageBean<Dengmi> findByPage(int currentPage){
        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Dengmi> pageBean = new PageBean<Dengmi>();
        //封装当前页数
        pageBean.setCurrPage(currentPage);
        //每页显示的数据
        int pageSize=2;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount = dengmiMapper.selectCount();
        pageBean.setTotalCount(totalCount);
        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());
        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        //封装每页显示的数据
        List<Dengmi> lists = dengmiMapper.findByPage(map);
        pageBean.setLists(lists);
        return  pageBean;
    }
}
