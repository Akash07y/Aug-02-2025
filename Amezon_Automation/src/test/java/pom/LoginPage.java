package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	@FindBy (id="ap_email_login")
	private WebElement emailId ;
	
	@FindBy (id="ap_email_login")
	private WebElement header ;
	
	@FindBy (css="input[type='submit']")
	private WebElement continueBtn ;
	
	@FindBy (id="ap_password")
	private WebElement password ;
	
	@FindBy (id="(//div[@class='a-alert-content'])[1]")
	private WebElement errorMesage ;
	
	private WebDriver driver ;
	private WebDriverWait wait ;
	
	// To verify each page
	public void verifyLoginPage() {
		System.out.println("test");
		System.out.println("test");
		System.out.println("test");
		boolean result = header.isDisplayed();
		if(result) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
	}
	
	
	public LoginPage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		this.driver = driver ;
		wait = new WebDriverWait(driver, Duration.ofMillis(60000));
	}
	
	public void sendUsername(String email) {
		wait.until(ExpectedConditions.visibilityOf(this.emailId)) ;
		this.emailId.sendKeys(email);
	}
	
	
	public void sendPassword(String pass) {
		wait.until(ExpectedConditions.visibilityOf(this.password)) ;
		this.password.sendKeys(pass);
	}
	
	public void clickOnContinueButton() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(this.continueBtn)) ;
		this.continueBtn.click();
		Thread.sleep(5000);
//		try {
//			driver.switchTo().alert().dismiss();
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
	}
	
	public String getErrorMEssage() {
		return this.errorMesage.getText();
	}
}
