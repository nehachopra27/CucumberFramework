package cucumber;

import org.openqa.selenium.WebDriver;

import manager.PageObjectManager;
import manager.UtilsManager;
import manager.WebDriverManager;

public class TestContext {
	WebDriver driver;
	private WebDriverManager webdriverManager;
	private PageObjectManager pageObjectManager;
	private ScenarioContext scenarioContext;
	private UtilsManager utilManager;

	public TestContext() {
		webdriverManager = new WebDriverManager();
		driver = webdriverManager.getDriver();
		pageObjectManager = new PageObjectManager(driver);
		scenarioContext = new ScenarioContext();
		utilManager = new UtilsManager(driver);
	}

	public WebDriverManager getWebDriverManager() {
		return webdriverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}

	public UtilsManager getUtilsManager() {
		return utilManager;
	}
}
