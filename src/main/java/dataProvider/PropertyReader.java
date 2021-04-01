package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import enums.DriverType;
import enums.EnvironmentType;

public class PropertyReader {
	private Properties properties;
	private final String propertyFilePath = "configs//Configuration.properties";

	public PropertyReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}

	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitWait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getProductUrl() {
		String url = properties.getProperty("productUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("productUrl not specified in the Configuration.properties file.");
	}

	public DriverType getBrowser() {
		String browser = properties.getProperty("browser");
		if (browser==null||browser.equalsIgnoreCase("chrome"))
			return DriverType.CHROME;
		else if (browser.equalsIgnoreCase("firefox"))
			return DriverType.FIREFOX;
		else if (browser.equalsIgnoreCase("firefox"))
			return DriverType.SAFARI;
		else throw new RuntimeException("productUrl not specified in the Configuration.properties file.");
	}

	public EnvironmentType getEnvironment() {
		String environment = properties.getProperty("environment");
		if (environment == null || environment.equalsIgnoreCase("local"))
			return EnvironmentType.LOCAL;
		else if (environment.equalsIgnoreCase("remote"))
			return  EnvironmentType.REMOTE;
		else
			throw new RuntimeException("environment not specified in the Configuration.properties file.");
	}
	
	public Boolean getBrowserWindowSize() {
		String windowSize= properties.getProperty("windowMaximize");
		if (windowSize !=null)
			return Boolean.valueOf(windowSize);
		else
			return true;
	}
	
	public String getReportConfig() {
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException("productUrl not specified in the Configuration.properties file.");
	}
}
