package hooks;

import org.openqa.selenium.WebDriver;

import core.ScreenshotUtility;
import driverSetup.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CoreHooks extends DriverFactory{

	private WebDriver driver ;
	

    @Before
    public void beforeScenario() {
    	
        setup();
        driver = DriverFactory.driver;
    }

    @After
    public void afterScenario(Scenario scenario) {

    	if(scenario.isFailed())
    	{
    		ScreenshotUtility.captureScreenshot(driver, scenario.getName());
    	}
    	
        tearDown();
    }
}

   