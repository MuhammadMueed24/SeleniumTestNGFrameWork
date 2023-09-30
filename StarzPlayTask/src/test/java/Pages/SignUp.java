package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import BaseClass.Base;

public class SignUp extends Base {

    // Constructor to initialize the PageFactory
    public SignUp(WebDriver d) {
        PageFactory.initElements(d, this);
    }

    // Locator for Name or Number Field
    By NameOrNumField = By.id("hero_component");

    // Method to return the WebElement for Name or Number Field
    public WebElement nameOrNumField() {
        return getDriver().findElement(NameOrNumField);
    }

    
 // Locator for Subscribe Button
    By SubscribeBt = By.cssSelector(".llDcQY>div> button");

    // Method to return the WebElement for Subscribe Button
    public WebElement SubscribeBt() {
        return getDriver().findElement(SubscribeBt);
    }
    
    // Locator for Subscribe Button
    By SubscribeBtn = By.xpath("//span[text()='Subscribe now']");

    // Method to return the WebElement for Subscribe Button
    public WebElement SubscribeBtn() {
        return getDriver().findElement(SubscribeBtn);
    }

    // Locator for Create Account Text
    By CreateAccountText = By.xpath("//h1[text()='Create your account']");

    // Method to return the WebElement for Create Account Text
    public WebElement CreateAccountText() {
        return getDriver().findElement(CreateAccountText);
    }

    // Locator for Password Field
    By PasswordField = By.id("password");

    // Method to return the WebElement for Password Field
    public WebElement PasswordField() {
        return getDriver().findElement(PasswordField);
    }

    // Locator for Continue Button
    By ContinueBtn = By.xpath("//span[text()='Continue']");

    // Method to return the WebElement for Continue Button
    public WebElement ContinueBtn() {
        return getDriver().findElement(ContinueBtn);
    }
}