package utils.driver;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class DriverDecorator implements WebDriver, JavascriptExecutor {
	protected WebDriver driver;

	public DriverDecorator(WebDriver driver) {
		this.driver = driver;
	}

	public void get(String url) {
		driver.get(url);
		Reporter.log(String.format("Login to : %s", driver.getCurrentUrl()), true);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public List<WebElement> findElements(By by) {
		return driver.findElements(by);
	}

	public WebElement findElement(By by) {
		return driver.findElement(by);
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void close() {
		driver.close();
	}

	public void quit() {
		System.out.println("Browser will be closed now...");
		driver.quit();
	}

	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	public TargetLocator switchTo() {
		return driver.switchTo();
	}

	public Navigation navigate() {
		return driver.navigate();
	}

	public Options manage() {
		return driver.manage();
	}

	public Object executeScript(String script, Object... args) {
		return ((JavascriptExecutor) driver).executeScript(script, args);
	}

	public Object executeAsyncScript(String script, Object... args) {
		return ((JavascriptExecutor) driver).executeAsyncScript(script, args);
	}
}
