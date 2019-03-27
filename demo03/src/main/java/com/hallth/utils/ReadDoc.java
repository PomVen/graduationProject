package com.hallth.utils;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadDoc {
    public static void main(String[] args) {
        String fileNamePath = "D:\\qq文件\\917879609\\FileRecv\\灯谜";
        ParseWordUtil parseWordUtil = new ParseWordUtil();
        File file = new File(fileNamePath);
        List<File> allfilelist = new ArrayList<File>();
        allfilelist = getallfile(file,allfilelist);
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < allfilelist.size(); i++){
            File f = allfilelist.get(i);
            String fileName = f.getAbsolutePath();
            System.out.println((i+1) + "===" + fileName);
            String fileCont = parseWordUtil.getWordTitles2007(fileName);
            sb.append(fileCont).append("\n");
        }
        writeTxt(sb.toString(),"4","txt");
        System.out.println("over");
//        testReadByDoc(fileNamePath);
//        System.out.println("over");
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

    public static List<File> getallfile(File file, List<File> allfilelist) {
        if (file.exists()) {
            //判断文件是否是文件夹，如果是，开始递归
            if (file.isDirectory()) {
                File f[] = file.listFiles();
                for (File file2 : f) {
                    getallfile(file2, allfilelist);
                }
            } else {
                String filename = file.getName();
                if(filename.endsWith("docx")){
                    allfilelist.add(file);
                }
            }
        }
        return allfilelist;
    }
    private static String contextOfDoc(File file){
        String str = "";
        try {
            FileInputStream fis = new FileInputStream(file);
            HWPFDocument doc = new HWPFDocument(fis);
            str = doc.getDocumentText();
            doc.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }


    /**
     * 通过XWPFDocument对内容进行访问。对于XWPF文档而言，用这种方式进行读操作更佳。
     * @throws Exception
     */
    public static void testReadByDoc(String filePath) {
        try{
            InputStream is = new FileInputStream(filePath);
            XWPFDocument doc = new XWPFDocument(is);
            List<XWPFParagraph> paras = doc.getParagraphs();
            for (XWPFParagraph para : paras) {
                //当前段落的属性
//       CTPPr pr = para.getCTP().getPPr();
                System.out.println(para.getText());
            }
            //获取文档中所有的表格
            List<XWPFTable> tables = doc.getTables();
            List<XWPFTableRow> rows;
            List<XWPFTableCell> cells;
            for (XWPFTable table : tables) {
                //表格属性
//       CTTblPr pr = table.getCTTbl().getTblPr();
                //获取表格对应的行
                rows = table.getRows();
                for (XWPFTableRow row : rows) {
                    //获取行对应的单元格
                    cells = row.getTableCells();
                    for (XWPFTableCell cell : cells) {
                        System.out.println(cell.getText());;
                    }
                }
            }
            close(is);
        }catch (Exception e){

        }

    }

    /**
     * 关闭输入流
     * @param is
     */
    private static void close(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
