package com.hallth.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class VBAUtils {
    public static final void xls2xlsx(String filePath) {
        //TODO：测试
        try {
            Process process = Runtime.getRuntime().exec("cscript \"" + "C:\\aaa\\xls2xlsx.vbs\" \"" + filePath + "\"");
            InputStream inputStream = process.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);// 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            while ((line= br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        xls2xlsx("C:\\aaa\\aaa.xls");
    }
}
