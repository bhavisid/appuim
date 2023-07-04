package Machine.UiAuto;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;

public class BaseClass2 {
	
	public  static ExtentReports extent;
	//public  ExtentTest test;
    public static AndroidDriver driver;
    
    public  Actions touchAction;
	public  Properties prop;
	
	
	@BeforeSuite
	public void extentReport() {
	
	ExtentHtmlReporter reporter = new ExtentHtmlReporter("results2.html");
    extent = new ExtentReports();
	extent.attachReporter(reporter);
    
	
	}
	@BeforeTest
	public  void desiredCapability() throws MalformedURLException {
		
		ExtentTest test = extent.createTest("desiredcapability", "passing desired sucessfull");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.1.2");
		capabilities.setCapability("deviceName", "192.168.1.33:9898");
		capabilities.setCapability("appPackage", "com.jpvendtech.vms");
		capabilities.setCapability("appActivity", "com.jpvendtech.vms.MainActivity");
		capabilities.setCapability("systemPort", "8200");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		 driver = new AndroidDriver(url,capabilities);
		 
		 
			WebElement time = driver.findElement(By.className("android.widget.TextView"));
			String time1 = time.getText();
			System.out.println(time1);
			System.out.println("date success");
			WebElement date = driver.findElement(By.className("android.widget.TextView"));
			String date1 = date.getText();
			System.out.println(date1);
			test.log(Status.INFO, "Desired capabilities sucessfull, Date and time capture sucessfull");
		
		
		

	}
	
	
	
	
	
	
	
	
	@AfterSuite
	public void tearDown() {
		
		extent.flush();
	}

}
