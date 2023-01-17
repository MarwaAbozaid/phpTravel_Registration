package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.RegisterPage;

public class Register_TC extends Test_base{
	
	LoginPage lp;
	RegisterPage rp;
	
	@Test (dataProvider="test_data")
	public void register_TC(String first_name,String last_name, String phone, String email, String password, String account_type) 
	{
		rp =new RegisterPage(driver);
		rp.insertFName(first_name);
		rp.insertLName(last_name);
		rp.insertPhone(phone);
		rp.insertMail(email);
		rp.insertpassword(password);
		rp.selectType(account_type);
		rp.robotButton();
		rp.signupButton();
		String title= "Please enter your account credentials below";
		Assert.assertEquals(title, false);
		System.out.println("assert pass");
		
	}
	

	@DataProvider(name="test_data")
	public Object test_data() throws  IOException{
		String filePath = System.getProperty("user.dir")+"/src/main/java/utils/UserData.xlsx";
		 FileInputStream fis= new FileInputStream(filePath);//Automation data sheet0 LoginData 
		  XSSFWorkbook wb=new XSSFWorkbook(fis);
		  XSSFSheet sheet= wb.getSheetAt(0);
		  int rowCount = sheet.getPhysicalNumberOfRows();
		  ArrayList<Object[]> myData = new ArrayList<Object[]>();
		 
			  for(int i=1;i<rowCount;i++)
			  {
			
				  DataFormatter formatter = new DataFormatter();
				  String fname=  formatter.formatCellValue(sheet.getRow(i).getCell(0));
				  String lname=  formatter.formatCellValue(sheet.getRow(i).getCell(1));
				  String phone=  formatter.formatCellValue(sheet.getRow(i).getCell(2));
				  String email=  formatter.formatCellValue(sheet.getRow(i).getCell(3));
				  String pass=  formatter.formatCellValue(sheet.getRow(i).getCell(4));
				  String account=  formatter.formatCellValue(sheet.getRow(i).getCell(5));
				  
				  Object ob[]= {fname,lname,phone,email,pass,account};
				  
				  myData.add(ob);
				 
			  }
			  wb.close();
			  return myData.iterator();

	
}
}
