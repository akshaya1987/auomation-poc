package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import qafactory.DriverFactory;

public class ElementInitializer {
	WebDriver driver = DriverFactory.getDriver();
	WebElement element;
	List<WebElement> elements;
	By locator;
	String type;

	public WebElement getElement(By locator, String type) {
		element = driver.findElement(locator);
		return element;
	}

	public List<WebElement> getElements(By locator, String type) {
		elements = driver.findElements(locator);
		return elements;
	}
}

