package driverSetup;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import config.ConfigReader;
import config.EnvironmentConfig;

public class DriverFactory {

	public static WebDriver driver ;
	public static EnvironmentConfig envConfig ; 
	
	public void setup() {
		envConfig = ConfigReader.getActiveEnironment();
		
		if( envConfig.getBrowserName().equals("chrome") )
		{
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--password-store=basic");
			driver = new ChromeDriver(option) ;
		}
		
		if( envConfig.getBrowserName().equals("firefox") )
		{
			driver = new FirefoxDriver() ;
		}
		
		if( envConfig.getBrowserName().equals("edge") )
		{
			driver = new EdgeDriver() ;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		
		System.out.println("Url : " + envConfig.getBaseUrl());
		driver.get(envConfig.getBaseUrl());
	}
	
	public void tearDown() {
		if(driver != null)
		{
			driver.quit();
		}
	}
}
 
 
 

// Env -> Dev   QA   Stage  Prod
