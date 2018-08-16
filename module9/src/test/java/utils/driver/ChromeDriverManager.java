package utils.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {

	@Override
	protected WebDriver init() {
		System.setProperty("webdriver.chrome.driver",
				"src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver = new DriverDecorator(driver);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

}
