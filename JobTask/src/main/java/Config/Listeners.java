package Config;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import BaseClass.Base;

public class Listeners extends Base implements ITestListener {
	SnapFunction sf = new SnapFunction();
	ExtentTest test;
	ExtentReports extent = ExtentReport.report_handler();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
		extentTest.set(test);
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed: " + result.getName());
		extentTest.get().log(Status.PASS, "Test Pass");
		try {
			extentTest.get().addScreenCaptureFromPath(sf.get_Screenshot(result.getName()), result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed: " + result.getName());
		extentTest.get().log(Status.FAIL, "Test Fail");
		result.getName();
		extentTest.get().fail(result.getThrowable());
		try {
			sf.getFailed_Screenshot(result.getName());
			extentTest.get().addScreenCaptureFromPath(sf.get_Screenshot(result.getName()), result.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
}