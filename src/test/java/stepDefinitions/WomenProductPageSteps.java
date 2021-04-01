package stepDefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.When;
import pageObjects.CartSummaryPage;
import pageObjects.WomenProductPage;
import selenium.Wait;

public class WomenProductPageSteps {
	TestContext context;
	WomenProductPage product;
	WebDriver driver;
	CartSummaryPage cart;

	
	public WomenProductPageSteps(TestContext testcontext) {
		context=testcontext;
		product=context.getPageObjectManager().getWomenProductPage();
		//driver=testcontext.getWebDriverManager().getDriver();
		driver=context.getWebDriverManager().getDriver();
		cart=testcontext.getPageObjectManager().getCartSummaryPage();
		
	}
	
	@When("adds to cart the first available product on page")
	public void adds_to_cart_the_first_available_product_on_page() {
		// List<WebElement> products =
		// driver.findElements(By.cssSelector("ul.product_list.grid.row>li"));
		String productName = product.getProductName(0);
		context.getScenarioContext().setScenarioContext(Context.PRODUCT_NAME, productName);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		action.moveToElement(product.select_Product(0)).pause(1000).perform();
		// driver.findElement(By.cssSelector("a[title='Add to cart']")).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		product.addToCart_Product();
		
	}

	@When("moves to the checkout page")
	public void moves_to_the_checkout_page() {
		// driver.findElement(By.cssSelector("a[title='Proceed to checkout']")).click();
		// driver.findElement(By.cssSelector("p.cart_navigation.clearfix
		// a:nth-of-type(1)")).click();
		product.navigateToCheckout();
		cart.proceedToCheckout_Signin();
		Wait.untilPageLoadComplete(driver);
	}
	
}
