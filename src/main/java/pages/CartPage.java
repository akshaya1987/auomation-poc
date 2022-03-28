package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	private WebDriver driver;
	private BooksPage bPage = new BooksPage(driver);
	private By cartProducts = By.xpath("//td[@class='product']/a[@class='product-name']");

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean productAvailableInCart() {

		boolean productsAvailableInCart = false;

		List<WebElement> productsInCart = driver.findElements(cartProducts);
		List<String> productNamesInCart = new ArrayList<String>();
		for(WebElement e: productsInCart ) {
			productNamesInCart.add(e.getText().trim());
			System.out.println(" PRODUCTS IN CART : "+e.getText());

		}

		for(String str: productNamesInCart) {
			System.out.println(" ACTUAL  : "+str);
			System.out.println("OBJECT OF Books Page : "+bPage);
			System.out.println(" EXPECTED  : "+BooksPage.selectedBookName);
			if(str.equalsIgnoreCase(BooksPage.selectedBookName)) {
				productsAvailableInCart = true;
				break;
			}

		}
		return productsAvailableInCart;
	}
}


