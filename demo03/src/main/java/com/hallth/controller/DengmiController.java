package com.hallth.controller;

import com.hallth.domain.Dengmi;
import com.hallth.domain.PageBean;
import com.hallth.service.impl.DengmiServiceImpl;
import com.hallth.util.ReadFiles;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/dengmi")
public class DengmiController {
    //初始化日志
    private static Logger logger = Logger.getLogger(DengmiController.class.getName());
    @Autowired
    private ReadFiles readFiles;
    @Resource
    private DengmiServiceImpl dengmiService;

    @RequestMapping("/home")
    public String toDengmiHome() {
        logger.info("跳转到灯谜区首页");
        return "dengmi/home";
    }

    @RequestMapping("/addDengmi")
    public String addDengmi(@RequestParam("dengmiPath") String dengmiPath, @RequestParam("fileName") String fileName, Model model) {
        logger.info("开始批量插入灯谜；param:filePath=" + dengmiPath);
        File file = new File(dengmiPath);
        readFiles.readTxt(file);
        return "";
    }

    @RequestMapping("/chaxun")
    public String chaxunDengmi(@RequestParam("mimian") String mimian, @RequestParam("mimumige") String mimumige,
                               @RequestParam("midi") String midi, @RequestParam("shangxi") String shangxi,
                               @RequestParam("author") String author, @RequestParam("currentPage") String currentPage, Model model) {
        logger.info("开始查询灯谜");
        Dengmi dengmi = new Dengmi();
        if (mimian != null && !mimian.trim().isEmpty()) {
            dengmi.setMimian(mimian);
        }
        if (mimumige != null && !mimumige.trim().isEmpty()) {
            dengmi.setMimumige(mimumige);
        }
        if (midi != null && !midi.trim().isEmpty()) {
            dengmi.setMidi(midi);
        }
        if (shangxi != null && !shangxi.trim().isEmpty()) {
            dengmi.setShangxi(shangxi);
        }
        if (author != null && !author.trim().isEmpty()) {
            dengmi.setAuthor(author);
        }
        logger.info("param: [" + dengmi.toString() + "]");
        PageBean<Dengmi> dengmiList = dengmiService.findByPage(Integer.parseInt(currentPage));
//        List<Dengmi> dengmis = dengmiService.selectDengmiByPage(dengmi);
        long dengmiCount = dengmiList.getLists().size();
        model.addAttribute("pagemsg", dengmiList);
        model.addAttribute("count", dengmiCount);
        return "dengmi/showDengmi";
    }

    @RequestMapping("/test")
    public String test(){
        return "dengmi/test";
    }

}
