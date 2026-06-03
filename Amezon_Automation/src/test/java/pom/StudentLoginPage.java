package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * StudentLoginPage - Page Object Model for Student Login functionality
 * Handles interactions with student login elements
 */
public class StudentLoginPage {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentLoginPage.class);
	
	@FindBy(xpath = "input[@id='studentID']")
	private WebElement studentIdInput;
	
	@FindBy(xpath = "input[@id='studentAccPass']")
	private WebElement studentPasswordInput;
	
	@FindBy(xpath = "button[@test='signup']")
	private WebElement signupButton;
	
	private WebDriver driver;
	private Wait<WebDriver> wait;
	
	/**
	 * Constructor to initialize WebDriver and wait object
	 * Initializes all WebElements using PageFactory
	 * 
	 * @param driver WebDriver instance
	 */
	public StudentLoginPage(WebDriver driver) {
		
		// Initialize all WebElements of this class
		PageFactory.initElements(driver, this);
		
		// Store driver instance
		this.driver = driver;
		
		// Initialize WebDriverWait with 10 seconds timeout
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		logger.info("StudentLoginPage initialized successfully");
	}
	
	/**
	 * Enters student ID in the student ID input field
	 * Waits for element visibility before entering data
	 * 
	 * @param studentId The student ID to enter
	 */
	public void enterStudentId(String studentId) {
		logger.debug("Entering student ID: {}", studentId);
		try {
			wait.until(ExpectedConditions.visibilityOf(this.studentIdInput));
			this.studentIdInput.sendKeys(studentId);
			logger.info("Student ID entered successfully");
		} catch (Exception e) {
			logger.error("Failed to enter student ID: {}", e.getMessage(), e);
			throw new RuntimeException("Failed to enter student ID", e);
		}
	}
	
	/**
	 * Enters student password in the password input field
	 * Waits for element visibility before entering data
	 * 
	 * @param password The student password to enter
	 */
	public void enterStudentPassword(String password) {
		logger.debug("Entering student password");
		try {
			wait.until(ExpectedConditions.visibilityOf(this.studentPasswordInput));
			this.studentPasswordInput.sendKeys(password);
			logger.info("Student password entered successfully");
		} catch (Exception e) {
			logger.error("Failed to enter student password: {}", e.getMessage(), e);
			throw new RuntimeException("Failed to enter student password", e);
		}
	}
	
	/**
	 * Clicks on the signup button
	 * Waits for element to be clickable before clicking
	 */
	public void clickOnSignupButton() {
		logger.debug("Clicking on signup button");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(this.signupButton));
			this.signupButton.click();
			logger.info("Signup button clicked successfully");
		} catch (Exception e) {
			logger.error("Failed to click on signup button: {}", e.getMessage(), e);
			throw new RuntimeException("Failed to click on signup button", e);
		}
	}
	
	/**
	 * Performs complete student login process
	 * Combines entering student ID, password, and clicking signup
	 * 
	 * @param studentId The student ID
	 * @param password The student password
	 */
	public void loginStudent(String studentId, String password) {
		logger.info("Starting student login process");
		try {
			enterStudentId(studentId);
			enterStudentPassword(password);
			clickOnSignupButton();
			logger.info("Student login completed successfully");
		} catch (Exception e) {
			logger.error("Student login process failed: {}", e.getMessage(), e);
			throw new RuntimeException("Student login failed", e);
		}
	}
	
}
