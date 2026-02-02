package stepDef;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverSetup.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
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
	
	@Step("User logged in to allpication")   // @Setp is from Allure for better reporting
	@Given("User logged in to allpication")
	public void login() throws InterruptedException {
		// login 
//		homePage = new HomePage(driver);
//		homePage.clickOnSignInButton();
//		
//		loginPage = new LoginPage(driver);
//		loginPage.sendUsername(envConfig.getUsername());
//		loginPage.clickOnContinueButton();
//		loginPage.sendPassword(envConfig.getUsername());
//		loginPage.clickOnContinueButton();	
	}
	
	//@Step("User click on Careers option")
	@Given("User click on Careers option")
	public void user_click_on_carrer_option() {
		homePage = new HomePage(driver);
		homePage.clickOnCareers();
	}
	
//	@Step("User click on View open jobs under Opportunities for students")
	@Given("User click on View open jobs under Opportunities for students")
	public void view_open_jobs() {
		careersPage = new CareersPage(driver);
		careersPage.OpenStudentsOpportunities(null);
	}
	
//	@Step("User select country of region as {0}")
	@When("User select country of region as {string}")
	public void select_country(String country){
		universityTalentPage = new UniversityTalentPage(driver);
		universityTalentPage.selectCountry(country) ;
	}
	
//	@Step("User select city as {0}")
	@When("User select city as {string}")
	public void selectCity(String city){
		universityTalentPage = new UniversityTalentPage(driver);
		universityTalentPage.selectCity(city);
	}
	
//	@Step("Verify that all the results should have county code {0} and city name {0}")
	@Then("Verify that all the results should have county code {string} and city name {string}")
	public void verify_search_result(String country, String city){
		universityTalentPage = new UniversityTalentPage(driver);
		universityTalentPage.verifySearchResult(country, city);
		Assert.assertTrue(false);
	}

//	@Step("Verify that all the results should have county code {0} and city name {0}")
	@Then("Verify that service status")
	public void verify_search_result_2(){
//		universityTalentPage = new UniversityTalentPage(driver);
//		universityTalentPage.verifySearchResult(country, city);
		Assert.assertTrue(false);
	}
	

//	@Step("User click on Amezon services option")
	@Given("User click on Amezon services option")
	public void click_on_amezon_services(){
		homePage = new HomePage(driver);
		homePage.clickOnAmezonServices();
	}
	
//	@Step("User click on View all options under publication")
	@When("User click on View all options under publication")
	public void click_on_viewAll() {
		servicesHomePage = new ServicesHomePage(driver);
		servicesHomePage.clickOnViewAll();
	}
	
//	@Step("User select Research area as {0}")
	@Given("User select Research area as {string}")
	public void select_reasearch_area(String option) {
		servicesHomePage = new ServicesHomePage(driver);
		servicesHomePage.selectFilterCheckbox(option) ;
	}
	
//	@Step("User verify the total result displyed and total count {0}")
	@Given("User verify the total result displyed and total count {string}")
	public void verifyTotalResultsInPublications(String option) {
		servicesHomePage = new ServicesHomePage(driver);
		servicesHomePage.selectFilterCheckbox(option) ;
	}
	
	
}




