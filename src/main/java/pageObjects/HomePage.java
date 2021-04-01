package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import manager.FileReaderManager;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToHomePage() {
		driver.navigate().to(FileReaderManager.getInstance().getPropertyReader().getApplicationUrl());
	}
	
	public void navigateToWomenProducts() {
		driver.navigate().to(FileReaderManager.getInstance().getPropertyReader().getProductUrl());
	}
	
}
