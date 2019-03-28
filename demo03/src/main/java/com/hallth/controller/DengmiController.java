package com.hallth.controller;


import com.hallth.domain.Dengmi;
import com.hallth.service.DengmiService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
@RequestMapping("/dengmi")
public class DengmiController {
    private static Logger logger = Logger.getLogger(LoginController.class.getName());

    @Resource
    private DengmiService dengmiService;

    @RequestMapping(value = "/showDengmi", method = {RequestMethod.GET, RequestMethod.POST})
    public String showDengmi(){
        return "dengmi/showDengmi";
    }

    @RequestMapping(value = "/addDengmi", method = {RequestMethod.GET, RequestMethod.POST})
    public String addDengmi(String mimian, String mimu, String mige, String midi, String zuozhe, String mizhu, String jieshi, String shangxi, String leixing, Model model){
        Dengmi dengmi = new Dengmi();
        dengmi.setZuozhe(zuozhe);
        dengmi.setLeixing(leixing);
        dengmi.setMidi(midi);
        dengmi.setMimian(mimian);
        dengmi.setMimu(mimu);
        dengmi.setMige(mige);
        dengmi.setMizhu(mizhu);
        dengmi.setJieshi(jieshi);
        int a = dengmiService.addDengmi(dengmi);
        if(a == 1){
            model.addAttribute("addResult", a);
            model.addAttribute("dengmi",dengmi);
        }
        return "dengmi/showDengmi";
    }
}
