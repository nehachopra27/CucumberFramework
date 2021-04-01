package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartSummaryPage {
	WebDriver driver;

	public CartSummaryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "td.cart_delete.text-center")
	private WebElement deleteProduct;

	@FindBy(how = How.CSS, using = "a[class*='cart_quantity_up']")
	private WebElement increaseQuantity;

	@FindBy(how = How.CSS, using = "a[class*='cart_quantity_down']")
	private WebElement decreaseQuantity;

	@FindBy(how = How.CSS, using = "p.cart_navigation.clearfix a:nth-of-type(1)")
	private WebElement proceedToCheckout_signin;

	@FindBy(how = How.NAME, using = "processAddress")
	private WebElement proceedToCheckout_Address;

	@FindBy(how = How.NAME, using = "processCarrier")
	private WebElement proceedToCheckout_Service;

	@FindBy(how = How.ID, using = "email")
	private WebElement email_Signin;

	@FindBy(how = How.ID, using = "passwd")
	private WebElement password_Signin;

	@FindBy(how = How.ID, using = "SubmitLogin")
	private WebElement signin_Button;

	@FindBy(how = How.NAME, using = "message")
	private WebElement CommentBox;

	@FindBy(how = How.NAME, using = "cgv")
	private WebElement TermsOfService;

	@FindBy(how = How.CLASS_NAME, using = "bankwire")
	private WebElement BankWire;

	@FindBy(how = How.CSS, using = "p.cart_navigation.clearfix>button[type='submit']")
	private WebElement submit;

	@FindBy(how = How.CSS, using = "p.cheque-indent")
	private WebElement Success_checkout;
	
	@FindBy(how = How.CSS, using = "p.product-name a")
	private WebElement productName;

	public void proceedToCheckout_Signin() {
		proceedToCheckout_signin.click();
	}

	public void enterEmail(String email) {
		email_Signin.sendKeys(email);
	}

	public void enterPassword(String password) {
		password_Signin.sendKeys(password);
	}

	public void clickSignin() {
		signin_Button.click();
	}

	public void SignIn(String email, String paswd) {
		enterEmail(email);
		enterPassword(paswd);
		clickSignin();
	}

	public void addComments() {
		CommentBox.sendKeys("This is a test comment");
	}

	public void acceptTermsOfService() {
		TermsOfService.click();
	}

	public void proceedToCheckout_Address() {
		proceedToCheckout_Address.click();
	}

	public void proceedToCheckout_Service() {
		proceedToCheckout_Service.click();
	}

	public void selectWirePayment() {
		BankWire.click();
	}

	public void submitCheckout() {
		submit.click();
	}

	public String getSuccessMessage() {
		return Success_checkout.getText();
	}
	
	public String getProductName() {
		return productName.getText();
	}

}
