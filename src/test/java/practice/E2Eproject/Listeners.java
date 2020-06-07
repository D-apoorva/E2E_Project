package practice.E2Eproject;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Base implements ITestListener{
	ExtentTest test;
	
ExtentReports extent = ExtentReporterNG.getReports();
ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
	
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS,"test passed");
	
	}

	
	public void onTestFailure(ITestResult result) {
		 extentTest.get().fail(result.getThrowable());
		org.openqa.selenium.WebDriver driver =null;
       
		String testMethodName =result.getMethod().getMethodName();

		try {

			driver = (org.openqa.selenium.WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());

			} catch(Exception e) {

			}

			try {

			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver), result.getMethod().getMethodName());

			} catch (IOException e) {

			e.printStackTrace();

			}
		
	}

	

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
