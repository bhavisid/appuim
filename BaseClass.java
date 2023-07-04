package Machine.UiAuto;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	static ExtentReports extent;
	static ExtentTest test;
	public String testName,testDiscription,category;
	
	@BeforeSuite
	public void StartExtentReport() {
	
	ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/results.html");
    extent = new ExtentReports();
	extent.attachReporter(reporter);
    
	
	}
	@BeforeClass
	public void testDetails() {
		test = extent.createTest(testName, testDiscription);
		
		test.assignCategory(category);
		
	}
	public void reportStep(String message,String status) {
		if(status.equalsIgnoreCase("pass")){
			test.pass(message);
		}else if(status.equalsIgnoreCase("fail")){
			test.fail(message);
			throw new RuntimeException("see the report for details");
			
		}
		
	}
	
	
	
	
	
	
	
	
	@AfterSuite
	public void EndExtentReport() {
		
		extent.flush();
	}

}
