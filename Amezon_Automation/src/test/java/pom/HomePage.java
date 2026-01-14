package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomePage {
	
	@FindBy (id="twotabsearchtextbox")
	private WebElement searchBar ;
	
	@FindBy (id="nav-search-submit-button")
	private WebElement searchBtn ;
	
	@FindBy (css="#nav-link-accountList .nav-line-2")
	private WebElement accountList ;
	
	@FindBy (xpath="//span[text()='Sign in']")
	private WebElement signIn ;
	
	@FindBy (id="nav-cart")
	private WebElement cartBucket ;
	
	@FindBy (xpath="(//div[@class='navFooterLinkCol navAccessibility']//a)[2]")
	private WebElement careers ;
	
	@FindBy (xpath="(//div[@class='navFooterLinkCol navAccessibility']//a)[4]")
	private WebElement amezonServices ;
	
	private WebDriver driver ;
	private Wait<WebDriver> wait ;
	
	// driver_1 = driver = new ChromeDriver
	public HomePage(WebDriver driver) {
		
		// to find the all WebElement of "this" class
		PageFactory.initElements(driver, this);
		
		// driver_3 = driver_1 = new ChromeDriver();
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofMillis(60000));
	}

	public void enterSearchData(String key) {
		wait.until(ExpectedConditions.visibilityOf(this.searchBar));
		this.searchBar.sendKeys(key);
	}
	
	public void clickOnSearchButton() {
		try {
			System.out.println("Clickng on Search button");
			wait.until(ExpectedConditions.elementToBeClickable(this.searchBtn));
			this.searchBtn.click();
			System.out.println("Clicked on Search button");
		}
		catch(Exception e) {
			System.err.println("Failed to click on Search button");
			e.printStackTrace();
		}
	}
	
	public void clickOnAccountList() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(this.accountList));
			this.accountList.click();
			
		}
		catch(Exception e)
		{
			System.err.println("Failed to click on account and list");
			e.printStackTrace();
		}
	}
	
	public void clickOnSignInButton() throws InterruptedException {
		Thread.sleep(5100);
		wait.until(ExpectedConditions.visibilityOf(this.accountList));
		Actions actions = new Actions(this.driver);
		actions.moveToElement(this.accountList).moveToElement(this.signIn).click().build().perform();
	}
	
	public void clickOnCartBucket() {
		wait.until(ExpectedConditions.elementToBeClickable(this.cartBucket));
		this.cartBucket.click();
	}
	
	public void clickOnCareers() {
		wait.until(ExpectedConditions.elementToBeClickable(this.careers));
		this.careers.click();
	}
	
	public void clickOnAmezonServices() {
		wait.until(ExpectedConditions.elementToBeClickable(this.amezonServices));
		this.amezonServices.click();
	}
}