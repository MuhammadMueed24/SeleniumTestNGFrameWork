package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import BaseClass.Base;

public class Login extends Base {

    // Constructor to initialize the PageFactory
    public Login(WebDriver d) {
        PageFactory.initElements(d, this);
    }

    // Locator for Login Link
    By LoginLink = By.xpath("//li/a[text()='Log in']");

    // Method to return the WebElement for Login Link
    public WebElement LoginLink() {
        return getDriver().findElement(LoginLink);
    }

    // Locator for User Email Field
    By userEmail = By.id("username");

    // Method to return the WebElement for User Email Field
    public WebElement userEmail() {
        return getDriver().findElement(userEmail);
    }

    // Locator for User Password Field
    By userPassword = By.id("password");

    // Method to return the WebElement for User Password Field
    public WebElement userPassword() {
        return getDriver().findElement(userPassword);
    }
    
    // Locator for Login Button
    By LoginBtn = By.xpath("//span[text()='Log in']");

    // Method to return the WebElement for Login Button
    public WebElement LoginBtn() {
        return getDriver().findElement(LoginBtn);
    }

}