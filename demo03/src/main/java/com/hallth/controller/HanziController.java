package com.hallth.controller;

import com.hallth.domain.Hanzi;
import com.hallth.service.HanziService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/hanzi")
public class HanziController {

    private Logger logger = Logger.getLogger(HanziController.class.getName());


    @Resource
    private HanziService hanziService;

    @RequestMapping(value = "/hanziQuery")
    public String hanziQueryPage(Model model){
        List<Hanzi> hanziList = hanziService.selectHanzi(new Hanzi());
        model.addAttribute("hanziList", hanziList);
        model.addAttribute("isNull","notNull");
        return "hanzi/hanziQuery";
    }

}
