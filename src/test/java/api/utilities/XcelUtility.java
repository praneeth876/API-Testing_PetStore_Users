package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XcelUtility {

	FileInputStream file;
	Workbook workbook;
	Sheet sheet;
	Row row;
	Cell cell;
	String filePath;

	public XcelUtility(String filePath) {
		this.filePath = filePath;
	}
	
	public int getRowCount(String sheet) throws IOException {
		file = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(file);
		int rowCount = workbook.getSheet(sheet).getLastRowNum();
		workbook.close();
		file.close();
		return rowCount;
	}

	public int getCellCount(String sheet, int row) throws IOException {
		file = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(file);
		int cellCount = workbook.getSheet(sheet).getRow(row).getLastCellNum();
		workbook.close();
		file.close();
		return cellCount;
	}

	public String getCellData(String sheet, int row, int cell) throws IOException {
		file = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(file);
		Cell cells = workbook.getSheet(sheet).getRow(row).getCell(cell);
        
		DataFormatter format = new DataFormatter();
		String daat=format.formatCellValue(cells);
		
		workbook.close();
		file.close();
		
		return daat;
	}
	
}
