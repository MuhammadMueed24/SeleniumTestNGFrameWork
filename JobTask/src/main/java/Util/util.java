package Util;

import java.io.FileOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import BaseClass.Base;

public class util extends Base {

	private static final Duration DEFAULT_WAIT_DURATION = Duration.ofSeconds(10);

	// Method to wait for an element to be visible using its locator
	public void waitForElementToBeVisible(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_DURATION);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Method to wait for an element to be visible using a WebElement
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_DURATION);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Method to wait for an element to be clickable
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_DURATION);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void wait_until_element_attribute_changes(WebDriver webDriver, WebElement locator) {
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(locator, "disabled", "true")));
	}

	// Method to check if an element is visible
	public Boolean isElementVisible(WebDriver driver, WebElement element) {
		waitForElementToBeVisible(driver, element);
		return element.isDisplayed();
	}

	// Method to capture a screenshot
	public String captureScreenshot(String testCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir") + File.separator + "reports" + File.separator + testCaseName
				+ ".png";
		FileUtils.copyFile(src, new File(destFile));
		return destFile;
	}

	// Method to capture a screenshot for a failed test
	public String captureFailedScreenshot(String testCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir") + File.separator + "Failed_testcases" + File.separator
				+ testCaseName + ".png";
		FileUtils.copyFile(src, new File(destFile));
		return destFile;
	}

	// Method to scroll an element into view
	public void scrollIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	// Method to scroll to the end of the page
	public void scrollToPageEnd(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	public void initialize_value(String key, String value) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/Config/config.properties");
		prop.load(fis);
		prop.setProperty(key, value);
		prop.store(new FileOutputStream(System.getProperty("user.dir") + "/src/main/java/Config/config.properties"),
				null);
	}
}