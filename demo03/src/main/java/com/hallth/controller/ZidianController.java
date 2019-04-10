package com.hallth.controller;

import com.hallth.domain.ZidianWithBLOBs;
import com.hallth.service.ZidianService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value="/zidian")
public class ZidianController {
    private  Logger logger = Logger.getLogger(ZidianController.class.getName());
    @Resource
    private ZidianService zidianService;

    @RequestMapping(value = "/queryPage" , method = {RequestMethod.GET})
    public String queryPage(Model model){
        List<ZidianWithBLOBs> zidianList = zidianService.selectZi(new ZidianWithBLOBs());
        model.addAttribute("isNull","notNull");
        model.addAttribute("zidianList",zidianList);
        return "hanzi/hanziQuery";
    }

}
