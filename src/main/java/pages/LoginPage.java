package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page_base {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By loginEmail= By.name("email");
	private By loginPassword= By.name("password");
	private By loginbtn= By.xpath("//*[@id=\"fadein\"]/div[4]/div/div[2]/div[2]/div/form/div[3]/button");

	public void insertMail(String mail) {
		waitForRegistration(driver,20,loginEmail);
		driver.findElement(loginEmail).clear();
		driver.findElement(loginEmail).sendKeys(mail);
		
	}
	
	public void insertpassword(String pass) {
		
		waitForRegistration(driver,20,loginPassword);
		driver.findElement(loginPassword).clear();
		driver.findElement(loginPassword).sendKeys(pass);
	}
	
	public void loginButton() {
		waitForRegistration(driver,40,loginbtn);
		driver.findElement(loginbtn).click();
	}
	
	
}
