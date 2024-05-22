package api.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ListenerUtility implements ITestListener{
ExtentSparkReporter sparkReporter;
ExtentReports reports;
ExtentTest test;
	
	public void onStart(ITestContext context) {
	 sparkReporter=new ExtentSparkReporter("./src/test/resources/ExtentReports/reports.html");
	 sparkReporter.config().setDocumentTitle("API Testing");
	 sparkReporter.config().setReportName("User API report");
	   
	 reports=new ExtentReports();
	 reports.attachReporter(sparkReporter);
	 reports.createTest("API Testing");
	 reports.setSystemInfo("OS",System.getProperty("os.name"));
	 reports.setSystemInfo("User name",System.getProperty("user.name"));
	 reports.setSystemInfo("Envinornment","QA");
	 reports.setSystemInfo("User","Praneeth");
	
	 
	 test=reports.createTest(context.getName());
	 test.info(MarkupHelper.createLabel("Start",ExtentColor.ORANGE));
	 
	  
	}
	
	public void onTestStart(ITestResult result) {
		
		
		test=reports.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.INFO,"Test Start");
		//test.log(Status.INFO,result.getThrowable().getMessage());
		test.info(MarkupHelper.createLabel("TestStart",ExtentColor.PINK));
		
	}

	public void onTestSuccess(ITestResult result) {
		test=reports.createTest(result.getName());
		test.log(Status.PASS,result.getName());
		//test.log(Status.PASS,result.getThrowable().getMessage());
		test.info(MarkupHelper.createLabel("Success",ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		test=reports.createTest(result.getName());
		test.log(Status.FAIL,result.getName());
		//test.log(Status.FAIL,result.getThrowable().getMessage());
		test.info(MarkupHelper.createLabel("Failure",ExtentColor.RED));
	}

	public void onTestSkipped(ITestResult result) {
		test=reports.createTest(result.getName());
		test.log(Status.SKIP,result.getName());
		//test.log(Status.SKIP,result.getThrowable().getMessage());
		test.info(MarkupHelper.createLabel("Skip",ExtentColor.WHITE));
	}
	
	public void onFinish(ITestContext context) {
		test=reports.createTest(context.getName());
		test.log(Status.INFO,context.getName());
		
		reports.flush();
		
		
	}
	
}
