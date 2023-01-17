package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.WelcomePage;

public class Login_TC extends Test_base {


	LoginPage lp;
	WelcomePage wp;
	

	@Test (dataProvider="test_data")
	public void register_TC(String email, String password) {
		lp =new LoginPage(driver);
		lp.loginButton();
		lp.insertMail(email);
		lp.insertpassword(password);
		lp.loginButton();
		Assert.assertEquals(true, false);
		System.out.println("assert pass");
		
	}
	      
	
	@DataProvider(name="test_data")
	public Object test_data() throws  IOException{
		String filePath = System.getProperty("user.dir")+"/src/main/java/data/UserData.xlsx";
		 FileInputStream fis= new FileInputStream(filePath); 
		  XSSFWorkbook wb=new XSSFWorkbook(fis);
		  XSSFSheet sheet= wb.getSheetAt(1);
		  int rowCount = sheet.getPhysicalNumberOfRows();
		  ArrayList<Object[]> myData = new ArrayList<Object[]>();
		 
			  for(int i=1;i<rowCount;i++)
			  {
				 
				  DataFormatter formatter = new DataFormatter();
				
				  String email=  formatter.formatCellValue(sheet.getRow(i).getCell(0));
				  String pass=  formatter.formatCellValue(sheet.getRow(i).getCell(1));
				
				  
				  Object ob[]= {email,pass};
				  myData.add(ob);
				 
			  }
			  wb.close();
			  return myData.iterator();

	
}

}
