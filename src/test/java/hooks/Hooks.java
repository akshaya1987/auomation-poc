package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import qafactory.DriverFactory;
import utilities.ConfigReader;

public class Hooks {
	WebDriver driver;
	DriverFactory driverFactory;
	ConfigReader reader;
	Properties prop;
	
	@Before(order = 0)
	public void openBrowser(){
		ConfigReader reader = new ConfigReader();
		prop = reader.initProperties();
		String browserName = prop.getProperty("browserName");
		driverFactory = new DriverFactory();
		driver = driverFactory.initDriver(browserName);
	}
	
	@After(order = 0)
	public void quitBrowser(){
		driver.quit();
	}
	
	@After(order = 1)
	public void tearDown(Scenario sc) {
		if(sc.isFailed()) {
			String screenshotName = sc.getName().replaceAll(" " , "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(sourcePath, "image/png" , screenshotName);
		}		
	}
}
