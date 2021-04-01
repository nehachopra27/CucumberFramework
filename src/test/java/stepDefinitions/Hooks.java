package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	TestContext context;
	
	public Hooks(TestContext context) {
		this.context=context;
	}
	
	@Before
	public void BeforeSteps()
	{

	}
	
	@After
	public void AfterSteps() {
		context.getWebDriverManager().closeDriver();
	}

}
