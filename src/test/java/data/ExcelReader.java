package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
  static FileInputStream excelFile = null;
  public FileInputStream getExcelFile()
  {
	  String filePath = System.getProperty("user.dir")+"/src/test/java/data/UserData.xlsx";
	  File srcFile = new File(filePath);
	  try {
		excelFile = new FileInputStream(srcFile);
	} catch (FileNotFoundException e) {
		System.out.println("Error:"+ e.getMessage());
		System.exit(0);
	}
	  return excelFile;
  }
  
  public Object [] [] getExcelData() throws IOException
  {
	  excelFile =getExcelFile();
	  XSSFWorkbook wb = new XSSFWorkbook(excelFile);
	  XSSFSheet sheet = wb.getSheetAt(0);
	  int TotalNumberOfRows = (sheet.getLastRowNum()+1);
	  int TotalNumberOfCols = 4;
	  String [] [] arryExcelData = new String [TotalNumberOfRows] [TotalNumberOfCols];
	  for (int i = 0; i < TotalNumberOfRows; i++) {
		  for (int j = 0; j < TotalNumberOfCols; j++) {
			XSSFRow row = sheet.getRow(i);
			arryExcelData [i] [j] = row.getCell(j).toString();
		}
	}
	  wb.close();
	  return arryExcelData;
  }
}


