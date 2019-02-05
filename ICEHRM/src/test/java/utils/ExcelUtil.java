package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {
	public static XSSFWorkbook workBook;
	public static XSSFSheet workSheet;
	/*--Method to set excel file location and open the file for operations --*/
	public static void openExcel(String Path, String SheetName){
		try {
		FileInputStream ExcelFile = new FileInputStream(Path);
		workBook = new XSSFWorkbook(ExcelFile);
		workSheet = workBook.getSheet(SheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*--Method to get no of rows on a excel sheet --*/
	public static int getRowNos(){
		return workSheet.getPhysicalNumberOfRows();
		}
	/*--Method to get no of columns on a excel sheet --*/
	public static int getColNos(){
		return workSheet.getRow(0).getLastCellNum();
		}
	/*--Method to all cell value on a excel sheet --*/
	public static Object getCellValue(){
		String cellValue = null;
		Cell cell = null;
		
		int NoOfRows = workSheet.getPhysicalNumberOfRows();
		int NoOfCols = workSheet.getRow(0).getLastCellNum();
		Object[][] testdata = new Object[NoOfRows-1][NoOfCols];
		for (int i = 1; i < NoOfRows;i++ ) {
			for (int j = 0; j< NoOfCols;j++ ) {
				DataFormatter formatter = new DataFormatter();
				cell = workSheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK );
				cellValue = formatter.formatCellValue(cell); 
				testdata[i-1][j] = cellValue;											
			}
		}
		return testdata;		
		}
	/*--Method to set a cell value on a excel sheet --*/
	public static void SetCellValue(String Path, String SheetName, String result, int RowID, int ColID){
		FileInputStream ExcelFile;
		Cell cell = null;
		try {
			ExcelFile = new FileInputStream(Path);
			workBook = new XSSFWorkbook(ExcelFile);
			workSheet = workBook.getSheet(SheetName);
			cell = workSheet.getRow(RowID).getCell(ColID, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK );
			cell.setCellValue(result);	
			FileOutputStream fOut = new FileOutputStream(Path);
			workBook.write(fOut);					
			ExcelFile.close();
			fOut.flush();
			fOut.close();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	/*--Method to get cell value on a excel sheet --*/
	public static String getACellValue(String Path, String SheetName, int RowID, int ColID){
		FileInputStream ExcelFile;
		String cellValue = null;
		try {
			ExcelFile = new FileInputStream(Path);
			workBook = new XSSFWorkbook(ExcelFile);
			workSheet = workBook.getSheet(SheetName);			
			Cell cell = null;
			DataFormatter formatter = new DataFormatter();
			cell = workSheet.getRow(RowID).getCell(ColID, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK );
			cellValue = formatter.formatCellValue(cell); 
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     catch (IOException f) {
		// TODO Auto-generated catch block
	    	f.printStackTrace();
	    }
		return cellValue;
	
		}
	
	/*--Method to get cell value from a table on a excel sheet --*/
	public static Object[][] getDataTableCellValues(String Path, String SheetName, String TableName){
		FileInputStream ExcelFile;
		String cellValue = null;
		int startTableRowID =0 ;
		@SuppressWarnings("unused")
		int startTableColID = 0;
		int endTableRowID = 0 ;
		int endTableColID = 0;
		Object[][] testdata = null;
		int prevMaxNoOfRows = 0;
		int NoOfCols = 0;
		
		try {
			ExcelFile = new FileInputStream(Path);
			workBook = new XSSFWorkbook(ExcelFile);
			workSheet = workBook.getSheet(SheetName);			
			Cell cell = null;
			int NoOfRows = workSheet.getLastRowNum();
			for  (int i = 1; i < NoOfRows+1;i++ ) {
				Row r = workSheet.getRow(i);
				if (r == null ) {
					continue;
				}
				
				if ( workSheet.getRow(i).getLastCellNum()  >= prevMaxNoOfRows ) {
					prevMaxNoOfRows = workSheet.getRow(i).getLastCellNum();
					//System.out.println("No of colums" + prevMaxNoOfRows);
					NoOfCols = prevMaxNoOfRows ;					
				}
			}
			
			//System.out.println("No of colums" + NoOfCols);
			
			
			
			//System.out.println("NoOfCols:"+NoOfCols);
			//System.out.println("rows: "+NoOfRows+" Cols:"+NoOfCols);
			for (int i = 1; i < NoOfRows+1;i++ ) {
				for (int j = 0; j< NoOfCols;j++ ) {
					Row r = workSheet.getRow(i);
					if (r == null ) {
						continue;
					}
					cell = workSheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK );
					DataFormatter formatter = new DataFormatter();
					//cellValue = cell.getRichStringCellValue().getString().trim();
					cellValue = formatter.formatCellValue(cell); 
					//System.out.println(cellValue);
					if (cellValue.contentEquals(TableName)) {
						startTableRowID = i;
						startTableColID = j;
					//System.out.println("startTableRowID:"+startTableRowID + " startTableColID: "+startTableColID);
					}
					else if (cellValue.contentEquals(TableName+"End")) {
						endTableRowID = i;
						endTableColID = j;
					//	System.out.println("endTableRowID:"+endTableRowID + " endTableColID: "+endTableColID);
					}		
											
				}
			}
			
			testdata = new Object[endTableRowID-(startTableRowID+1)][endTableColID-1];
			for (int i = startTableRowID+1 ; i < (startTableRowID)+(endTableRowID-startTableRowID)  ;i++ ) {
				for (int j = 1; j< endTableColID;j++ ) {
					DataFormatter formatter = new DataFormatter();
					cell = workSheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK );
					cellValue = formatter.formatCellValue(cell); 
					testdata[(i-startTableRowID)-1][j-1] = cellValue;				
					//System.out.println(cellValue);
				}
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     catch (IOException f) {
		// TODO Auto-generated catch block
	    	f.printStackTrace();
	    }
		return testdata;
	
		}
}

