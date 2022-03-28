package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;
	private By featuredProductsSection = By.xpath("//div[@class='product-grid home-page-product-grid']//strong[text() = 'Featured products']");
	private By featuredProducts = By.xpath("//div[@class='product-grid home-page-product-grid']//div[@class = 'item-box']");
	public By booksMenu = By.xpath("//div[@class = 'header-menu']//ul[@class = 'top-menu']//a[@href='/books']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isFeaturedProductsAvailable() {
		boolean productsAvailable = false;
		if (driver.findElement(featuredProductsSection).isDisplayed()) {
			productsAvailable = true;
		}
		return productsAvailable;
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public int getFeaturesproductsCount() {
		int productCount =driver.findElements(featuredProducts).size();
		return productCount;
	}

}
