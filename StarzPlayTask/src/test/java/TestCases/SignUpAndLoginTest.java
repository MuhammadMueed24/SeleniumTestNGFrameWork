package TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import BaseClass.Base;
import Pages.HomePage;
import Pages.Login;
import Pages.SignUp;
import Util.Helpers;
import Util.RandomEmailPasswordGenerator;

public class SignUpAndLoginTest extends Base {

    // Initialize page objects and helper classes
	SignUp sp = new SignUp(getDriver());
	HomePage hp = new HomePage(getDriver());
	Login lg = new Login(getDriver());
	Helpers hc = new Helpers();
	RandomEmailPasswordGenerator rep = new RandomEmailPasswordGenerator(); 
	String mail;
	String pass;

    // Test case for signing up to the portal
	@Test(priority = 1)
	public void TC_01_SignUp() throws InterruptedException, IOException {
		// Generate a random email address
		mail = rep.generateRandomEmail();

		// Store email in test data
		hc.initialize_value("email", mail);

		// Enter email address in the name/number field
		sp.nameOrNumField().sendKeys(mail);

		// Wait for Subscribe button to become clickable
		hc.wait_until_element_attribute_changes(getDriver(), sp.SubscribeBt());
		hc.waitForElementToBeClickable(getDriver(), sp.SubscribeBtn());

		// Click on Subscribe button
		sp.SubscribeBtn().click();

		// Wait for the password field to become visible
		hc.waitForElementToBeClickable(getDriver(), sp.PasswordField());

		// Generate a random password
		pass = rep.generateRandomPassword(10);

		// Store password in test data
		hc.initialize_value("passw", pass);

		// Enter password
		sp.PasswordField().sendKeys(pass);

		// Wait for Continue button to become clickable
		hc.wait_until_element_attribute_changes(getDriver(), sp.ContinueBtn());
		sp.ContinueBtn().click();

		// Wait for Starz Play logo to be visible, indicating successful sign-up
		hc.waitForElementToBeVisible(getDriver(), hp.starzPlayLogo());

		// Assert that the Starz Play logo is displayed
		Assert.assertTrue(hp.starzPlayLogo().isDisplayed());

		// Add a delay for visibility (can be replaced with explicit waits)
		Thread.sleep(3000);
	}

    // Test case for verifying the main page and logging out
	@Test(priority = 2)
	public void TC_02_Login() throws InterruptedException {
		// Click on the login link
		lg.LoginLink().click();

		// Wait for the user email input field to be clickable
		hc.waitForElementToBeClickable(getDriver(), lg.userEmail());

		// Enter user email
		lg.userEmail().sendKeys(prop.getProperty("email"));

		// Enter user password
		lg.userPassword().sendKeys(prop.getProperty("passw"));

		// Wait for the Login button to become clickable
		hc.wait_until_element_attribute_changes(getDriver(), lg.LoginBtn());
		lg.LoginBtn().click();

		// Wait for Subscription Message to be visible
		hc.waitForElementToBeVisible(getDriver(), hp.SubscriptionMsg());

		// Wait for the Starz Play logo to be clickable
		hc.waitForElementToBeClickable(getDriver(), hp.starzPlayLogo());
		hp.starzPlayLogo().click();

		// Wait for the navigation bar to be visible
		hc.waitForElementToBeVisible(getDriver(), hp.navbar());

		// Click on the Settings icon
		hp.SettingIcon().click();

		// Wait for Logout option to be visible
		hc.waitForElementToBeVisible(getDriver(), hp.Logout());
		hp.Logout().click();
	}
}
