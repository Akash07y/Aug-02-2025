package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

import core.ScreenshotUtility;
import driverSetup.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class CoreHooks extends DriverFactory {

    private WebDriver driver;

    @Before
    public void beforeScenario(Scenario scenario) {
        // Initialize browser
    	setup();
        driver = DriverFactory.driver;
        
        System.out.println("Browser launched for scenario: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {    	
    	
    	if (scenario.isFailed()) {
            System.out.println("Scenario failed: " + scenario.getName());
            ScreenshotUtility.captureScreenshot(driver, scenario.getName());
        }

        tearDown();  // close browser AFTER screenshot
        System.out.println("Browser closed for scenario: " + scenario.getName());
    }
}


   