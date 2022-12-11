package com.applaudGS.automation.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;



public class DataReader {
 public static Map<String, String> data;
 
 public static Map readData() throws  IOException, BiffException   
 {
// boolean b=true;
	 
	/* Properties properties = new Properties();
		try{
			 FileInputStream fileInput = new FileInputStream("F:\\SeleniumWorkSpace\\FrameWork\\src\\Config.properties");
		properties.load(fileInput);
		
		}catch(Exception e){
			e.printStackTrace();
		}
 */
 // create map to store web elements
 data = new HashMap<String, String>();
 

 Workbook workbook = Workbook.getWorkbook(new java.io.File(System.getProperty("user.dir")+"\\Data\\Test Data\\RTestData.xls"));
 
// Sheet sheet = workbook.getSheet(GlobalFunctions.launchProperties("SheetName"));
 Sheet sheet = workbook.getSheet("Sheet1");// Sheet index , Sheet1 = 0, Sheet2 =1 etc

  int rowcount = sheet.getRows();
 // int rowcount = 2;
 for(int i=0;i<rowcount;i++)
 {
 

 Cell ObjectName = sheet.getCell(0,i); 
 Cell ObjectValue = sheet.getCell(1,i);
 
 String Key=ObjectName.getContents();
 String value=ObjectValue.getContents();
 
 
 int keylength=Key.length();
 int valuelength=value.length();
 
// String KeyS=Integer.toString(Key); 
// Integer.toString(int)

 if(keylength>0 && valuelength>0)
 {
 data.put(ObjectName.getContents(),ObjectValue.getContents());


 } else{
	// System.out.println("I Am Else Block");

 }
 }
 

return data;
 
 }
 
 

}

