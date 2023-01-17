package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page_base {
	
	protected WebDriver driver;
	 
	 public Page_base(WebDriver driver) {
		 this.driver=driver;
		// TODO Auto-generated constructor stub
	}

	public void scroll_down(WebDriver driver) {
			JavascriptExecutor java =(JavascriptExecutor)driver;
			java.executeScript("scroll(0,250)");
	 }
	 
	 public void waitForRegistration(WebDriver driver , int time, By element) {
			WebDriverWait wait =new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	 }


}
