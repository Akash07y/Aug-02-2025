package core;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Allure;

public class ScreenshotUtility {

public static void captureScreenshot(WebDriver driver, String scenarioName) {
    try {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(scenarioName + " - Screenshot", "image/png",
                new ByteArrayInputStream(screenshot), ".png");
        System.out.println("Screenshot attached to Allure for scenario: " + scenarioName);
    } catch (Exception e) {
        System.err.println("Screenshot failed: " + e.getMessage());
    }
}

}



