package qafactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	public WebDriver initDriver(String browser) {
		
		System.out.println("Browser is : "+browser );
		System.out.println("Browser is : "+browser.equalsIgnoreCase("Chrome"));

		if(browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		}
		else if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
		}
		else if(browser.equalsIgnoreCase("Safari")) {
			tldriver.set(new SafariDriver());
		}
		else{
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}

	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}

}
