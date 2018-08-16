package utils.driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	private static WebDriver driver;

	protected abstract WebDriver init();

	public WebDriver getWebDriver() {
		if (driver != null) {
			return driver;
		}
		return driver = init();
	}

	public void quitDriver() {
		if (driver != null) {
			try {
				driver.quit();
			} catch (Exception e) {
				System.out.println("Cannot close browser");
			} finally {
				driver = null;
			}
		}
	}

}
