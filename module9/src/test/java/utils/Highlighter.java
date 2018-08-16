package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.driver.DriverManager;
import utils.driver.DriverManagerFactory;
import utils.driver.DriverType;

public class Highlighter {
	
	public static void highlightElement(WebElement element) {
		DriverManager driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
		WebDriver driver = driverManager.getWebDriver();
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].style.backgroundColor = 'yellow'", element);
	}

	public static void unHighlightElement(WebElement element) {
		DriverManager driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
		WebDriver driver = driverManager.getWebDriver();
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].style.backgroundColor = ''", element);
	}

}
