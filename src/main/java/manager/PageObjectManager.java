package manager;

import org.openqa.selenium.WebDriver;

import pageObjects.CartSummaryPage;
import pageObjects.HomePage;
import pageObjects.WomenProductPage;

public class PageObjectManager {

	WebDriver driver;
	CartSummaryPage cartPage;
	WomenProductPage productPage;
	HomePage homePage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public CartSummaryPage getCartSummaryPage(){
		 
		 return (cartPage == null) ? cartPage = new CartSummaryPage(driver) : cartPage;
		 
		 }
	
	public WomenProductPage getWomenProductPage(){
		 
		 return (productPage == null) ? productPage = new WomenProductPage(driver) : productPage;
		 
		 }
	public HomePage getHomePage(){
		 
		 return (homePage == null) ? homePage = new HomePage(driver) : homePage;
		 
		 }
	
}
