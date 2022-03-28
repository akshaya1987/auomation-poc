package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {

	private WebDriver driver;
	private By cartSuccessMessage = By.xpath("//p[@class='content' and text() = 'The product has been added to your ']");
	private By addToCartButton = By.xpath("//div[@class='add-to-cart']//input[@value='Add to cart']");


	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
	}

	public  boolean clickAddToCartButton() throws InterruptedException {
		driver.findElement(addToCartButton).click();
		Thread.sleep(2000);
		if(driver.findElement(cartSuccessMessage).isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}



}
