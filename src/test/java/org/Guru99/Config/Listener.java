package org.Guru99.Config;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class Listener implements ITestListener,ISuiteListener {

	protected static WebDriver driver;
	 protected static ExtentReports reports;
	 protected static ExtentTest test;
	
	
	String filePath = "E:\\SCREENSHOTS\\";
	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stubSystem.out.println("on test start");
		 
		
	}

	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult Result) {
		// TODO Auto-generated method stub
		System.out.println("***** Error "+Result.getName()+" test has failed *****");
		test.log(LogStatus.FAIL, Result.getMethod().getMethodName() + "test is failed");
    	String methodName=Result.getName().toString().trim();
    	takeScreenShot(methodName);
    	test.log(LogStatus.FAIL, Result.getMethod().getMethodName() + "test is failed", filePath);
    	   test.log(LogStatus.FAIL, Result.getMethod().getMethodName() + "test is failed", Result.getThrowable().getMessage());

		//System.out.println("The name of the testcase failed is :"+Result.getName());
		
	}
	public void takeScreenShot(String methodName) {
    	//get the driver
    	//Config.driver=TestBase.getDriver();
    	 File scrFile = ((TakesScreenshot)Config.driver).getScreenshotAs(OutputType.FILE);
    	 
         //The below method will save the screen shot in d drive with test method name 
            try {
				FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
				
				System.out.println("***Placed screen shot in "+filePath+" ***");
				
			} catch (IOException e) {
				e.printStackTrace();
			}}

	public void onTestSkipped(ITestResult Result) {
		// TODO Auto-generated method stub
		 System.out.println("The name of the testcase Skipped is :"+Result.getName());
		 test.log(LogStatus.SKIP, Result.getMethod().getMethodName() + "test is skipped");
		
	}

	public void onTestStart(ITestResult Result) {
		// TODO Auto-generated method stub
		//System.out.println(Result.getName()+" test case started");
		System.out.println("on test start");
		  test = reports.startTest(Result.getMethod().getMethodName());
		  test.log(LogStatus.INFO, Result.getMethod().getMethodName() + "test is started");
		
	}

	public void onTestSuccess(ITestResult Result) {
		// TODO Auto-generated method stub
		//System.out.println("The name of the testcase success is :"+Result.getName());
		System.out.println("on test success");
		  test.log(LogStatus.PASS, Result.getMethod().getMethodName() + "test is passed");
		
	}

	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub
		 System.out.println("on finish");
		 // driver.close();
		  reports.endTest(test);
		  reports.flush();
		
	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		System.out.println("on start");
		  //driver = new ChromeDriver(); // Set the drivers path in environment variables to avoid code(System.setProperty())
		  reports = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
		
	}

}
