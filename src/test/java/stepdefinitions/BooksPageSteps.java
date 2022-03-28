package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BooksPage;
import qafactory.DriverFactory;

public class BooksPageSteps {
	
	private WebDriver driver = DriverFactory.getDriver();
	BooksPage bpage = new BooksPage(driver);
	
	@Given("Clicked on books menu")
	public void clicked_on_books_menu() throws InterruptedException {
		bpage.clickOnBooksMenu();
//		Thread.sleep(5000);
	}

	@When("Books page is opened with title {string}")
	public void books_page_is_opened_with_title(String title) {
		String pageTitle = bpage.getBooksPageTitle();
//		System.out.println("TITLES : "+pageTitle+"       "+title);
		Assert.assertTrue(pageTitle.equalsIgnoreCase(title));
	}


	@When("Clicked on Sort by dropdown and selected the option A to Z")
	public void clicked_on_sort_by_dropdown_and_selected_the_option_a_to_z() {
		bpage.selectAtoZ();
	}

	@Then("Books are sorted Alphabeticall by A to Z")
	public void books_are_sorted_alphabeticall_by_a_to_z() {
		Assert.assertTrue(bpage.booksSortedAtoZ());
	}


	@Then("Clicked on Sort by dropdown and selected the option Z to A")
	public void clicked_on_sort_by_dropdown_and_selected_the_option_z_to_a() {
		bpage.selectZtoA();
	}


	@Then("Books are sorted Alphabeticall by Z to A")
	public void books_are_sorted_alphabeticall_by_z_to_a() {
		Assert.assertTrue(bpage.booksSortedZtoA());
	}


}
