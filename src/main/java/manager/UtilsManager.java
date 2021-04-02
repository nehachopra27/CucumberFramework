package manager;

import org.openqa.selenium.WebDriver;
import selenium.ElementUtils;
import selenium.JavaScriptUtils;
import selenium.Screenshot;

public class UtilsManager {
	WebDriver driver;
	ElementUtils elementUtils;
	JavaScriptUtils javaScriptUtils;
	Screenshot screenshot;

	public UtilsManager(WebDriver driver) {
		this.driver = driver;
	}

	public ElementUtils getElementUtils() {

		return (elementUtils == null) ? elementUtils = new ElementUtils(driver) : elementUtils;

	}

	public JavaScriptUtils getJavaScriptUtils() {

		return (javaScriptUtils == null) ? javaScriptUtils = new JavaScriptUtils(driver) : javaScriptUtils;

	}

	public Screenshot getScreenshot() {

		return (screenshot == null) ? screenshot = new Screenshot(driver) : screenshot;
	}
}
