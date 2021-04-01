package cucumber;

import manager.PageObjectManager;
import manager.WebDriverManager;

public class TestContext {

	private WebDriverManager webdriverManager;
	private PageObjectManager pageObjectManager;
	private ScenarioContext scenarioContext;
	
	public TestContext() {
		webdriverManager=new WebDriverManager();
		pageObjectManager=new PageObjectManager(webdriverManager.getDriver());
		scenarioContext=new ScenarioContext();
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
}
