package com.hallth.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class ExcelUtil {
    private static Logger logger = Logger.getLogger(ExcelUtil.class.getName());

    //读取Excel文件数据
    public List<List<StringBuffer>> readExcelFile(String filePath){
        Workbook wb = getWorkbook(filePath);//判断Excel文件的版本
        int sheetCount = wb.getNumberOfSheets();//获取sheet数
        List<List<StringBuffer>> excelContent = new ArrayList<>();//存储整个Excel文档的数据内容
        for(int i = 0; i < sheetCount; i++){
            Sheet sheet = wb.getSheetAt(i);
            int rowCount = sheet.getPhysicalNumberOfRows();//获取物理行数（不包括空行）
            List<StringBuffer> sheetList = new ArrayList<>();//存储当前Sheet的数据内容
            for(int j = 0; j < rowCount; j++){
                Row row = sheet.getRow(j);
                int cellCount = row.getLastCellNum();//获取最后一个cell的索引，从0开始，包括空白单元格
                StringBuffer rowStringBuffer = new StringBuffer();//存储当前行的数据内容
                for(int k = 0; k < cellCount; k ++){
                    Cell cell = row.getCell(k);
                    String cellContent = "";//存储当前单元格的内容
                    if(cell != null){
                        int cellType = cell.getCellType();
                        switch (cellType){
                            case Cell.CELL_TYPE_NUMERIC:
                                cellContent = cell.getNumericCellValue() + "";
                                break;
                            case Cell.CELL_TYPE_STRING:
                                cellContent = cell.getStringCellValue();
                                break;
                            case Cell.CELL_TYPE_BOOLEAN:
                                cellContent = cell.getBooleanCellValue() + "";
                                break;
                            default:
                                cellContent = "无";
                        }
                    }
                    rowStringBuffer.append(cellContent).append("\t");
                }
                sheetList.add(rowStringBuffer);
            }
            excelContent.add(sheetList);
        }
        return excelContent;
    }

    //判断是xls还是xlsx
    private Workbook getWorkbook(String filePath){
        InputStream is = null;
        Workbook wb = null;
        try {
            is = new FileInputStream(filePath);
            if(filePath.endsWith("xls")){
                wb = new HSSFWorkbook(is);
            }else if(filePath.endsWith("xlsx")){
                wb = new XSSFWorkbook(is);
            }else{
                wb = null;
            }
        } catch (FileNotFoundException e) {
            logger.warning("文件未找到！");
            e.printStackTrace();
        } catch (IOException e) {
            logger.warning("IO异常");
            e.printStackTrace();
        }
        return wb;
    }
}
