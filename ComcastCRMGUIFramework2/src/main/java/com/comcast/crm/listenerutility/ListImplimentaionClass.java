package com.comcast.crm.listenerutility;

import java.io.File;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverUtility.UtlityClassObject;
import com.crm.comcast.basetest.BaseClass;

public class ListImplimentaionClass implements ITestListener,ISuiteListener{
	
	public static  ExtentReports report;
	public static ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report Configutation");
		
		//Spark report config
		String time=new Date().toString().replace(" ", "-").replace(":", "_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add env information & create test
		 report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Window-10");
		report.setSystemInfo("BROWSER","CHROME-100");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("======"+result.getMethod().getMethodName()+"======Start=====");
		test=report.createTest(result.getMethod().getMethodName());
		UtlityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"==>started<===");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("========"+result.getMethod().getMethodName()+"========END=====");
		test.log(Status.PASS, result.getMethod().getMethodName()+"==>completed<===");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testName = result.getMethod().getMethodName();
	
		TakesScreenshot ts=(TakesScreenshot)(BaseClass.sdriver);
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		String time=new Date().toString().replace(" ", "-").replace(":", "_");
		
		//File des = new File("./ScreenShot/"+testName+"+"+time+".png");
		test.addScreenCaptureFromBase64String(filepath,testName+"-"+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"==>failure<===");
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.INFO, result.getMethod().getMethodName()+"==>skipped<===");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	

}
	
