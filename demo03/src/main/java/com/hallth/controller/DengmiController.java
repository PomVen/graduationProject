package com.hallth.controller;


import com.github.pagehelper.Page;
import com.hallth.domain.Dengmi;
import com.hallth.service.DengmiService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dengmi")
public class DengmiController {
    private static Logger logger = Logger.getLogger(LoginController.class.getName());

    @Resource
    private DengmiService dengmiService;

    @RequestMapping(value = "/showDengmi", method = {RequestMethod.GET, RequestMethod.POST})
    public String showDengmi(Model model){
        List<Dengmi> dengmiList = dengmiService.queryAllDengmi(new Dengmi());
        model.addAttribute("dengmiList",dengmiList);
        if(dengmiList.size() > 0){
            model.addAttribute("isNull","notnull");
        }
        int count = dengmiService.countDengmi(new Dengmi());
        model.addAttribute("countRows", count);
        int pageMax = 0;
        if(count%10 > 0){
            pageMax = (count/10) + 1;
        } else {
            pageMax = count/10;
        }
        model.addAttribute("pageMax", pageMax);
        model.addAttribute("pageSize", 10);
        model.addAttribute("pageNum", 1);
        return "dengmi/showDengmi";
    }

    @RequestMapping(value = "/sayDengmi", method = {RequestMethod.GET, RequestMethod.POST})
    public String sayDengmi(Model model){
        return "dengmi/sayDengmi";
    }

    @RequestMapping(value = "/queryMicai", method = {RequestMethod.GET, RequestMethod.POST})
    public String queryMicai(Model model){
        return "dengmi/queryMicai";
    }

    @RequestMapping(value = "/teachDengmi", method = {RequestMethod.GET, RequestMethod.POST})
    public String teachDengmi(Model model){
        return "dengmi/teachDengmi";
    }

    @RequestMapping(value = "/queryDengmi/{pageSize}/{pageNum}", method = {RequestMethod.GET})
    public String queryDengmi(String mimianQ, String mimuQ, String migeQ, String midiQ, String zuozheQ, String leixingQ,
                              @PathVariable int pageSize, @PathVariable int pageNum, Model model){
        Dengmi dengmi = new Dengmi();
        if(!mimianQ.trim().isEmpty()){
            dengmi.setMimian(mimianQ);
        }
        if(!mimuQ.trim().isEmpty()){
            dengmi.setMimu(mimuQ);
        }
        if(!midiQ.trim().isEmpty()){
            dengmi.setMidi(midiQ);
        }
        dengmi.setMige(migeQ);
        dengmi.setZuozhe(zuozheQ);
        dengmi.setLeixing(leixingQ);

        model.addAttribute("mimianQ", mimianQ);
        model.addAttribute("mimuQ", mimuQ);
        model.addAttribute("migeQ", migeQ);
        model.addAttribute("midiQ", midiQ);
        model.addAttribute("zuozheQ", zuozheQ);
        model.addAttribute("leixingQ", leixingQ);

        List<Dengmi> dengmiList = dengmiService.queryDengmi(dengmi, pageNum, pageSize);
        model.addAttribute("dengmiList",dengmiList);
        int count = dengmiService.countDengmi(dengmi);
        model.addAttribute("countRows", count);
        int pageMax = 0;
        if(count%10 > 0){
            pageMax = (count/pageSize) + 1;
        } else {
            pageMax = count/pageSize;
        }
        model.addAttribute("pageMax", pageMax);
        if(dengmiList.size() > 0){
            model.addAttribute("isNull","notnull");
        } else {
            model.addAttribute("noResult","查询结果为空！");
        }
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("pageNum", pageNum);
//        Map map = new HashMap();
//        map.put("total", dengmiList.getTotal());
//        map.put("rows",dengmiList.getResult());
//        model.addAttribute("pageNum",pageNum);
//        model.addAttribute("pageSize",pageSize);
        return "dengmi/showDengmi";
    }

    @RequestMapping(value = "/addDengmiPage", method = {RequestMethod.GET, RequestMethod.POST})
    public String addDengmiPage(Model model){
        return "dengmi/addDengmi";
    }

    @RequestMapping(value = "/addDengmi", method = {RequestMethod.GET, RequestMethod.POST})
    public String addDengmi(String mimian, String mimu, String mige, String midi, String zuozhe, String mizhu, String jieshi, String shangxi, String leixing, Model model){
        Dengmi dengmi = new Dengmi();
        if(zuozhe != null && !zuozhe.isEmpty())
            dengmi.setZuozhe(zuozhe);
        if(leixing != null && !leixing.isEmpty())
            dengmi.setLeixing(leixing);
        if(midi != null && !midi.isEmpty())
            dengmi.setMidi(midi);
        if(mimian != null && !mimian.isEmpty())
            dengmi.setMimian(mimian);
        if(mimu != null && !mimu.isEmpty())
            dengmi.setMimu(mimu);
        if(mige != null && !mige.isEmpty())
            dengmi.setMige(mige);
        if(mizhu != null && !mizhu.isEmpty())
            dengmi.setMizhu(mizhu);
        if(jieshi != null && !jieshi.isEmpty())
            dengmi.setJieshi(jieshi);
        int a = dengmiService.addDengmi(dengmi);
        if(a == 1){
            model.addAttribute("addResult", a);
            model.addAttribute("dengmi",dengmi);
        }
        return "dengmi/addDengmi";
    }

    @RequestMapping(value = "/addDengmis")
    public String addDengmis(Model model){
        int a = dengmiService.getMaxSeq();
        List<Dengmi> dList = dengmiService.queryAllDengmiWithoutSeq();
        for(Dengmi dengmi : dList){
            a++;
            dengmi.setDengmiSeq(a);
            dengmiService.updateSeq(dengmi);
        }
        model.addAttribute("result", "success");
        return "dengmi/addDengmis";
    }

    @RequestMapping(value = "/deleteSeqNull", method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteSeqNull(){
        dengmiService.deleteSeqNull();
        return "dengmi/addDengmi";
    }

    @RequestMapping(value = "/deleteChoesed/{dengmiSeq}", method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteDengmi(@PathVariable int dengmiSeq, Model model){
        Dengmi dengmi = new Dengmi();
        dengmi.setDengmiSeq(dengmiSeq);
        dengmiService.deleteDengmiBySeq(dengmi);
        return "dengmi/showDengmi";
    }
}
