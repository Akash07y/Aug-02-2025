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

public class CareersPage {

	@FindBy (xpath = "//a[text()='View open jobs']")
	private List<WebElement> viewOpenJobsBtn ; 
	
	private Wait<WebDriver> wait ;
	
	public CareersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofMillis(60000));
	}
	
	public void OpenStudentsOpportunities(String option ) {
		wait.until(ExpectedConditions.elementToBeClickable(this.viewOpenJobsBtn.get(0)));
		this.viewOpenJobsBtn.get(0).click();
	}
	
	public void OpenWarehouseAndHourlyOpportunities() {
		wait.until(ExpectedConditions.elementToBeClickable(this.viewOpenJobsBtn.get(1)));
		this.viewOpenJobsBtn.get(1).click();
	}
	
	public void OpenSoftwareDevelopmentOpportunities() {
		wait.until(ExpectedConditions.elementToBeClickable(this.viewOpenJobsBtn.get(2)));
		this.viewOpenJobsBtn.get(2).click();
	}
	
	public void testmethod() {
		wait.until(ExpectedConditions.elementToBeClickable(this.viewOpenJobsBtn.get(2)));
		this.viewOpenJobsBtn.get(2).click();
	}
}