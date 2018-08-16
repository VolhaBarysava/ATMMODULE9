package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import utils.driver.DriverManager;
import utils.driver.DriverManagerFactory;
import utils.driver.DriverType;

import java.io.File;
import java.io.IOException;

public class ScreenShooter {
    private static final String SCREENSHOTS_NAME_TPL = "screenshots/scr";

    public static void takeScreenshot() {

    	DriverManager driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
		WebDriver driver = driverManager.getWebDriver();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotName = SCREENSHOTS_NAME_TPL + System.nanoTime();
            File copy = new File(screenshotName + ".png");
            FileUtils.copyFile(screenshot, copy);
            System.out.println("Saved screenshot: " + screenshotName);
        } catch (IOException e) {
            System.out.println("Failed to make screenshot");
        }
    }

}
