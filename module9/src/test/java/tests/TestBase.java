package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import bo.Email;
import bo.User;
import services.EmailService;
import utils.driver.DriverManager;
import utils.driver.DriverManagerFactory;
import utils.driver.DriverType;
import pages.AccountPage;
import pages.HomePage;

public class TestBase {
	
	private static final String MAILRU_LOGIN_FIRST_ACCOUNT = "vra_atmmodule5";
	private static final String MAILRU_PASSWORD_FIRST_ACCOUNT = "123456789_Vra";
	private static final String MAILRU_LOGIN_SECOND_ACCOUNT = "vra_atmmodule6";
	private static final String MAILRU_PASSWORD_SECOND_ACCOUNT = "123456789_Vra";
	private static final String MAILRU_URL = "https://mail.ru/";
	
	private static final String MAIL_TO_ADDRESS = "vra_atmmodule6@mail.ru";
	private static long currentKey = System.currentTimeMillis();
	private static final String SUBJECT = "TestSubject" + currentKey;
	private static final String TEXT_BODY = "TestTextBody" + currentKey;

	
	static final String EXPECTED_FIRST_ACCOUNT = "vra_atmmodule5@mail.ru"; 
	static final String EXPECTED_SECOND_ACCOUNT = "vra_atmmodule6@mail.ru";
// 	please add access modifiers 
	
	
	
	protected DriverManager driverManager;
	protected WebDriver driver;
	protected EmailService emailService = new EmailService();
	
	protected User firstUser = new User(MAILRU_LOGIN_FIRST_ACCOUNT,MAILRU_PASSWORD_FIRST_ACCOUNT);
	protected User secondUser = new User(MAILRU_LOGIN_SECOND_ACCOUNT,MAILRU_PASSWORD_SECOND_ACCOUNT);
	
	protected Email email = new Email.EmailBuilder(MAIL_TO_ADDRESS).withSubject(SUBJECT).withBody(TEXT_BODY).build();

	
	@BeforeClass
	public HomePage startBrowser(){
		driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
		driver = driverManager.getWebDriver();
		driver.get(MAILRU_URL);
		return new HomePage(driver);
	}
	
	@AfterClass(description = "Stop Browser")
	public void stopBrowser() {
		AccountPage accountPage = PageFactory.initElements(driverManager.getWebDriver(), AccountPage.class);	
		accountPage.clickLogOut();
		driverManager.quitDriver();;
	}

}
