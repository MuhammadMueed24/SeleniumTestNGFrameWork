package BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
    // Create a ThreadLocal instance to store WebDriver separately for each thread
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public Properties prop;

    // This method is executed before each test method
    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setup(@Optional("Chrome") String browser) throws IOException {
        // Initialize properties to read configuration settings
        prop = new Properties();
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "/src/main/java/Config/config.properties");
        prop.load(fis);

        // Decide which browser to launch based on the 'browser' parameter
        if (browser.contains("Chrome")) {
            // Set up Chrome WebDriver and options
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver.set(new ChromeDriver(options));
        } else if (browser.contains("Firefox")) {
            // Set up Firefox WebDriver
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        } else if (browser.contains("Edge")) {
            // Set up Microsoft Edge WebDriver
            WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver());
        }
        
        // Set common timeouts and open the URL
        getDriver().manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
        getDriver().get(prop.getProperty("url"));
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    // Method to get the WebDriver instance associated with the current thread
    public WebDriver getDriver() {
        return driver.get();
    }

    // This method is executed after each test method to quit the WebDriver
    @AfterMethod(alwaysRun = true)
    public void teardown() {
        getDriver().quit();
    }
}