package stepDefinitions;

import java.util.List;

import org.junit.Assert;

import cucumber.TestContext;
import enums.Context;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartSummaryPage;

public class CartSummaryPageSteps {
	TestContext context;
	CartSummaryPage cart;

	public CartSummaryPageSteps(TestContext testContext) {
		context = testContext;
		cart = context.getPageObjectManager().getCartSummaryPage();
	}

	@When("login as a existing user")
	public void login_as_a_existing_user(DataTable table) {
		/*
		 * driver.findElement(By.id("email")).sendKeys("test23@test.com");
		 * driver.findElement(By.id("passwd")).sendKeys("test123");
		 * driver.findElement(By.id("SubmitLogin")).click();
		 */
		List<String> login = table.asList();
		cart.SignIn(login.get(1), login.get(3));

	}

	@When("select existing address")
	public void select_existing_address() {
		// driver.findElement(By.name("message")).sendKeys("This is a test product
		// checkout");
		// driver.findElement(By.name("processAddress")).click();
		cart.addComments();
		cart.proceedToCheckout_Address();
	}

	@When("agrees to terms and conditions")
	public void agrees_to_terms_and_conditions() {
		// driver.findElement(By.name("cgv")).click();
		// driver.findElement(By.name("processCarrier")).click();
		cart.acceptTermsOfService();
		cart.proceedToCheckout_Service();
	}

	@When("selects BankWire and complete checkout")
	public void selects_bank_wire_and_complete_checkout() {
		// driver.findElement(By.className("bankwire")).click();
		// driver.findElement(By.cssSelector("p.cart_navigation.clearfix>button[type='submit']")).click();
		String productCart=cart.getProductName();
		Assert.assertEquals(productCart,context.getScenarioContext().getScenarioContext(Context.PRODUCT_NAME));
		cart.selectWirePayment();
		cart.submitCheckout();
	}

	@Then("Product should be ordered")
	public void product_should_be_ordered() {
		String complete = cart.getSuccessMessage();
		Assert.assertEquals(complete, "Your order on My Store is complete.");
	}
}
