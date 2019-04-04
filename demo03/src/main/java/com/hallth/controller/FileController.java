package com.hallth.controller;

import com.hallth.utils.ReadTxt;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
@RequestMapping("/file")
public class FileController {
    private static Logger logger = Logger.getLogger(LoginController.class.getName());

    @Resource
    private ReadTxt readTxt;

    @RequestMapping("/fileHomePage")
    public String fileHomePage(){
        return "filesystem/fileUpload";
    }

    @RequestMapping(value = "/fileUpload", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(String uploadFilePath, Model model) {
        //从页面之中提取输入的信息,并且封装好
        //获取了页面的信息之后,就将信息发送到想要展示的页面 C:\Users\YowYouth\Desktop\2016年11月13日宣河独钓主擂谜会题.txt
        String fileName = uploadFilePath.substring(uploadFilePath.lastIndexOf("\\")+1);
        logger.info("name: " + fileName);
        model.addAttribute("uploadFileName", fileName);
        String fileTypeCode = fileName.substring(fileName.lastIndexOf(".")+1);
        String fileType = getFileType(fileTypeCode);
        model.addAttribute("fileType", fileType);
        String encoding = System.getProperty("file.encoding");
        model.addAttribute("encoding",encoding);
        String fileContent = readTxt.readtxt(uploadFilePath);
        model.addAttribute("fileContent",fileContent);
        return "filesystem/fileUpload";
    }

    public String getFileType(String fileTypeCode){
        if("txt".equals(fileTypeCode)){
            return "文本文档";
        } else if("doc".equals(fileTypeCode)){
            return "03Word文档";
        } else if ("docx".equals(fileTypeCode)) {
            return "07Word文档";
        } else {
            return "未知类型文件";
        }
    }

}
