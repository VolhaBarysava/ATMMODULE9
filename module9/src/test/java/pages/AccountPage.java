package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

	public AccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id='b-toolbar__left']//a[(@data-name = 'compose')]")
	private WebElement mailCreationBtn;

	@FindBy(xpath = "//*[contains(@class,'ico_folder_send')]")
	private WebElement mailSendMenuLink;

	@FindBy(xpath = "//*[contains(@class,'ico_folder_inbox')]")
	private WebElement mailIncomingMenuLink;

	@FindBy(xpath = "//*[@id='b-nav_folders']//i[contains(@class,'ico_folder_trash')]")
	private WebElement mailBasketMenuLink;

	@FindBy(id = "PH_logoutLink")
	private WebElement logOutLink;

	@FindBy(xpath = "//*[contains(@class,'ico_folder_drafts')]")
	private WebElement mailDraftMenuLink;

	public CreateEmailPage clickMailCreationBtn() {
		waitForElementVisible(mailCreationBtn);
		mailCreationBtn.click();
		return new CreateEmailPage(driver);
	}

	public DraftPage clickMailDraftMenuLink() {
		waitForElementVisible(mailDraftMenuLink);
		mailDraftMenuLink.click();
		return new DraftPage(driver);
	}

	public AccountPage clickMailSentMenuLink() {
		waitForElementVisible(mailSendMenuLink);
		mailSendMenuLink.click();
		return new AccountPage(driver);
	}

	public IncomingPage clickMailIncomingMenuLink() {
		waitForElementVisible(mailIncomingMenuLink);
		mailIncomingMenuLink.click();
		return new IncomingPage(driver);
	}

	public BasketPage clickBasketMenuLink() {
		waitForElementVisible(mailBasketMenuLink);
		mailBasketMenuLink.click();
		return new BasketPage(driver);
	}

	public HomePage clickLogOut() {
		waitForElementVisible(logOutLink);
		logOutLink.click();
		return new HomePage(driver);
	}
	
	public WebElement getMailDraftMenuLink(){
		return mailDraftMenuLink;
	}

}
