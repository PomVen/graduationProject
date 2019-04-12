package com.hallth.utils;

import com.hallth.domain.Hanzi;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class TxtUtil {

    public static void mainp(String[] args) {
        String hanziStr = readtxt("C:\\Users\\YowYouth\\Desktop\\hanzitest.txt");
        System.out.println(hanziStr);
        int b = hanziStr.indexOf("à");
    }

    public static void main(String[] args) {
        String hanziStr = readtxt("C:\\Users\\YowYouth\\Desktop\\hanzi.txt");
        String[] hanziS = hanziStr.split("\n");
        List<Hanzi> hanziList = new ArrayList<>();
        String sql = "insert into hanzi (hanzi,shengmu,yunmu,shengdiao,bihuashu,ziyi) values (";
        for(String hanziInf : hanziS){
            String[] s = hanziInf.split("\t");
            String hanziW = s[0];
            String bihuashu = s[3];
            String pyS = s[1];
            String bushou = s[2];
            String pinyin = s[4];
            String ziyi = s[5];
            //hanzi,shengmu,yunmu,shengdiao,bihuashu
            String[] pys = pinyin.split(",");
            int bihua = Integer.parseInt(bihuashu);
            for(String py : pys){
                String shengmu = "NULL";
                if(py.startsWith("b")){
                    shengmu = "b";
                } else if(py.startsWith("p")){
                    shengmu = "p";
                } else if(py.startsWith("m")){
                    shengmu = "m";
                } else if(py.startsWith("f")){
                    shengmu = "f";
                } else if(py.startsWith("d")){
                    shengmu = "d";
                } else if(py.startsWith("t")){
                    shengmu = "t";
                } else if(py.startsWith("n")){
                    shengmu = "n";
                } else if(py.startsWith("l")){
                    shengmu = "l";
                } else if(py.startsWith("g")){
                    shengmu = "g";
                } else if(py.startsWith("k")){
                    shengmu = "k";
                } else if(py.startsWith("h")){
                    shengmu = "h";
                } else if(py.startsWith("j")){
                    shengmu = "j";
                } else if(py.startsWith("q")){
                    shengmu = "q";
                } else if(py.startsWith("x")){
                    shengmu = "x";
                } else if(py.startsWith("r")){
                    shengmu = "r";
                } else if(py.startsWith("y")){
                    shengmu = "y";
                } else if(py.startsWith("w")){
                    shengmu = "w";
                } else if(py.startsWith("z")){
                    if(py.startsWith("zh"))
                        shengmu = "zh";
                    else
                        shengmu = "z";
                } else if(py.startsWith("c")){
                    if(py.startsWith("ch"))
                        shengmu = "ch";
                    else
                        shengmu = "c";
                } else if(py.startsWith("s")){
                    if(py.startsWith("sh"))
                        shengmu = "sh";
                    else
                        shengmu = "s";
                } else {
                    shengmu = "";
                }
                int shengdiao = -1;
                if(py.indexOf("ā") > 0 || py.indexOf("ō") > 0 || py.indexOf("ē") > 0 || py.indexOf("ī") > 0 || py.indexOf("ū") > 0 || py.indexOf("ǖ") > 0){
                    shengdiao = 1;
                    boolean a = py.indexOf("ā") > 0;
                    boolean o = py.indexOf("ō") > 0;
                    boolean e = py.indexOf("ē") > 0;
                    boolean i = py.indexOf("ī") > 0;
                    boolean u = py.indexOf("ū") > 0;
                    boolean v = py.indexOf("ǖ") > 0;
                    if(a){
                        System.out.println(a);
                        py = py.replaceAll("ā","a");
                    }
                    if(o){
                        System.out.println(o);
                        py = py.replaceAll("ō","o");
                    }
                    if(e){
                        System.out.println(e);
                        py = py.replaceAll("ē","e");
                    }
                    if(i){
                        System.out.println(i);
                        py = py.replaceAll("ī","i");
                    }
                    if(u){
                        System.out.println(u);
                        py = py.replaceAll("ū","u");
                    }
                    if(v){
                        System.out.println(o);
                        py = py.replaceAll("ǖ","ü");
                    }
                } else if(py.indexOf("á") > 0 || py.indexOf("ò") > 0 || py.indexOf("é") > 0 || py.indexOf("í") > 0 || py.indexOf("ú") > 0 || py.indexOf("ǘ") > 0){
                    shengdiao = 2;
                    boolean a = py.indexOf("á") > 0;
                    boolean o = py.indexOf("ò") > 0;
                    boolean e = py.indexOf("é") > 0;
                    boolean i = py.indexOf("í") > 0;
                    boolean u = py.indexOf("ú") > 0;
                    boolean v = py.indexOf("ǘ") > 0;
                    if(a){
                        System.out.println(a);
                        py = py.replaceAll("á","a");
                    }
                    if(o){
                        System.out.println(o);
                        py = py.replaceAll("ò","o");
                    }
                    if(e){
                        System.out.println(e);
                        py = py.replaceAll("é","e");
                    }
                    if(i){
                        System.out.println(i);
                        py = py.replaceAll("í","i");
                    }
                    if(u){
                        System.out.println(u);
                        py = py.replaceAll("ú","u");
                    }
                    if(v){
                        System.out.println(o);
                        py = py.replaceAll("ǘ","ü");
                    }
                } else if(py.indexOf("ǎ") > 0 || py.indexOf("ǒ") > 0 || py.indexOf("ě") > 0 || py.indexOf("ǐ") > 0 || py.indexOf("ǔ") > 0 || py.indexOf("ǚ") > 0){
                    shengdiao = 3;
                    boolean a = py.indexOf("ǎ") > 0;
                    boolean o = py.indexOf("ǒ") > 0;
                    boolean e = py.indexOf("ě") > 0;
                    boolean i = py.indexOf("ǐ") > 0;
                    boolean u = py.indexOf("ǔ") > 0;
                    boolean v = py.indexOf("ǚ") > 0;
                    if(a){
                        System.out.println(a);
                        py = py.replaceAll("ǎ","a");
                    }
                    if(o){
                        System.out.println(o);
                        py = py.replaceAll("ǒ","o");
                    }
                    if(e){
                        System.out.println(e);
                        py = py.replaceAll("ě","e");
                    }
                    if(i){
                        System.out.println(i);
                        py = py.replaceAll("ǐ","i");
                    }
                    if(u){
                        System.out.println(u);
                        py = py.replaceAll("ǔ","u");
                    }
                    if(v){
                        System.out.println(o);
                        py = py.replaceAll("ǚ","ü");
                    }
                } else if(py.indexOf("à") > 0 || py.indexOf("ó") > 0 || py.indexOf("è") > 0 || py.indexOf("ì") > 0 || py.indexOf("ù") > 0 || py.indexOf("ǜ") > 0){
                    shengdiao = 4;
                    boolean a = py.indexOf("à") > 0;
                    boolean o = py.indexOf("ó") > 0;
                    boolean e = py.indexOf("è") > 0;
                    boolean i = py.indexOf("ì") > 0;
                    boolean u = py.indexOf("ù") > 0;
                    boolean v = py.indexOf("ǜ") > 0;
                    if(a){
                        System.out.println(a);
                        py = py.replaceAll("à","a");
                    }
                    if(o){
                        System.out.println(o);
                        py = py.replaceAll("ó","o");
                    }
                    if(e){
                        System.out.println(e);
                        py = py.replaceAll("è","e");
                    }
                    if(i){
                        System.out.println(i);
                        py = py.replaceAll("ì","i");
                    }
                    if(u){
                        System.out.println(u);
                        py = py.replaceAll("ù","u");
                    }
                    if(v){
                        System.out.println(o);
                        py = py.replaceAll("ǜ","ü");
                    }
                } else {
                    shengdiao = 0;
                }
                String yunmu = "";
                if("NULL".equals(shengmu)){
                    System.out.println("=====================获取声母出错===================");
                } else if("".equals(shengmu)){
                    yunmu = py;
                } else {
                    if(shengmu.length() == 2)
                        yunmu = py.substring(py.indexOf(shengmu) + 2);
                    else
                        yunmu = py.substring(py.indexOf(shengmu) + 1);
                }
                Hanzi hanzi = new Hanzi();
                hanzi.setBihuashu(bihua);
                hanzi.setHanzi(hanziW);
                hanzi.setShengmu(shengmu);
                hanzi.setYunmu(yunmu);
                hanzi.setShengdiao(shengdiao);
                hanziList.add(hanzi);
                sql = sql + "'"+ hanziW +"','" + shengmu + "','" + yunmu + "'," + shengdiao + "," + bihua + ",'" + ziyi + "'),\n(";
            }
        }
        //写SQL文件
        writeTxt(sql,"555","sql");
    }

    public static void writeTxt(String content, String type, String doc){
        try {
            File writeName = new File("C:\\Users\\YowYouth\\Desktop\\dpi_format_"+type+"g." + doc); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                out.write(content); // \r\n即为换行
                out.flush(); // 把缓存区内容压入文件
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("over");
    }

    public static String readtxt(String pathname){
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
                sb.append(line).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
