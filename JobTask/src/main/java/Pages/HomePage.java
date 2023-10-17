package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import BaseClass.Base;

public class HomePage extends Base {

    // Constructor to initialize the PageFactory
    public HomePage(WebDriver d) {
        PageFactory.initElements(d, this);
    }

    // Locator for Subscription Message
    By SubscriptionMsg = By.xpath("//h1[contains(text(),'Choose your subscription')]");

    // Method to return the WebElement for Subscription Message
    public WebElement SubscriptionMsg() {
        return getDriver().findElement(SubscriptionMsg);
    }

    // Locator for StarzPlay Logo
    By starzPlayLogo = By.xpath("//header/a[1]/img[1]");

    // Method to return the WebElement for StarzPlay Logo
    public WebElement starzPlayLogo() {
        return getDriver().findElement(starzPlayLogo);
    }

    // Locator for Navbar
    By navbar = By.id("navbarHeader");

    // Method to return the WebElement for Navbar
    public WebElement navbar() {
        return getDriver().findElement(navbar);
    }

    // Locator for Setting Icon
    By SettingIcon = By.cssSelector("#avatarMenu>a>svg");

    // Method to return the WebElement for Setting Icon
    public WebElement SettingIcon() {
        return getDriver().findElement(SettingIcon);
    }

    // Locator for Logout Link
    By Logout = By.xpath("//ul[@id='dropDownUser']/li[4]/a");

    // Method to return the WebElement for Logout Link
    public WebElement Logout() {
        return getDriver().findElement(Logout);
    }
}
