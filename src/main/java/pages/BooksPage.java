package pages;

import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.AddElementTextToList;
import utilities.DropdownSelector;

public class BooksPage {
	private WebDriver driver;
	private HomePage hpage;
	private DropdownSelector select;
	private AddElementTextToList addToList = new AddElementTextToList();
	private By sortByDropdown = By.id("products-orderby");
	private By Books = By.xpath("//div[@class='item-box']//h2[@class='product-title']//a");
	private ArrayList<String> originalList = new ArrayList<String>();
	private ArrayList<String> sortedList = new ArrayList<String>();

	public BooksPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnBooksMenu() {
		hpage = new HomePage(driver);
		driver.findElement(hpage.booksMenu).click();
	}

	public String getBooksPageTitle() {
		String booksPageTitle = driver.getTitle();
		return booksPageTitle;
	}

	public void selectAtoZ() {
		addToList.addTextToList(driver.findElements(Books), originalList);
		// originalList.add(driver.findElement(Books).getText());
		select = new DropdownSelector();
		select.selectDropdownItem(sortByDropdown, "visibletext", "Name: A to Z");
		addToList.addTextToList(driver.findElements(Books), sortedList);
	}

	public boolean booksSortedAtoZ() {
//		System.out.println("This is originalList before Sorting" + originalList);
//		System.out.println("This is tempList before Sorting" + sortedList);
		// Collections.sort(originalList);
//		System.out.println("This is originalList after Sorting" + originalList);
//		System.out.println("This is tempList after Sorting" + sortedList);

		if (originalList.equals(sortedList)) {
//			System.out.println("Dropdown sorted");
			return true;
		} else {
//			System.out.println("Dropdown Not sorted");		
		}
		return false;
	}
	
	public void selectZtoA() {
		addToList.addTextToList(driver.findElements(Books), originalList);
		// originalList.add(driver.findElement(Books).getText());
		select = new DropdownSelector();
		select.selectDropdownItem(sortByDropdown, "visibletext", "Name: Z to A");
		addToList.addTextToList(driver.findElements(Books), sortedList);
	}

	public boolean booksSortedZtoA() {
//		System.out.println("This is originalList before Sorting" + originalList);
//		System.out.println("This is tempList before Sorting" + sortedList);
		Collections.sort(originalList, Collections.reverseOrder());
//		System.out.println("This is originalList after Sorting" + originalList);
//		System.out.println("This is tempList after Sorting" + sortedList);

		if (originalList.equals(sortedList)) {
//			System.out.println("Dropdown sorted");
			return false;
		} else {
//			System.out.println("Dropdown Not sorted");		
		}
		return true;
	}
}
