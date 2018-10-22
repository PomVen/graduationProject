package com.hallth.util;

import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

@Controller
public class ReadFiles {
    private static Logger logger = Logger.getLogger(ReadFiles.class.getName());

    public String readTxt(String filePath){
        File file = new File(filePath);
        String result = readTxt(file);
        return result;
    }

    public String readTxt(File file){
        String context = "";
            try {
                if (file.isFile() && file.exists()) {
                    //读取的时指定GBK编码格式，若中文出现乱码请尝试utf-8，window默认编码格式为GBK
                    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                    String lineTxt = null;
                    while ((lineTxt = br.readLine()) != null) {
                        context = context + lineTxt + "\n";
                    }
                    br.close();
//					System.out.println(context);
                    logger.info("==============  ["+file.getName()+"] READ OVER  ==============");
                } else {
                    logger.info("文件不存在!");
                }
            } catch (Exception e) {
                logger.info("文件读取错误!");
            }
        return context;
    }
}
