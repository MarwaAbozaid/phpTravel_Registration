package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends Page_base{

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By first_name= By.name("first_name");
	private By last_name= By.name("last_name");
	private By phone= By.name("phone");
	private By email= By.name("email");
	private By password= By.name("password");
	private By accountType=By.id("account_type");
	private By robot= By.xpath("//*[@id=\"g-recaptcha-response\"]");
	private By signupbtn= By.id("button");
	
	public void insertFName(String fname) {
		waitForRegistration(driver,20,first_name);
		driver.findElement(first_name).clear();
		driver.findElement(first_name).sendKeys(fname);
		
	}
	
	
	public void insertLName(String lname) {
		
		waitForRegistration(driver,20,last_name);
		driver.findElement(last_name).clear();
		driver.findElement(last_name).sendKeys(lname);
		
	}
	
	public void insertPhone(String phonenum) {
		waitForRegistration(driver,20,phone);
		driver.findElement(phone).clear();
		driver.findElement(phone).sendKeys(phonenum);
		
	}	
	public void insertMail(String mail) {
		waitForRegistration(driver,20,email);
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(mail);
		
	}
	
	public void insertpassword(String pass) {
		waitForRegistration(driver,20,password);
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pass);
		
	}
	
	public void selectType(String type) {
	
		waitForRegistration(driver,20,accountType);
		Select accType = new Select(driver.findElement(accountType));
		accType.selectByVisibleText(type);
		
	}
	
	
	public void robotButton() {
		waitForRegistration(driver,30,robot);
		driver.findElement(robot).click();
		
	}
	
	public void signupButton() {
		waitForRegistration(driver,20,signupbtn);
		driver.findElement(signupbtn).click();
		
	}

}