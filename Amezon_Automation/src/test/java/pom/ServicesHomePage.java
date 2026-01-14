package pom;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ServicesHomePage {
	
	@FindBy (xpath="(//a[text()='Research areas'])[2]")
	private WebElement researchAreasLink ;
	
	@FindBy (xpath="(//a[text()='Computer vision'])[3]")
	private WebElement computerVersionLink ;
	
	@FindBy (xpath="//h2[text()='Publications']/following-sibling::a[1]")
	private WebElement publicationsViewAll ;
	
	@FindBy (xpath="(//div[@class='SearchFilter'])[1]//ul//li//input")
	private List<WebElement> filterCheckBox ;
	
	@FindBy (xpath="(//div[@class='SearchFilter'])[1]//ul//li//span")
	private List<WebElement> filterIndividualCount ;
	
	@FindBy (xpath="//div[contains(text(),'results found')]")
	private WebElement resultFound ;
	
	private Wait<WebDriver> wait ;
	private WebDriver driver ;
	
	public ServicesHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver ;
		wait = new WebDriverWait(driver, Duration.ofMillis(60000));
	}
	
	public String selectFilterCheckbox(String checkBoxOption) {
		try {
			String selectedOption = null;
			wait.until(ExpectedConditions.visibilityOf(this.filterCheckBox.get(0)));
			for(int i =0; i<this.filterCheckBox.size(); i++) {
				if(this.filterCheckBox.get(i).getText().contains(checkBoxOption))
				{
					this.filterCheckBox.get(i).click();
					selectedOption= this.filterIndividualCount.get(i).getText();
					break;
				}
			}
//			this.filterCheckBox.get(i).click();
//			String text = this.filterIndividualCount.get(checkBoxOption).getText();
			System.out.println("Clicked on checkbox option : " + checkBoxOption);
			return selectedOption ;
		}
		catch(Exception e) {  // common handling for all exception
			System.err.println("Failed to click on checkbox option : " + checkBoxOption) ;
			e.printStackTrace();
		}
		return null;
	}
	
	public void clickOnViewAll() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(this.publicationsViewAll));
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", this.publicationsViewAll);
			this.publicationsViewAll.click();
			System.out.println("Clicked on View all button");
		}
		catch(Exception e) {
			System.err.println("Failed to click on view all button");
			e.printStackTrace();
		}
	}
	
	public String getTotalResultFound() {
		try {
			System.out.println("Find total result found count");
			wait.until(ExpectedConditions.visibilityOf(this.resultFound));
			return this.resultFound.getText();
			
		}
		catch(Exception e) {
			System.err.println("Failed to get the total result found count");
			e.printStackTrace();
		}
		return null ;
	}
}
