package utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import qafactory.DriverFactory;

public class AddElementTextToList {
	
	WebDriver driver = DriverFactory.getDriver();
	ArrayList<String> list = new ArrayList<String>();
	
	public List<String> addTextToList(List<WebElement> element, List<String> list){
		
		for(WebElement e: element) {
			list.add(e.getText());
		}
		
		return list;
	}

}
