package com.hallth.utils;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

@Service
public class ReadTxt {

    public String readtxt(String pathname){
        int count = 0;
        int b = 0;
        StringBuffer sb = new StringBuffer();
        try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
            /* 读入TXT文件 */
//            String pathname = "C:\\Users\\YowYouth\\Desktop\\test.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
            File filename = new File(pathname); // 要读取以上路径的test.txt文件
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename), "UTF-8"); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            while ((line = br.readLine()) != null) {
                count++;
                String[] a = line.split("\\t");
                sb.append(line).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
