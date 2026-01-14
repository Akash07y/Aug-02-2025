package stepDef;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverSetup.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.CareersPage;
import pom.HomePage;
import pom.LoginPage;
import pom.ServicesHomePage;
import pom.UniversityTalentPage;


public class StepDefination extends DriverFactory {


	private HomePage homePage ;
	private LoginPage loginPage ;
	private CareersPage careersPage ;
	private UniversityTalentPage universityTalentPage ;
	private ServicesHomePage servicesHomePage ;
	
	@Given("User logged in to allpication")
	public void login() throws InterruptedException {
		// login 
		homePage = new HomePage(driver);
		homePage.clickOnSignInButton();
		
		loginPage = new LoginPage(driver);
		loginPage.sendUsername(envConfig.getUsername());
		loginPage.clickOnContinueButton();
		loginPage.sendPassword(envConfig.getUsername());
		loginPage.clickOnContinueButton();	
	}
	
	@Given("User click on Careers option")
	public void user_click_on_carrer_option() {
		homePage = new HomePage(driver);
		homePage.clickOnCareers();
	}
	
	@Given("User click on View open jobs under Opportunities for students")
	public void view_open_jobs() {
		careersPage = new CareersPage(driver);
		careersPage.OpenStudentsOpportunities(null);
	}
	
	@When("User select country of region as {string}")
	public void select_country(String country){
		universityTalentPage = new UniversityTalentPage(driver);
		universityTalentPage.selectCountry(country) ;
	}
	
	@When("User select city as {string}")
	public void selectCity(String city){
		universityTalentPage = new UniversityTalentPage(driver);
		universityTalentPage.selectCity(city);
	}
	
	@Then("Verify that all the results should have county code {string} and city name {string}")
	public void verify_search_result(String country, String city){
		universityTalentPage = new UniversityTalentPage(driver);
		universityTalentPage.verifySearchResult(country, city);
	}

	@Given("User click on Amezon services option")
	public void click_on_amezon_services(){
		homePage = new HomePage(driver);
		homePage.clickOnAmezonServices();
	}
	
	@When("User click on View all options under publication")
	public void click_on_viewAll() {
		servicesHomePage = new ServicesHomePage(driver);
		servicesHomePage.clickOnViewAll();
	}
	
	@Given("User select Research area as {string}")
	public void select_reasearch_area(String option) {
		servicesHomePage = new ServicesHomePage(driver);
		servicesHomePage.selectFilterCheckbox(option) ;
	}
	
	@Given("User verify the total result displyed and total count")
	public void verifyTotalResultsInPublications(String option) {
		servicesHomePage = new ServicesHomePage(driver);
		servicesHomePage.selectFilterCheckbox(option) ;
	}
	
	
}
