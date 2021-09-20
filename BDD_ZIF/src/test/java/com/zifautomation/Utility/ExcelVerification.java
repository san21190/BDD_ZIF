package com.zifautomation.Utility;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

import static jxl.Workbook.getWorkbook;

public class ExcelVerification {

    public void convertcsv() throws IOException {

    ArrayList arList = null;
    ArrayList al = null;
    String fName = System.getProperty("user.dir") + "\\resources\\Datatables\\Downloads\\Cases  .csv";
    //String fName = fName1.replaceAll("-","").trim();
    String thisLine;
    int count = 0;
    FileInputStream fis = new FileInputStream(fName);
    DataInputStream myInput = new DataInputStream(fis);
    int i = 0;
    arList = new ArrayList();
		while ((thisLine = myInput.readLine()) != null) {
        al = new ArrayList();
        String strar[] = thisLine.split(",");
        for (int j = 0; j < strar.length; j++) {
            al.add(strar[j]);
        }
        arList.add(al);
        System.out.println();
        i++;
    }

    String Ranchar = null;
		try {
        HSSFWorkbook hwb = new HSSFWorkbook();
        HSSFSheet sheet = hwb.createSheet("new sheet");
        for (int k = 0; k < arList.size(); k++) {
            ArrayList ardata = (ArrayList) arList.get(k);
            HSSFRow row = sheet.createRow((short) 0 + k);
            for (int p = 0; p < ardata.size(); p++) {
                HSSFCell cell = row.createCell((short) p);
                String data = ardata.get(p).toString();
                if (data.startsWith("=")) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    data = data.replaceAll("\"", "");
                    data = data.replaceAll("=", "");
                    cell.setCellValue(data);
                } else if (data.startsWith("\"")) {
                    data = data.replaceAll("\"", "");
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    cell.setCellValue(data);
                } else {
                    data = data.replaceAll("\"", "");
                    cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                    cell.setCellValue(data);
                }
                //*/
                //   cell.setCellValue(ardata.get(p).toString());
            }
            System.out.println();
        }
        FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir") + "\\resources\\Datatables\\Downloads\\Cases  .xls");
        hwb.write(fileOut);
        fileOut.close();
        System.out.println("Your excel file has been generated");

    } catch (Exception ex) {
        ex.printStackTrace();
    } //main method ends
}

    public int Totalsize() throws Exception {
        ExcelVerification Ex = new ExcelVerification();
        String Casefilename = "Cases"+Ex.convert();
        System.out.println("Casefilename:"+Casefilename);
        String FilePath = System.getProperty("user.dir") + "\\Downloads\\"+Casefilename+"  .xls";
        FileInputStream fs = new FileInputStream(FilePath);
        Workbook wb = (Workbook) getWorkbook(fs);
        // TO get the access to the sheet
        Sheet sh = wb.getSheet("new sheet");
        // To get the number of rows present in sheet
        int totalNoOfRows = sh.getLastRowNum();
        System.out.println("totalNoOfRows:"+totalNoOfRows);
        return totalNoOfRows;
    }

    public static void csvToXLSX() {
        try {
            String csvFileAddress = (System.getProperty("user.dir") + "\\resources\\Datatables\\Downloads\\GTMDICV500.csv");
            String xlsxFileAddress = (System.getProperty("user.dir") + "\\resources\\Datatables\\Downloads\\GTMDICV500.xlsx");
            XSSFWorkbook workBook = new XSSFWorkbook();
            XSSFSheet sheet = workBook.createSheet("Worksheet");
            String currentLine=null;
            int RowNum=0;
            BufferedReader br = new BufferedReader(new FileReader(csvFileAddress));
            while ((currentLine = br.readLine()) != null) {
                String str[] = currentLine.split(",");
                RowNum++;
                XSSFRow currentRow=sheet.createRow(RowNum);
                for(int i=0;i<str.length;i++){
                    currentRow.createCell(i).setCellValue(str[i]);
                }
            }

            FileOutputStream fileOutputStream =  new FileOutputStream(xlsxFileAddress);
            workBook.write(fileOutputStream);
            fileOutputStream.close();
            System.out.println("Conversion is Done");
        } catch (Exception ex) {
            System.out.println(ex.getMessage()+"Exception in try");
        }
    }


    public int Columnandrowcount() throws Exception {
        // Making of excel file object
        File myFile = new File(System.getProperty("user.dir") + "\\resources\\Datatables\\Downloads\\GTMDICV500.xlsx");
        FileInputStream fis = new FileInputStream(myFile);
        XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
        XSSFSheet mySheet = myWorkBook.getSheet("Worksheet");
        XSSFRow row = null;

        // Making the object of excel row
        row = mySheet.getRow(0);

        int colCount = row.getLastCellNum();
        System.out.println("Column Count :- " + colCount);

        int rowCount = mySheet.getLastRowNum() + 1;
        System.out.println("Row Count :- " + rowCount);
    return Columnandrowcount();}







    public ArrayList<String> readExcel() throws Exception {
        ExcelVerification Ex = new ExcelVerification();
        String Casefilename = "Cases"+Ex.convert();
        System.out.println("Casefilename:"+Casefilename);
        String FilePath = System.getProperty("user.dir") + "\\resources\\Datatables\\Downloads\\"+Casefilename+"  .xls";
        FileInputStream fs = new FileInputStream(FilePath);
        jxl.Workbook wb = getWorkbook(fs);

        // TO get the access to the sheet
        jxl.Sheet sh = wb.getSheet("new sheet");
        // To get the number of rows present in sheet
        int totalNoOfRows = sh.getRows()-1;

        // To get the number of columns present in sheet
        int totalNoOfCols = sh.getColumns();

        ArrayList<String> exl = new ArrayList<String>();

        for (int row = 1; row <= totalNoOfRows; row++) {

//            for (int col = 0; col < totalNoOfCols; col++) {
//                System.out.print(sh.getCell(col, row).getContents() + "\t");
//            }
            for (int col = 0; col < 1; col++) {
                // System.out.print(sh.getCell(col, row).getContents() + "\t");
                String cases = sh.getCell(col, row).getContents();
                exl.add(cases);
                System.out.println(exl);

            }
        }

        return exl;
    }



    public String convert() throws Exception {

        ArrayList arList = null;
        ArrayList al = null;
        String fName = System.getProperty("user.dir") + "\\resources\\Datatables\\Downloads\\Cases  .csv";
        //String fName = fName1.replaceAll("-","").trim();
        String thisLine;
        int count = 0;
        FileInputStream fis = new FileInputStream(fName);
        DataInputStream myInput = new DataInputStream(fis);
        int i = 0;
        arList = new ArrayList();
        while ((thisLine = myInput.readLine()) != null) {
            al = new ArrayList();
            String strar[] = thisLine.split(",");
            for (int j = 0; j < strar.length; j++) {
                al.add(strar[j]);
            }
            arList.add(al);
            System.out.println();
            i++;
        }

        String Ranchar = null;
        try {
            HSSFWorkbook hwb = new HSSFWorkbook();
            HSSFSheet sheet = hwb.createSheet("new sheet");
            for (int k = 0; k < arList.size(); k++) {
                ArrayList ardata = (ArrayList) arList.get(k);
                HSSFRow row = sheet.createRow((short) 0 + k);
                for (int p = 0; p < ardata.size(); p++) {
                    HSSFCell cell = row.createCell((short) p);
                    String data = ardata.get(p).toString();
                    if (data.startsWith("=")) {
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        data = data.replaceAll("\"", "");
                        data = data.replaceAll("=", "");
                        cell.setCellValue(data);
                    } else if (data.startsWith("\"")) {
                        data = data.replaceAll("\"", "");
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cell.setCellValue(data);
                    } else {
                        data = data.replaceAll("\"", "");
                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                        cell.setCellValue(data);
                    }
                    //*/
                    //   cell.setCellValue(ardata.get(p).toString());
                }
                System.out.println();
            }

            Ranchar = generateRandomChar();
            System.out.println("Ranchar:" + Ranchar);
            FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir") + "\\resources\\Datatables\\Downloads\\Cases"+Ranchar+"  .xls");
            hwb.write(fileOut);
            fileOut.close();
            System.out.println("Your excel file has been generated");

        } catch (Exception ex) {
            ex.printStackTrace();
        } //main method ends
        return Ranchar;
    }


    public String  generateRandomChar() {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        String sKey = "";
        int length=7;
        Random random = new Random();
        char[] text =new char[length];

        for(int i=0;i<length;i++)
        {
            text[i]=chars.charAt(random.nextInt(chars.length()));
        }
        for(int i=0;i< text.length;i++) {
            sKey += text[i];
        }
        return sKey;

    }




}
