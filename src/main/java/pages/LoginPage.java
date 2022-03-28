package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	private By email = By.id("Email");
	private By password = By.id("Password");
	private By loginButton = By.xpath("//input[@class='button-1 login-button']");
	private By forgotPasswordLink = By.xpath("//a[text()='Forgot password?']1112345");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getLoginPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public void enterUserEmail(String userEmail) {
		driver.findElement(email).sendKeys(userEmail);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
	
	public boolean forgotPasswordLinkAvailable() {
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}
	
	public String getHomePageTitle() {
		String homePageTitle = driver.getTitle();
		return homePageTitle;
	}
	
	public void doLogin(String un, String pwd) {
//		System.out.println("DO LOGIN METHOD CALLED");
		driver.findElement(email).sendKeys(un);
//		System.out.println("ENTERED EMAIL");
		driver.findElement(password).sendKeys(pwd);
//		System.out.println("ENTERED PASSWORD");
		driver.findElement(loginButton).click();
//		System.out.println("CLICKED ON LOGIN BUTTON");
	}

	

}
