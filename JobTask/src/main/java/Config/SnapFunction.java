package Config;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import BaseClass.Base;

public class SnapFunction extends Base{
	
	 // Method to capture a screenshot for a pass test case
	public String get_Screenshot(String testCaseName) throws IOException {

        // Cast WebDriver to TakesScreenshot interface
        TakesScreenshot ts = (TakesScreenshot) getDriver();

        // Capture the screenshot as a File
        File src = ts.getScreenshotAs(OutputType.FILE);

        // Define the destination file path
        String dest_File = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";

        // Copy the screenshot to the destination file
        FileUtils.copyFile(src, new File(dest_File));

        // Return the path to the captured screenshot
        return dest_File;
    }

    // Method to capture a screenshot for a failed test case
    public String getFailed_Screenshot(String testCaseName) throws IOException {

        // Cast WebDriver to TakesScreenshot interface
        TakesScreenshot ts = (TakesScreenshot) getDriver();

        // Capture the screenshot as a File
        File src = ts.getScreenshotAs(OutputType.FILE);

        // Define the destination file path for failed test cases
        String dest_File = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";

        // Copy the screenshot to the destination file
        FileUtils.copyFile(src, new File(dest_File));

        // Return the path to the captured screenshot for failed test cases
        return dest_File;
    }
}
