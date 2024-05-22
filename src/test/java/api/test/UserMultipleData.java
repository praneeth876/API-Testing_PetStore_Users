package api.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.payLoad.User;
import api.utilities.XcelUtility;

public class UserMultipleData {
	User user;

	FileInputStream file;
	Workbook workbook;
	Sheet sheet;
	Row row;
	Cell cell;
	String filePath;
	//XcelUtility xU;


	@Test(dataProvider = "fullData",dataProviderClass =ExcelDataProvider.class)
	public void multipleTestdata(String id,String firstName,String lastName,String email,String username,String Password,String statusCode) {
		
		user=new User();
		
		user.setId(Integer.parseInt(id));
		//user.setPhone();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(Password);
		user.setUserStatus(200);
		
		System.out.println(this.user.getId());
		System.out.println(this.user.getFirstName());
	}
	
//    @DataProvider(name="fullData")
//	public  String[][] excelData() throws IOException {
//		XcelUtility	xU=new XcelUtility("./src/test/resources/APITestData.xlsx");		
//		
//		int rowCount=xU.getRowCount("Sheet1");
//		int cellCount=xU.getCellCount("Sheet1",1);
//		String[][] allData=new String[rowCount][cellCount];
//		for(int i=1;i<rowCount;i++) {		
//			
//			for(int j=0;j<cellCount;j++) {
//				allData[i-1][j] =xU.getCellData(filePath, i, j);
//				System.out.println(allData[i-1][j]);
//			}		
//	}
//		return allData;
//		
//	}

}
