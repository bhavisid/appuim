package Machine.UiAuto;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;

public class MachineBasicAction2 extends BaseClass2 {
	//AndroidDriver driver ;
	
	
	//public  ExtentReports extent;
	//public  ExtentTest test;
	
	//Admin panel path
	WebElement machBasicSettings;
	WebElement manageMachSlots;
	WebElement vmcHwSettings;
	WebElement userAccessMgmnt;
	WebElement paymentSetup;
	WebElement transactionSettings;
	WebElement maintenanceHistroy;
	WebElement adsScreenSettings;
	WebElement miscellaneousSettings;
	WebElement appSettings;
	WebElement appStatus;
	static WebElement fedBack;
	
	//
	
	
	
   
	
	
		
		

	
	@Test(priority = 1)
	public void userlogin() throws IOException {
		ExtentTest test = extent.createTest("user login", "login depending on user successfull ");
		test.assignCategory("SuperAdmin");
	    prop = new Properties();
		FileInputStream ip = new FileInputStream("D:\\Riota\\Softwares\\Eclipse_workspace\\Work_space\\UiAuto\\src\\main\\java\\Machine\\UiAuto\\config.properties");
		prop.load(ip);
		String Usertype = prop.getProperty("usertype");
		//driver = new AndroidDriver(S1,S2);
		
		if (Usertype.equals("superadmin")) {
			driver.findElement(By.id("com.jpvendtech.vms:id/emailEditText")).sendKeys(prop.getProperty("sadminusername"));
			driver.findElement(By.id("com.jpvendtech.vms:id/passwordEditText")).sendKeys(prop.getProperty("sadminpassword"));
			driver.findElement(By.id("com.jpvendtech.vms:id/adminLoginBtn")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}
		else if (Usertype.equals("admin")) {
			driver.findElement(By.id("com.jpvendtech.vms:id/emailEditText")).sendKeys(prop.getProperty("adminusername"));
			driver.findElement(By.id("com.jpvendtech.vms:id/passwordEditText")).sendKeys(prop.getProperty("adminpassword"));
			driver.findElement(By.id("com.jpvendtech.vms:id/adminLoginBtn")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
			else if (Usertype.equals("refiller")) {
				driver.findElement(By.id("com.jpvendtech.vms:id/emailEditText")).sendKeys(prop.getProperty("userusername"));
				driver.findElement(By.id("com.jpvendtech.vms:id/passwordEditText")).sendKeys(prop.getProperty("userpassword"));
				driver.findElement(By.id("com.jpvendtech.vms:id/adminLoginBtn")).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				 } else {
			System.out.println("Userlogin unsuccesful");

		}
	
		   test.log(Status.INFO, "Login page successful");
	}
	
@Test(priority = 2)
public void machineLogin() {
		
		//login credentials--need to set at config.properties
		//this.driver.findElement(By.id("com.jpvendtech.vms:id/emailEditText")).sendKeys("projects@vi.com");
		//this.driver.findElement(By.id("com.jpvendtech.vms:id/passwordEditText")).sendKeys( "riota@CHN40");
		//this.driver.findElement(By.id("com.jpvendtech.vms:id/adminLoginBtn")).click();
		//this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//server selection UAT
	    ExtentTest test = extent.createTest("Machine Login", "Server update and Machine login");
	    test.assignCategory("SuperAdmin");
	try {
		
		driver.findElement(By.id("com.jpvendtech.vms:id/serverEditText")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//android.widget.ImageButton[@content-desc=\"Show drop-down menu\"])[1]")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/machineModelEditText")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/serverConnectButton")).click();
		test.log(Status.PASS, "Server updated successfully");
		
	} catch (Exception e) {
		
		test.log(Status.FAIL, "Server haven't updated - unsuccessfully!!!");
		test.log(Status.FAIL, "Reason for failure : " + e);
	
	}
		
		
			
		
		
		//passing machineid--need to set at config.properties
	try {
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.cardview.widget.CardView[4]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")).sendKeys("2VE0018614");
		driver.findElement(By.id("com.jpvendtech.vms:id/loginMachineBtn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		test.log(Status.PASS, "MachineId login successful");
		
	} catch (Exception e) {
		test.log(Status.FAIL, "Login - unsuccessfull!!!");
		test.log(Status.FAIL, "Reason for failure : " + e);
	}
		
		
		
		
}





			
	
	


}







