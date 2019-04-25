package com.hallth.controller;

import com.hallth.domain.Hanzi;
import com.hallth.service.HanziService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/hanzi")
public class HanziController {

    private Logger logger = Logger.getLogger(HanziController.class.getName());


    @Resource
    private HanziService hanziService;

    @RequestMapping(value = "/hanziQuery/{pageSize}/{pageNum}")
    public String hanziQuery(String hanziQ, String shengmuQ, String yunmuQ, Integer shengdiaoQ, String ziyiQ, Integer bihuashuQ, @PathVariable int pageSize,@PathVariable int pageNum, Model model){
        Hanzi hanzi = new Hanzi();
        hanzi.setPageNum(pageNum);
        hanzi.setPageSize(pageSize);
        if(!hanziQ.trim().isEmpty()){
            hanzi.setHanzi(hanziQ);
            model.addAttribute("hanziQ",hanziQ);
        }
        if(!shengmuQ.trim().isEmpty()){
            model.addAttribute("shengmuQ",shengmuQ);
            hanzi.setShengmu(shengmuQ);
        }
        if(shengdiaoQ != null){
            model.addAttribute("shengdiaoQ",shengdiaoQ);
            hanzi.setShengdiao(shengdiaoQ);
        }
        if(!yunmuQ.trim().isEmpty()){
            model.addAttribute("yunmuQ",yunmuQ);
            hanzi.setYunmu(yunmuQ);
        }
        if(!ziyiQ.trim().isEmpty()){
            model.addAttribute("ziyiQ",ziyiQ);
            hanzi.setZiyi(ziyiQ);
        }
        if(bihuashuQ != null){
            model.addAttribute("bihuashuQ",bihuashuQ);
            hanzi.setBihuashu(bihuashuQ);
        }
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("pageNum", pageNum);
        int startSeq = (pageNum-1) * pageSize;
        hanzi.setStartSeq(startSeq);
        List<Hanzi> hanziList = hanziService.selectHanzi(hanzi);
        int count = hanziService.countHanzi(hanzi);
        setModel(model,count,pageSize, hanziList);
        return "hanzi/hanziQuery";
    }

    @RequestMapping(value = "/hanziQueryPage")
    public String hanziQueryPage(Model model){
        Hanzi hanzi = new Hanzi();
        hanzi.setPageSize(10);
        hanzi.setPageNum(1);
        hanzi.setStartSeq(0);
        List<Hanzi> hanziList = hanziService.selectHanzi(hanzi);
        int count = hanziService.countHanzi(hanzi);
        setModel(model, count, 10, hanziList);
        model.addAttribute("pageSize",10);
        model.addAttribute("pageNum", 1);
        return "hanzi/hanziQuery";
    }

    private Model setModel(Model model, int count, int pageSize, List<Hanzi> hanziList){
        if(hanziList.size() > 0) {
            model.addAttribute("countRows",count);
            int pageMax = 0;
            if(count%10 > 0){
                pageMax = (count/pageSize) + 1;
            } else {
                pageMax = count/pageSize;
            }
            model.addAttribute("pageMax", pageMax);
            model.addAttribute("hanziList", hanziList);
            model.addAttribute("isNull", "notNull");
        } else {
            model.addAttribute("noResult","没有符合条件的查询结果！");
        }
        return model;
    }

    @RequestMapping(value = {"/modifyHanzi/{hanzi}/{shengdiao}/{yunmu}/{shengmu}"}, method = RequestMethod.GET)
    public String modifyHanzi(@PathVariable("hanzi") String hanzi,@PathVariable("shengdiao") Integer shengdiao,
                              @PathVariable("yunmu") String yunmu, @PathVariable("shengmu") String shengmu, Model model){
        logger.info("修改汉字" + hanzi + "(" +  shengmu + yunmu + shengdiao + ")" + "的信息");
        Hanzi hanziEntry = new Hanzi();
        hanziEntry.setHanzi(hanzi);
        hanziEntry.setShengdiao(shengdiao);
        if(!shengmu.isEmpty() && !"无".equals(shengmu))
            hanziEntry.setShengmu(shengmu);
        hanziEntry.setYunmu(yunmu);
        hanziEntry = hanziService.selectHanzi(hanziEntry).get(0);
        model.addAttribute("entry",hanziEntry);
        return "hanzi/hanziModify";
    }

    @RequestMapping(value = "/modifyHanzi", method = {RequestMethod.GET})
    public String modifyHanzi(String hanziM, String shengmuM, String yunmuM, String shengdiao, String ziyi, Model model){
        return "";
    }

}
