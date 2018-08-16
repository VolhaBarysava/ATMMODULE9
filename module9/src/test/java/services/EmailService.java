package services;

import org.testng.Reporter;

import pages.AccountPage;
import pages.BasePage;
import pages.BasketPage;
import pages.CreateEmailPage;
import pages.DraftPage;
import pages.HomePage;
import pages.IncomingPage;
import utils.driver.DriverManager;
import utils.driver.DriverManagerFactory;
import utils.driver.DriverType;
import bo.Email;
import bo.User;

public class EmailService {
	DriverManager driverManager = DriverManagerFactory.getManager(DriverType.CHROME);

	public boolean isLogin(User user, String text) {
		Reporter.log("Login to mail.ru by: " + user, 2, true);
		HomePage homePage = new HomePage(
				driverManager.getWebDriver());
		homePage.setUserName(user);
		homePage.setUserPassword(user);
		AccountPage accountPage = homePage.clickSubmitBtn();
		return accountPage.isTextPresentOnPage(text);
	}

	public void createEmail(Email email) {
		Reporter.log("Email creation is started..." + email, 2, true);
		AccountPage accountPage = new AccountPage(
				driverManager.getWebDriver());
		CreateEmailPage createEmailPage = accountPage.clickMailCreationBtn();
		createEmailPage.fillMailAddress(email.getRecipient());
		createEmailPage.fillMailSubject(email.getSubject());
		createEmailPage.fillMailBody(email.getTextBody());
		createEmailPage.clickSaveDraftBtn();
	}

	public boolean isEmailInDraftFolder(Email email) {
		Reporter.log("Check if email exists in Draft folder...", true);
		AccountPage accountPage = new AccountPage(
				driverManager.getWebDriver());
		DraftPage draftPage = accountPage.clickMailDraftMenuLink();
		return draftPage.isTextPresentOnPage(email.getSubject());
	}

	public String getIncomingEmailSubject(int index) {
		AccountPage accountPage = new AccountPage(
				driverManager.getWebDriver());
		IncomingPage incomingPage = accountPage.clickMailIncomingMenuLink();
		String actualSubject = incomingPage.getIncomingMailSubject(index);
		return actualSubject;
	}

	public void openDraftEmail(int index) {
		Reporter.log("Open draft email...");
		AccountPage accountPage = new AccountPage(
				driverManager.getWebDriver());
		DraftPage draftPage = accountPage.clickMailDraftMenuLink();
		draftPage.openDraftMail(index);
	}

	public void sendEmail(Email email) {
		Reporter.log("Email is sent..", 2, true);
		CreateEmailPage createEmailPage = new CreateEmailPage(
				driverManager.getWebDriver());
		createEmailPage.clickMailSendBtn();
	}

	public void refreshPage() {
		BasePage basePage = new CreateEmailPage(
				driverManager.getWebDriver());
		basePage.refresh();
	}

	public boolean isEmailInSentFolder(Email email) {
		Reporter.log("Check if email is in sent folder...", true);
		AccountPage accountPage = new AccountPage(
				driverManager.getWebDriver());
		accountPage.clickMailSentMenuLink();
		return accountPage.isTextPresentOnPage(email.getSubject());
	}

	public boolean checkEmailInIncomingFolder(Email email) {
		Reporter.log("Check if email is in incoming folder...", true);
		AccountPage accountPage = new AccountPage(
				driverManager.getWebDriver());
		accountPage.clickMailIncomingMenuLink();
		return accountPage.isTextPresentOnPage(email.getSubject());
	}

	public void deleteIncomingMail(int indexOfemail) {
		IncomingPage incomingPage = new IncomingPage(
				driverManager.getWebDriver());
		incomingPage.deleteIncomingMail(indexOfemail);
	}

	public boolean isEmailInIncomingFolderBySubject(
			String subjectDeleteIncomingMail) {
		IncomingPage incomingPage = new IncomingPage(
				driverManager.getWebDriver());
		return incomingPage.isTextPresentOnPage(subjectDeleteIncomingMail);
	}

	public boolean checkSubjectlInBasket(String subjectDeleteIncomingMail) {
		AccountPage accountPage = new AccountPage(
				driverManager.getWebDriver());
		BasketPage basketPage = accountPage.clickBasketMenuLink();
		return basketPage.isTextPresentOnPage(subjectDeleteIncomingMail);
	}

	public String getDeletedMailSubject(int index) {
		AccountPage accountPage = new AccountPage(
				driverManager.getWebDriver());
		BasketPage basketPage = accountPage.clickBasketMenuLink();
		return basketPage.getDeleteMailSubject(index);
	}

	public void moveEmailFromBasketToDraft(int index) {
		BasketPage basketPage = new BasketPage(
				driverManager.getWebDriver());
		basketPage.dragNDropMailFromBasketToDraft(index);
	}

	public boolean checkEmailInDraftFolderBySubject(String subjectOfDeletedMail) {
		DraftPage draftPage = new DraftPage(
				driverManager.getWebDriver());
		return draftPage.isTextPresentOnPage(subjectOfDeletedMail);
	}

	public void logOut() {
		new AccountPage(driverManager.getWebDriver())
				.clickLogOut();
	}
}
