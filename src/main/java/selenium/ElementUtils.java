package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementUtils {
	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By selector) {
		WebElement element = null;
		Wait.untilElementPresent(driver, selector);
		element = driver.findElement(selector);

		return element;
	}

	public void sendKeysElement(By selector, String value) {
		try {
			getElement(selector).sendKeys(value);
		} catch (Exception e) {
			System.out.println("some issue with sendKeys");
		}
	}

	public void clickOnElement(By selector) {
		getElement(selector).click();
	}

	public String getTextElement(By selector) {
		return getElement(selector).getText();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void moveToElementPause(WebElement element, Long pauseDuration) {
		Actions action = new Actions(driver);
		action.moveToElement(element).pause(pauseDuration).perform();
	}
	public void moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

}
