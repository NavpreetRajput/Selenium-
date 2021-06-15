package TestUtils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utils {

	private static XSSFWorkbook workbook=null;
	private static XSSFSheet sheet=null;
	
	
	public utils(String excelPath, String sheetName) {
		try {
			 workbook= new XSSFWorkbook(excelPath);
			 sheet = workbook.getSheet(sheetName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 public static int getRowCount() {
	 int rowCount=0;
	  rowCount=sheet.getPhysicalNumberOfRows();
		System.out.println("Rows are "+rowCount);
		return rowCount;

 }
 public static int getColCount() {
	 int colCount=0;
	 colCount=sheet.getRow(0).getPhysicalNumberOfCells();
	 System.out.println("Columns are: "+colCount);
	 return colCount;
 }
 
 public static String getCellData(int rowNum, int colNum) {
	 String cellDataString=null;
	   cellDataString=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	 System.out.println();
	 return cellDataString;

 }
 

 
 public static void main(String[] args) {
	 
	
}
}
