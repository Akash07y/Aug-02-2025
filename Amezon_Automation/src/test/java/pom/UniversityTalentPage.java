package pom;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class UniversityTalentPage {

	@FindBy (xpath = "(//fieldset[contains(@class, 'filter-module_root')])[1]//ul/li//span/div")
	private List<WebElement> countryCheckBox ;
	
	@FindBy (xpath = "(//fieldset[contains(@class, 'filter-module_root')])[1]//ul/li//span/div/span")
	private List<WebElement> countryWiseOpenPosition ;
	
	@FindBy (xpath = "(//fieldset[contains(@class, 'filter-module_root')])[2]//ul/li//span/div")
	private List<WebElement> stateCheckBox ;
	
	@FindBy (xpath = "(//fieldset[contains(@class, 'filter-module_root')])[2]//ul/li//span/div/span")
	private List<WebElement> stateWiseOpenPosition ;
	
	@FindBy (xpath = "(//fieldset[contains(@class, 'filter-module_root')])[3]//ul/li//span/div")
	private List<WebElement> cityCheckBox ;
	
	@FindBy (xpath = "(//fieldset[contains(@class, 'filter-module_root')])[3]//ul/li//span/div/span")
	private List<WebElement> cityWiseOpenPosition ;
	
	@FindBy (xpath = "//ul[contains(@class, 'jobs-module_root__gY8Hp')]//div[2][@data-test-component='StencilText']")
	private List<WebElement> searchResults ;
	
	private Wait<WebDriver> wait ;
	
	public UniversityTalentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofMillis(60000));
	}
	
	public String selectCountry(String country) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(this.countryCheckBox.get(0)));
			for(int i=0 ; i < this.countryCheckBox.size() ; i++) {
				String text = this.countryCheckBox.get(i).getText();
				System.out.println(text);
				if(text.contains(country)) {
					//this.countryCheckBox.get(i).click();
					wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(this.countryCheckBox.get(i))));
					String countryCount = this.countryWiseOpenPosition.get(i).getText();
					
					return countryCount ;
				}
			}
		}
		catch(Exception e) {
			System.err.println("Failed to selected country : " + country);
			e.printStackTrace();
		}
		return null ;
	}
	
	public String selectState(String state) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(this.stateCheckBox.get(0)));
			for(int i=0 ; i < this.stateCheckBox.size() ; i++) {
				if(this.stateCheckBox.get(i).getText().equalsIgnoreCase(state)) {
					this.stateCheckBox.get(i).click();
					String stateCount = this.stateWiseOpenPosition.get(i).getText();
					System.out.println("Selected state : " + state);
					return stateCount ;
				}
			}
		}
		catch(Exception e) {
			System.err.println("Failed to selected state : " + state);
			e.printStackTrace();
		}
		return null ;
	}
	
	public String selectCity(String city) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(this.cityCheckBox.get(0)));
			for(int i=0 ; i < this.cityCheckBox.size() ; i++) {
				if(this.cityCheckBox.get(i).getText().equalsIgnoreCase(city)) {
					this.cityCheckBox.get(i).click();
					String cityCount = this.cityWiseOpenPosition.get(i).getText();
					System.out.println("Selected city : " + city);
					return cityCount ;
				}
			}
		}
		catch(Exception e) {
			System.err.println("Failed to selected city : " + city);
			e.printStackTrace();
		}
		return null ;
	}
	                                         ///USA
	public void verifySearchResult(String countryCode, String city) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(this.searchResults.get(0)));
			for(int i=0 ; i < this.searchResults.size() ; i = i+2) {
				String text = this.searchResults.get(i).getText() ;  // Woshinton DC XXX   
				Assert.assertTrue(text.trim().endsWith(countryCode));

			}
			System.out.println("Verified country code in all search results : " + countryCode);
		}
		catch(Exception e) {
			System.err.println("Failed to verify country code in search results");
		}
	}
}