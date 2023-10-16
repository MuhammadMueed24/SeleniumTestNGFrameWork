package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import BaseClass.Base;
import Pages.HomePage;
import Pages.Login;
import Pages.SignUp;
import Util.util;
import Util.RandomEmailPasswordGenerator;

public class SignUpAndLoginTest extends Base {

	SignUp sp = new SignUp(getDriver());
	HomePage hp = new HomePage(getDriver());
	Login lg = new Login(getDriver());
	util utilMethods = new util();
	RandomEmailPasswordGenerator rep = new RandomEmailPasswordGenerator(); 
	String mail;
	String pass;

	@Test(priority = 1)
	public void signUpToPortal() throws InterruptedException, IOException {
		// Perform sign-up actions
		mail = rep.generateRandomEmail();
		utilMethods.initialize_value("email", mail);
		sp.nameOrNumField().sendKeys(mail);
		utilMethods.wait_until_element_attribute_changes(getDriver(), sp.SubscribeBt());
		utilMethods.waitForElementToBeClickable(getDriver(), sp.SubscribeBtn());
		sp.SubscribeBtn().click();
		utilMethods.waitForElementToBeClickable(getDriver(), sp.PasswordField());
		pass = rep.generateRandomPassword(10);
		utilMethods.initialize_value("passw", pass);
		sp.PasswordField().sendKeys(pass);
		utilMethods.wait_until_element_attribute_changes(getDriver(), sp.ContinueBtn());
		sp.ContinueBtn().click();
		utilMethods.waitForElementToBeVisible(getDriver(), hp.starzPlayLogo());
		Assert.assertTrue(hp.starzPlayLogo().isDisplayed());
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void verifyMainPageAndLogout() throws InterruptedException {
		lg.LoginLink().click();
		utilMethods.waitForElementToBeClickable(getDriver(), lg.userEmail());
		lg.userEmail().sendKeys(prop.getProperty("email"));
		lg.userPassword().sendKeys(prop.getProperty("passw"));
		utilMethods.wait_until_element_attribute_changes(getDriver(), lg.LoginBtn());
		lg.LoginBtn().click();
		utilMethods.waitForElementToBeVisible(getDriver(), hp.SubscriptionMsg());
//		Assert.assertTrue(hp.SubscriptionMsg().isDisplayed());
		utilMethods.waitForElementToBeClickable(getDriver(), hp.starzPlayLogo());
		hp.starzPlayLogo().click();
		utilMethods.waitForElementToBeVisible(getDriver(), hp.navbar());
		hp.SettingIcon().click();
		utilMethods.waitForElementToBeVisible(getDriver(), hp.Logout());
		hp.Logout().click();
	}
}
