package com.hallth.utils;

import com.hallth.domain.ZidianWithBLOBs;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class PDFUtil {
    public static void main(String[] args) {
        try (PDDocument document = PDDocument.load(new File("D:\\qq文件\\917879609\\FileRecv\\MobileFile\\汉字源流字典.pdf"))) {
            document.getClass();
            if(!document.isEncrypted()) {
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);
                PDFTextStripper tStripper = new PDFTextStripper();
                String pdfFileInText = tStripper.getText(document);
                String[] lines = pdfFileInText.split("\\r?\\n");
                for(String line : lines) {
                    System.out.println(line);
                }
            }
        } catch (InvalidPasswordException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
