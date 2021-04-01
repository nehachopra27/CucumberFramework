package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

public class HomePageSteps {
	TestContext context;
	HomePage home;

	public HomePageSteps(TestContext context) {
		this.context = context;
		home = context.getPageObjectManager().getHomePage();
	}

	@Given("User is on Home Page")
	public void user_is_on_home_page() {
		home.navigateToHomePage();
	}

	@When("he navigates to the Women Category")
	public void he_navigates_to_the_women_category() {
		home.navigateToWomenProducts();
	}
}
