package com.LOIS.qa.testdata;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readexceldata {
                
                public  FileInputStream fis; //new FileInputStream("");
                public  XSSFWorkbook workbook;// = new XSSFWorkbook(fis);
                public  XSSFSheet sheet;// workbook.getSheet("Credentials");
                public  XSSFRow row;   //= sheet.getRow(0);
    
    public readexceldata(String filepath) throws IOException
    {
                fis=new FileInputStream(filepath);
                workbook=new XSSFWorkbook(fis);
                fis.close();
    }
    
    
    public  int getrowbypurpose(String sheetname, String purpose) throws IOException
    {
                
                int reqrow=-1;
    
                sheet=workbook.getSheet(sheetname);
                
                
                int totalrows=sheet.getLastRowNum();
                
                for (int rowcounter=0;rowcounter<=totalrows;rowcounter++)
                {
                                if (sheet.getRow(rowcounter)!=null)
                                {
                                                
                                                if(sheet.getRow(rowcounter).getCell(0)!=null)
                                                                {
                                                                String reason= sheet.getRow(rowcounter).getCell(0).getStringCellValue();
                                                                 
                                                                 if (reason.equals(purpose))
                                                                 {
                                                                                 reqrow=rowcounter;
                                                                                
                                                                                 break;
                                                                 }
                                                }
                                }
                }
                                                
                return reqrow;
    }
                
    
    public String getcelldata(String sheetname, int reqrow, String reqcolumnname) throws IOException
    {
       
        sheet= workbook.getSheet(sheetname);
       
        row=sheet.getRow(0);
        int reqcolumn=-1;
        int totalcolumns=row.getLastCellNum();
        String colnamevalue=null;
        for (int colcounter=0;colcounter<=totalcolumns;colcounter++)
        {
                
               
                                colnamevalue= String.valueOf(row.getCell(colcounter).getStringCellValue());
                                
                                
        
                                if (colnamevalue.equals(reqcolumnname))
                                {
                                                
                                                reqcolumn=colcounter;
                                                break;
                                }
                }
                
        
                
          row=sheet.getRow(reqrow);
                  return row.getCell(reqcolumn).getStringCellValue();
                
    }

}
