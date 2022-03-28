package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import qafactory.DriverFactory;

public class DropdownSelector {

	WebDriver driver = DriverFactory.getDriver();

	public void selectDropdownItem(By locator, String type, String value) {

		Select sel = new Select (driver.findElement(locator));

		switch (type) {

		case "index":
			sel.selectByIndex(Integer.parseInt(value));
			break;

		case "value":
			sel.selectByValue(value);
			break;

		case "visibletext":
			sel.selectByVisibleText(value);
			break;
			
		default:
				System.out.println("Please select the proper selection criteria!!!");
		}
	}
}
