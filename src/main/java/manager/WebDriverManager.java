package manager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import enums.DriverType;
import enums.EnvironmentType;

public class WebDriverManager {

		 private WebDriver driver;
		 private static DriverType driverType;
		 private static EnvironmentType environmentType;
		 private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
		 
		 public WebDriverManager() {
		 driverType = FileReaderManager.getInstance().getPropertyReader().getBrowser();
		 environmentType = FileReaderManager.getInstance().getPropertyReader().getEnvironment();
		 }
		 
		 public WebDriver getDriver() {
		 if(driver == null) 
			 driver = createDriver();
		 return driver;
		 }
		 
		 private WebDriver createDriver() {
		    switch (environmentType) {     
		         case LOCAL : driver = createLocalDriver();
		          break;
		         case REMOTE : driver = createRemoteDriver();
		          break;
		    }
		    return driver;
		 }
		 
		 private WebDriver createRemoteDriver() {
		 throw new RuntimeException("RemoteWebDriver is not yet implemented");
		 }
		 
		 private WebDriver createLocalDriver() {
		        switch (driverType) {     
		        case FIREFOX : driver = new FirefoxDriver();
		        break;
		        
		        case CHROME : 
		        System.setProperty(CHROME_DRIVER_PROPERTY, System.getProperty("user.dir")+FileReaderManager.getInstance().getPropertyReader().getDriverPath());
		        driver = new ChromeDriver();
		        break;
		        
		        case SAFARI : 
		        driver = new SafariDriver();
		        break;
		        }
		 
		        if(FileReaderManager.getInstance().getPropertyReader().getBrowserWindowSize()) driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getPropertyReader().getImplicitlyWait(), TimeUnit.SECONDS);
		 return driver;
		 } 
		 
		 public void closeDriver() {
		 driver.close();
		 driver.quit();
		 }
		 
}
