package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.driver.ChromeDriverManager;
import utils.driver.DriverManager;
import utils.driver.DriverManagerFactory;
import utils.driver.DriverType;

public class BasePage {
	private static final int DEFAULT_TIMEOUT = 15;
	
	DriverManager driverManager;
// 	please add access modifier to DriverManager
	public WebDriver driver;

	public BasePage(WebDriver driver) {
		driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
		this.driver = driverManager.getWebDriver();
		PageFactory.initElements(new ChromeDriverManager().getWebDriver(),
				this);
	}

	protected void waitForElementVisible(WebElement elements) {
		new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions
				.visibilityOfAllElements(elements));
	}

	public boolean isElementPresent(By locator) {
		return !driver.findElements(locator).isEmpty();
	}

	public boolean isTextPresentOnPage(String text) {
		return isElementPresent(By.xpath("//*[text()='" + text + "']"));
	}

	public void refresh() {
		driver.navigate().refresh();
	}

}
