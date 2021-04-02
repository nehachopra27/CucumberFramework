package stepDefinitions;

import org.openqa.selenium.WebDriver;
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
		context = testcontext;
		product = context.getPageObjectManager().getWomenProductPage();
		driver = context.getWebDriverManager().getDriver();
		cart = testcontext.getPageObjectManager().getCartSummaryPage();

	}

	@When("adds to cart the first available product on page")
	public void adds_to_cart_the_first_available_product_on_page() {
		String productName = product.getProductName(0);
		context.getScenarioContext().setScenarioContext(Context.PRODUCT_NAME, productName);
		context.getUtilsManager().getJavaScriptUtils().scrollIntoView(product.select_Product(0));
		context.getUtilsManager().getElementUtils().moveToElementPause(product.select_Product(0),new Long(1000));
		product.addToCart_Product();

	}

	@When("moves to the checkout page")
	public void moves_to_the_checkout_page() {
		product.navigateToCheckout();
		cart.proceedToCheckout_Signin();
		Wait.untilPageLoadComplete(driver);
	}

}
