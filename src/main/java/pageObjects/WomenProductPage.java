package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import selenium.Wait;

public class WomenProductPage {
	
	WebDriver driver;
	
	 public WomenProductPage(WebDriver driver) {
		 this.driver=driver;
	     PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(how = How.CSS, using = "a[title='Tops']")
	 private WebElement filter_Tops;
	 
	 @FindAll(@FindBy(how = How.CSS, using = "div.product-container"))
	 private List<WebElement> products_List; 
	 
	 @FindBy(how = How.CSS, using = "a[title='Add to cart']")
	 private WebElement AddToCart;
	 
	 @FindBy(how = How.CSS, using="a[title='Proceed to checkout'")
	 private WebElement proceedToCheckout;
	 
	 
	 public WebElement select_Product(int index) {
		 return products_List.get(index);
	 }
	 
	 public void addToCart_Product() {
		 AddToCart.click();
		 Wait.untilPageLoadComplete(driver);
	 }
	 
	 public void navigateToCheckout() {
		 proceedToCheckout.click();
	 }
	 
	 public String getProductName(int index) {
		return products_List.get(index).findElement(By.className("product-name")).getText();
	 }
	 
}
