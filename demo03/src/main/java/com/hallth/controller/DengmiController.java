package com.hallth.controller;


import com.github.pagehelper.Page;
import com.hallth.domain.Dengmi;
import com.hallth.service.DengmiService;
import com.hallth.utils.ExcelUtil;
import com.hallth.utils.TxtUtil;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dengmi")
public class DengmiController {
    private static Logger logger = Logger.getLogger(LoginController.class.getName());

    @Resource
    private DengmiService dengmiService;
    @Resource
    private TxtUtil txtUtil;
    @Resource
    private ExcelUtil excelUtil;

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

    @RequestMapping(value = "/louchun", method = {RequestMethod.GET})
    public String louchunPage(Model model){
        return "dengmi/louchunJiance";
    }

    @RequestMapping(value = "/louchunCheck", method = {RequestMethod.GET})
    public String louchunCheck(String louchunFile, Model model){
        if(!louchunFile.endsWith("txt")) {
            model.addAttribute("checkResult","暂不支持此文件类型。");
            return "dengmi/louchunJiance";
        }
        String txtContent = txtUtil.readtxt(louchunFile);
        String[] lineDatas = txtContent.split("\n");
        StringBuffer sb = new StringBuffer();
        int count = 0;
        for(String line : lineDatas){
            String[] dengmiDatas = line.split("\t");
            String mimian = dengmiDatas[0];
            String midi = dengmiDatas[2];
            char[] mimianChars = mimian.toCharArray();
            char[] midiChars = midi.toCharArray();
            for(char c : midiChars){
                for(char midiC : mimianChars){
                    if (c == midiC){
                        sb.append(line).append("\t露字：" ).append(c).append("\n");
                        count ++;
                    }
                }
            }
        }
        if(count == 0){
            model.addAttribute("checkResult","一共检测" + lineDatas.length + "条灯谜，无露春。");
        } else {
            model.addAttribute("checkResult","一共检测" + lineDatas.length + "条灯谜，露春" + count + "条。");
            model.addAttribute("louchunDengmi",sb.toString());
        }
        return "dengmi/louchunJiance";
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
        if(!zuozheQ.trim().isEmpty()){
            dengmi.setZuozhe(zuozheQ);
        }
        if(!migeQ.trim().isEmpty()){
            dengmi.setMidi(migeQ);
        }
        if(!leixingQ.trim().isEmpty()){
            dengmi.setMidi(leixingQ);
        }

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

    @RequestMapping(value = "/mulAddDengmi", method={RequestMethod.GET})
    public String mulAddDengmi(Model model){
        return "dengmi/addDengmis";
    }

    @RequestMapping(value = "/addDengmis", method = {RequestMethod.GET})
    public void addDengmis(String mulAddFile, Model model){
        List<Dengmi> insertList = new ArrayList<>();
        if(mulAddFile.endsWith("txt")){
            insertList = addDengmiByTxt(mulAddFile);
        } else if(mulAddFile.endsWith("xls") || mulAddFile.endsWith("xlsx")){
            insertList = addDengmiByExcel(mulAddFile);
        }
        int insertResult = 0;
        if(insertList.size() > 0){
            insertResult = dengmiService.insertList(insertList);
        }
        if(insertResult > 0){
            model.addAttribute("result","批量添加成功！");
        } else {
            model.addAttribute("result", "批量添加失败！");
        }
    }
    public List<Dengmi> addDengmiByTxt(String mulAddFile){
        String txtContent = txtUtil.readtxt(mulAddFile);
        String[] lines = txtContent.split("\n");
        List<Dengmi> insertList = new ArrayList<Dengmi>();
        int i = 0;
        for(String lineData : lines){
            Dengmi dengmi = getInsertList(lineData, i);
            i++;
            insertList.add(dengmi);
        }
        return insertList;
    }

    public List<Dengmi> addDengmiByExcel(String filePath){
        List<Dengmi> insertList = new ArrayList<>();
        List<List<StringBuffer>> excelDatas = excelUtil.readExcelFile(filePath);
        for(List<StringBuffer> sheetDatas : excelDatas){
            for(int i = 0; i < sheetDatas.size(); i++){
                StringBuffer rowData=sheetDatas.get(i);
                Dengmi dengmi = getInsertList(rowData.toString(),i);
                insertList.add(dengmi);
            }
        }
        return insertList;
    }

    public Dengmi getInsertList(String lineData,int i){
        String[] dengmiMsg = lineData.split("\t");
        int dengmiSeq = dengmiService.getMaxSeq() + 1 + i;
        String mimian = dengmiMsg[0];
        String mimumige = dengmiMsg[1];

        String midi = dengmiMsg[2];
        String zuozhe = "佚名";
        if(dengmiMsg.length > 3){
            zuozhe = dengmiMsg[3];
        }
        Dengmi dengmi = new Dengmi();
        dengmi.setDengmiSeq(dengmiSeq);
        dengmi.setMimian(mimian);
        dengmi.setMimu(mimumige);
        dengmi.setMidi(midi);
        dengmi.setZuozhe(zuozhe);
        return dengmi;
    }

    @RequestMapping(value = "/addDengmiSeq")
    public String addDengmiSeq(Model model){
        int a = dengmiService.getMaxSeq();
        List<Dengmi> dList = dengmiService.queryAllDengmiWithoutSeq();
        for(Dengmi dengmi : dList){
            a++;
            dengmi.setDengmiSeq(a);
            dengmiService.updateSeq(dengmi);
        }
        model.addAttribute("result", "add SEQ success");
        return "dengmi/addDengmis";
    }

    @RequestMapping(value = "/deleteSeqNull", method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteSeqNull(Model model){
        dengmiService.deleteSeqNull();
        model.addAttribute("result","delete null SEQ success");
        return "dengmi/addDengmis";
    }

    @RequestMapping(value = "/deleteChoesed/{dengmiSeq}", method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteDengmi(@PathVariable int dengmiSeq, Model model){
        Dengmi dengmi = new Dengmi();
        dengmi.setDengmiSeq(dengmiSeq);
        dengmiService.deleteDengmiBySeq(dengmi);
        return "dengmi/showDengmi";
    }
}
