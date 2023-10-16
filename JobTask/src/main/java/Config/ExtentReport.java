package Config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import BaseClass.Base;

public class ExtentReport extends Base {
	static ExtentReports extent;

	// Method to set up and configure Extent Reports
	public static ExtentReports report_handler() {
		// Define the path for the Extent Reports HTML file
		String path = System.getProperty("user.dir") + "\\Extentreports\\reports.html";

		// Create an ExtentSparkReporter to configure the report
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Reports"); // Set report name
		reporter.config().setDocumentTitle("Star Play Test Run"); // Set document title

		// Create an ExtentReports instance
		extent = new ExtentReports();

		// Attach the ExtentSparkReporter to the ExtentReports instance
		extent.attachReporter(reporter);

		// Set system information in the report
		extent.setSystemInfo("WebBrowser", "Chrome");
		extent.setSystemInfo("Tester", "Mueed");
		extent.setSystemInfo("OS", "Windows");

		// Return the configured ExtentReports instance
		return extent;
	}
}