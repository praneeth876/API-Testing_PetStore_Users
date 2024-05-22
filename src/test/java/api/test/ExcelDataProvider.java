package api.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

	public FileInputStream file;
	public Workbook workbook;
	public Sheet sheet;
	public Row row;
	public Cell cell;
	//public String filePath;

	//fetching all the data
	@DataProvider(name="fullData")
	public String[][] excelDataProv() throws IOException{
		file = new FileInputStream("./src/test/resources/APITestData.xlsx");
		workbook = new XSSFWorkbook(file);
		 sheet=workbook.getSheet("Sheet1");

		 String[][] obj=new String[sheet.getLastRowNum()][sheet.getRow(1).getLastCellNum()];
			for(int i=1;i<=sheet.getLastRowNum();i++) {		
				row=sheet.getRow(i);
				for(int j=0;j<row.getLastCellNum();j++) {
					
					cell=row.getCell(j);
							
					DataFormatter dataFormate=new DataFormatter();
					obj[i-1][j] =dataFormate.formatCellValue(cell);
					
					if(obj[i-1][j] == null) {
						break;
					}
				//	System.out.print(obj[i-1][j]+" ");
				}	
				System.out.println();
		 
			}
		workbook.close();
		file.close();
		return obj;
		
			
	}
	//========================================================================================================
	
	//fetching all the usernames
	@DataProvider(name="userNames")
	public String[] usernameData() throws IOException{
		file = new FileInputStream("./src/test/resources/APITestData.xlsx");
		workbook = new XSSFWorkbook(file);
		 sheet=workbook.getSheet("Sheet1");

		 String[] obj=new String[sheet.getLastRowNum()];
			for(int i=1;i<=sheet.getLastRowNum();i++) {		
				row=sheet.getRow(i);
					cell=row.getCell(4);
							
					DataFormatter dataFormate=new DataFormatter();
					obj[i-1] =dataFormate.formatCellValue(cell);
					//System.out.println(obj[i-1]);
				}	
				System.out.println();
		 
			
		workbook.close();
		file.close();
		return obj;
	}
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	


