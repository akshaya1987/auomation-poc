package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import qafactory.DriverFactory;


public class HomePageSteps {

	private WebDriver driver = DriverFactory.getDriver();
	private LoginPage loginPage = new LoginPage(driver);
	private HomePage homePage = new HomePage(driver);

	@Given("User has already logged into the application")
	public void user_has_already_logged_into_the_application(DataTable dataTable) throws InterruptedException {
		driver.get("http://demowebshop.tricentis.com/login");
		List<Map<String, String>> credList = dataTable.asMaps();
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");
//		System.out.println("USER NAME : "+username+ " PASSWORD "+password);
		loginPage.doLogin(username, password);
		//		Thread.sleep(3000);
	}

	@Given("User is in Home page")
	public void user_is_in_home_page() {
		homePage.getTitle();
	}

	@Then("Featured Products section is available")
	public void featured_products_section_is_available() {
		homePage.isFeaturedProductsAvailable();
	}

	@Then("Count of products listed in Featured Products is {int}")
	public void count_of_products_listed_in_featured_products_is(Integer count) {
		int productCount = homePage.getFeaturesproductsCount();
		boolean productCountMatches = false;
		if(productCount == count) {
			productCountMatches = true;
		}
		Assert.assertTrue(productCountMatches);
	}

}
