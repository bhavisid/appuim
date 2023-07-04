package Machine.UiAuto;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnExtenttReport{
	
	ExtentHtmlReporter report;	
	ExtentReports extent;
	WebDriver driver;
	
@BeforeSuite	
 public void reportGeneration() throws IOException {
	
	
	System.out.println("Successful");	
    report = new ExtentHtmlReporter("./Report11/resultss.html");
	report.setAppendExisting(true);
    extent = new ExtentReports();
	extent.attachReporter(report);
	ExtentTest test = extent.createTest("AdminPanel", "Execution of adminPanel");
	test.assignCategory("Superadmin User");
	test.pass("step1 pass", MediaEntityBuilder.createScreenCaptureFromPath(".././Snaps/40mm dualSprial.png").build());
	test.pass("step1 pass");
	test.fail("step1 pass");
}
	
	public void chrome() {
		driver.findElement(By.name("username")).sendKeys("tharun");
		
	}
	
	


@AfterSuite
public void tearDown() {
	extent.flush();
	
}
}
