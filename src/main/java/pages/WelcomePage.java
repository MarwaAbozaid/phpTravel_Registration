package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends Page_base {

	public WelcomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By logout_link= By.linkText("Logout");
	private By welcome_message=By.partialLinkText("Welcome Back");
	public void logout() {
		driver.findElement(logout_link).click();
		
	}
	
	public void msg() {
		driver.findElement(welcome_message).getText();
		
	}

}
