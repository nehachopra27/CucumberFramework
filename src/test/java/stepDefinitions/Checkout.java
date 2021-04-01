/*
 * package stepDefinitions;
 * 
 * import org.openqa.selenium.WebDriver; import io.cucumber.java.After; import
 * io.cucumber.java.Before; import manager.WebDriverManager; import
 * pageObjects.CartSummaryPage;
 * 
 * public class Checkout { WebDriver driver; CartSummaryPage cart;
 * WebDriverManager webDriverManager;
 * 
 * @Before public void setupBrowser() { //webDriverManager = new
 * WebDriverManager(); //driver = webDriverManager.getDriver(); }
 * 
 * 
 * @Given("User is on Home Page") public void user_is_on_home_page() {
 * pageObjectManager = new PageObjectManager(driver); home =
 * pageObjectManager.getHomePage(); home.navigateToHomePage(); }
 * 
 * @When("he navigates to the Women Category") public void
 * he_navigates_to_the_women_category() { home.navigateToWomenProducts(); }
 * 
 * 
 * 
 * @When("adds to cart the first available product on page") public void
 * adds_to_cart_the_first_available_product_on_page() { // List<WebElement>
 * products = //
 * driver.findElements(By.cssSelector("ul.product_list.grid.row>li")); product =
 * pageObjectManager.getWomenProductPage(); Actions action = new
 * Actions(driver); JavascriptExecutor js = (JavascriptExecutor) driver;
 * js.executeScript("window.scrollBy(0,700)");
 * action.moveToElement(product.select_Product(0)).pause(1000).perform(); //
 * driver.findElement(By.cssSelector("a[title='Add to cart']")).click();
 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 * product.addToCart_Product(); }
 * 
 * @When("moves to the checkout page") public void moves_to_the_checkout_page()
 * { //
 * driver.findElement(By.cssSelector("a[title='Proceed to checkout']")).click();
 * // driver.findElement(By.cssSelector("p.cart_navigation.clearfix //
 * a:nth-of-type(1)")).click(); product.navigateToCheckout(); cart =
 * pageObjectManager.getCartSummaryPage(); cart.proceedToCheckout_Signin(); }
 * 
 * 
 * 
 * @When("login as a existing user") public void
 * login_as_a_existing_user(DataTable table) {
 * 
 * driver.findElement(By.id("email")).sendKeys("test23@test.com");
 * driver.findElement(By.id("passwd")).sendKeys("test123");
 * driver.findElement(By.id("SubmitLogin")).click();
 * 
 * List<String> login = table.asList(); cart.SignIn(login.get(1), login.get(3));
 * 
 * }
 * 
 * @When("select existing address") public void select_existing_address() { //
 * driver.findElement(By.name("message")).sendKeys("This is a test product //
 * checkout"); // driver.findElement(By.name("processAddress")).click();
 * cart.addComments(); cart.proceedToCheckout_Address(); }
 * 
 * @When("agrees to terms and conditions") public void
 * agrees_to_terms_and_conditions() { //
 * driver.findElement(By.name("cgv")).click(); //
 * driver.findElement(By.name("processCarrier")).click();
 * cart.acceptTermsOfService(); cart.proceedToCheckout_Service(); }
 * 
 * @When("selects BankWire and complete checkout") public void
 * selects_bank_wire_and_complete_checkout() { //
 * driver.findElement(By.className("bankwire")).click(); //
 * driver.findElement(By.cssSelector(
 * "p.cart_navigation.clearfix>button[type='submit']")).click();
 * cart.selectWirePayment(); cart.submitCheckout(); }
 * 
 * @Then("Product should be ordered") public void product_should_be_ordered() {
 * String complete = cart.getSuccessMessage(); Assert.assertEquals(complete,
 * "Your order on My Store is complete.");
 * 
 * }
 * 
 * @After public void exitBrowser() { webDriverManager.closeDriver(); } }
 */