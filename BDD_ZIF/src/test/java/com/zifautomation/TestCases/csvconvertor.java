package com.zifautomation.TestCases;

import com.zifautomation.Utility.ExcelVerification;
import jxl.Workbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;


public class csvconvertor {

        public static int counter(List<String> comments) throws Exception {
                ExcelVerification ExlUtil = new ExcelVerification();
                ArrayList<String> excel = ExlUtil.readExcel();
                int count = 0;
                String word = "GTM6";
                for (String comment : excel) {
                        String a[] = comment.split(" ");
                        for (int j = 0; j < a.length; j++) {
                                if (word.equals(a[j])) {
                                        count++;
                                }
                        }
                        System.out.println(comment);
                }
                System.out.println("sefsfsfseesfeseeeeeeeeeeeeeeeeeeeeeee");
                return count;
        }
}

