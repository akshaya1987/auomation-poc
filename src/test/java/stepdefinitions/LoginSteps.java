package stepdefinitions;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import qafactory.DriverFactory;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
	
	private WebDriver driver = DriverFactory.getDriver() ;
	private String pageTitle ;
	
	private LoginPage loginPage = new LoginPage(driver);
	@Given("Login page is opened")
	public void login_page_is_opened() {
		driver.get("http://demowebshop.tricentis.com/login");
	}

	@When("Login page title is available")
	public void login_page_title_is_available() {
		driver.get("http://demowebshop.tricentis.com/login");
		pageTitle = loginPage.getLoginPageTitle();
//		System.out.println("Login page title is : "+pageTitle);
	}

	@Then("Login page title is {string}")
	public void login_page_title_is(String expectedTitle) {
		Assert.assertTrue(pageTitle.equalsIgnoreCase(expectedTitle));
//		System.out.println("Page title is : "+pageTitle+ "expected result : "+expectedTitle);
	}

	@Then("Forgot password link is available")
	public void forgot_password_link_is_available() {
		Assert.assertTrue(loginPage.forgotPasswordLinkAvailable());
	}

	@When("Entered user name")
	public void entered_user_name() {
		loginPage.enterUserEmail("qaautomation@yopmail.com");

	}

	@When("Entered password")
	public void entered_password() {
		loginPage.enterPassword("!Buddy6jar");
	}

	@When("Clicked on Login button")
	public void clicked_on_login_button() {
		loginPage.clickLoginButton();

	}

	@Then("Successfully logged-in and home page title is displayed as {string}")
	public void successfully_logged_in_and_home_page_title_is_displayed_as(String expectedTitle) {
		String homePageTitle = loginPage.getHomePageTitle();
//		System.out.println("HOME PAGE TITLE IS : "+homePageTitle);
		Assert.assertTrue(homePageTitle.equals(expectedTitle));

	}

}
