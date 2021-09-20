package com.zifautomation.TestCases;

import com.zifautomation.RestAssured.BaseAPI;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelVerification;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Csvreader {

    String filepath = (System.getProperty("user.dir") + "\\resources\\Datatables\\Downloads\\GTMDICV500.csv");

    public static void main(String[] args) throws Exception {
//
//        // Making of excel file object
//        File myFile = new File(System.getProperty("user.dir") + "\\resources\\Datatables\\Downloads\\GTMDICV500.xlsx");
//        FileInputStream fis = new FileInputStream(myFile);
//        XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
//        XSSFSheet mySheet = myWorkBook.getSheet("new sheet");
//        XSSFRow row = null;
//
//        // Making the object of excel row
//        row = mySheet.getRow(0);
//
//        int colCount = row.getLastCellNum();
//        System.out.println("Column Count :- " + colCount);
//
//        int rowCount = mySheet.getLastRowNum() + 1;
//        System.out.println("Row Count :- " + rowCount);
//        ExcelVerification ExlUtil = new ExcelVerification();
//        ArrayList<String> excel = ExlUtil.readExcel();
//        int count = 0;
//        for (int i = 0; i < excel.size(); i++) {
//            String text = excel.get(i).toString();
//            if (text.contains("GTM")) {
//                count = count + 1;
//
//            }
//            System.out.println("Total count of devices from the excel exported: "+count);
//
//        }

//        BaseAPI testi = new BaseAPI();
//        testi.preCondition();


    }
}

