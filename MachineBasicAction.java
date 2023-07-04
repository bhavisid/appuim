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

public class MachineBasicAction extends BaseClass2 {
	AndroidDriver driver ;
	Actions touchAction;
	Properties prop;
	
	public  ExtentReports extent;
	public  ExtentTest test;
	
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
	WebElement fedBack;
	
	//
	
	
	
    
	@BeforeSuite
    public void extentReport() {
	
	ExtentHtmlReporter reporter = new ExtentHtmlReporter("results2.html");
    extent = new ExtentReports();
	extent.attachReporter(reporter);
	
    
	
	}
	
	@BeforeTest
	public  void desiredCapability() throws MalformedURLException {
		
		//ExtentTest test = extent.createTest("desiredcapability", "passing desired sucessfull");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.1.2");
		capabilities.setCapability("deviceName", "192.168.137.15:9898");
		capabilities.setCapability("appPackage", "com.jpvendtech.vms");
		capabilities.setCapability("appActivity", "com.jpvendtech.vms.MainActivity");
		capabilities.setCapability("systemPort", "8200");
		//capabilities.setCapability("skipDeviceInitialization", false);
		//capabilities.setCapability("autoLaunch", false);
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		 driver = new AndroidDriver(url,capabilities);
		 
		 
			WebElement time = driver.findElement(By.className("android.widget.TextView"));
			String time1 = time.getText();
			System.out.println(time1);
			System.out.println("date success");
			WebElement date = driver.findElement(By.className("android.widget.TextView"));
			String date1 = date.getText();
			System.out.println(date1);
			//test.log(Status.INFO, "Desired capabilities sucessfull, Date and time capture sucessfull");
		
		
		

	}
	@Test(priority = 1,enabled = true)
	
	public void userlogin() throws IOException {
		ExtentTest test = extent.createTest("user login", "login depending on user successfull ");
		test.assignCategory("SuperAdmin");
	    prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\riota\\Downloads\\UiAuto\\UiAuto\\src\\main\\java\\Machine\\UiAuto\\config.properties");
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
	
@Test(priority = 2,enabled = true)	
public void machineLogin() {
		
		//login credentials--need to set at config.properties
		//this.driver.findElement(By.id("com.jpvendtech.vms:id/emailEditText")).sendKeys("projects@vi.com");
		//this.driver.findElement(By.id("com.jpvendtech.vms:id/passwordEditText")).sendKeys( "riota@CHN40");
		//this.driver.findElement(By.id("com.jpvendtech.vms:id/adminLoginBtn")).click();
		//this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//server selection UAT
		ExtentTest test = extent.createTest("Machine Login", "Server update and Machine login");
		test.assignCategory("SuperAdmin");
		driver.findElement(By.id("com.jpvendtech.vms:id/serverEditText")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//android.widget.ImageButton[@content-desc=\"Show drop-down menu\"])[1]")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/machineModelEditText")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/serverConnectButton")).click();
		
			
		
		
		//passing machineid--need to set at config.properties
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.cardview.widget.CardView[4]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")).sendKeys("2VE0018614");
		driver.findElement(By.id("com.jpvendtech.vms:id/loginMachineBtn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}

@Test(priority = 3,enabled = true)
public void adminPanelCheck() {
	
	ExtentTest test = extent.createTest("Admin panel", "Admin panel sub module check ");
	test.assignCategory("SuperAdmin");
	
		//machine basic settings
	try {
		String machBasicSett = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/"
				  +
				  "android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget."
				  +
				  "LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.widget.LinearLayout/android.widget.TextView";
	    machBasicSettings = driver.findElement(By.xpath(machBasicSett));
		machBasicSettings.click();
		String fedBack1 = "com.jpvendtech.vms:id/fabBack";
	    fedBack = driver.findElement(By.id(fedBack1));
		fedBack.click();
		test.log(Status.PASS, "Machine basic settings viewed successfully");
	}catch (Exception e) {
		test.log(Status.FAIL, "Not directed to Machine basic settings ");
		test.log(Status.FAIL, "Reason for failure : "+e);
	}
		
		
		//manage machine slots
	try {
		String manageMachSlot ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[2]/android.widget.LinearLayout/android.widget.TextView";
	    manageMachSlots = driver.findElement(By.xpath(manageMachSlot));
		manageMachSlots.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		fedBack.click();
		/*driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget."
				  +
				  "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android."
				  +
				  "widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[2]/android.widget.LinearLayout/android.widget.TextView")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();*/
		test.log(Status.PASS, "Manage machine slots viewed successfully");
	}catch (Exception e) {
		test.log(Status.FAIL, "Not directed to manage machine slots");
		test.log(Status.FAIL, "Reason for failure : "+e);
	}
		//vmc hardware settings
	try {
		String vmcHwSetting = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[3]/android.widget.LinearLayout/android.widget.TextView";
	    vmcHwSettings = driver.findElement(By.xpath(vmcHwSetting));
		vmcHwSettings.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		fedBack.click();
		/* driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget."
				  +
				  "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget."
				  +
				  "LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[3]/android.widget.LinearLayout/android.widget.TextView")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();*/
		test.log(Status.PASS, "Vmc hardware settings viewed successfully");
	}catch (Exception e) {
		test.log(Status.FAIL, "Not directed to vmc hardware settings");
		test.log(Status.FAIL, "Reason for failure : "+e);
	}
		//user access mgmnt
	try {
		String userAccessMgmn = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[4]/android.widget.LinearLayout/android.widget.TextView";
		userAccessMgmnt = driver.findElement(By.xpath(userAccessMgmn));
		userAccessMgmnt.click();
		fedBack.click();
		/*driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget."
				  +
				  "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget."
				  +
				  "LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[4]/android.widget.LinearLayout/android.widget.TextView")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();*/
		test.log(Status.PASS, "User access mgmnt viewed successfully");
	}catch (Exception e) {
		test.log(Status.FAIL, "Not directed to user access mgmnt");
		test.log(Status.FAIL, "Reason for failure : "+e);
	}
		//payment setup
	try {
		String payment = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[5]/android.widget.LinearLayout/android.widget.TextView";
		paymentSetup = driver.findElement(By.xpath(payment));
		paymentSetup.click();
		fedBack.click();
		/*driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget."
				  +
				  "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget."
				  +
				  "LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[5]/android.widget.LinearLayout/android.widget.TextView" )).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();*/
		test.log(Status.PASS, "Payment setup viewed successfully");
	}catch (Exception e) {
		test.log(Status.FAIL, "Not directed to payment setup");
		test.log(Status.FAIL, "Reason for failure : "+e);
	}
		//transaction settings
	try {
		String transSetting = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[6]/android.widget.LinearLayout/android.widget.TextView";
		transactionSettings = driver.findElement(By.xpath(transSetting));
		transactionSettings.click();
		fedBack.click();
		/*driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget."
				  +
				  "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx."
				  +
				  "recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[6]/android.widget.LinearLayout/android.widget.TextView")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();*/
		test.log(Status.PASS, "Transaction settings viewed successfully");
	}catch (Exception e) {
		test.log(Status.FAIL, "Not directed to transaction settings");
		test.log(Status.FAIL, "Reason for failure : "+e);
	}
		//maintenance history
	try {
		String maintenaceHistroy = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[7]/android.widget.LinearLayout/android.widget.TextView";
		maintenanceHistroy = driver.findElement(By.xpath(maintenaceHistroy));
		maintenanceHistroy.click();
		fedBack.click();
		/*driver.findElement(By.xpath( "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
				  +
				  "/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget."
				  +
				  "RecyclerView/androidx.cardview.widget.CardView[7]/android.widget.LinearLayout/android.widget.TextView")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();*/
		test.log(Status.PASS, "Maintenance history viewed successfully");
	}catch (Exception e) {
		test.log(Status.FAIL, "Not directed to maintenance history");
		test.log(Status.FAIL, "Reason for failure : "+e);
	}
		//ads&screen saver 
	try {
		String adsScreen = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[8]/android.widget.LinearLayout/android.widget.TextView";
		adsScreenSettings = driver.findElement(By.xpath(adsScreen));
		adsScreenSettings.click();
		fedBack.click();
		/*driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/"
				  +
				  "androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[8]/android.widget.LinearLayout/android.widget.TextView" )).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();*/
		test.log(Status.PASS, "Ads&screen saver viewed successfully");
	}catch (Exception e) {
		test.log(Status.FAIL, "Not directed to ads&screen saver ");
		test.log(Status.FAIL, "Reason for failure : "+e);
	}
		//miscellaneous settings
	try {
		String miscelSetting = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[9]/android.widget.LinearLayout/android.widget.TextView";
		miscellaneousSettings = driver.findElement(By.xpath(miscelSetting));
		miscellaneousSettings.click();
		fedBack.click();
		/*driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/"
				  +
				  "android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[9]/android.widget.LinearLayout/android.widget.TextView")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();*/
		test.log(Status.PASS, "Miscellaneous settings viewed successfully");
	}catch (Exception e) {
		test.log(Status.FAIL, "Not directed to miscellaneous settings ");
		test.log(Status.FAIL, "Reason for failure : "+e);
	}
		//app settings
	try {
		String appSetting = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[10]/android.widget.LinearLayout/android.widget.TextView";
		appSettings = driver.findElement(By.xpath(appSetting));
		appSettings.click();
		fedBack.click();
		/*driver.findElement(By.xpath( "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/"
				  +
				  "android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[10]/android.widget.LinearLayout/android.widget.TextView" )).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();*/
		test.log(Status.PASS, "App settings viewed successfully");
	}catch (Exception e) {
		test.log(Status.FAIL, "Not directed to app settings ");
		test.log(Status.FAIL, "Reason for failure : "+e);
	}
		//app status
	try {
		String AppStatus = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[11]/android.widget.LinearLayout/android.widget.TextView";
		appStatus = driver.findElement(By.xpath(AppStatus));
		appStatus.click();
		
		/*driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/"
				  +
				  "android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[11]/android.widget.LinearLayout/android.widget.TextView")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();*/
		test.log(Status.PASS, "App status viewed successfully");
	}
		catch (Exception e) {
			test.log(Status.FAIL, "Not directed to app status ");
			test.log(Status.FAIL, "Reason for failure : "+e);
		}
			
		test.log(Status.INFO, "Server and Admin panel sub module check succesfull");
		fedBack.click();
	}


@Test(priority = 4,enabled = true)
public void executionSuccessfull(){
	

	System.out.println("Execution successfull");
	

}
@Test(priority = 5,enabled = true)
public void AppStatus() {
	
ExtentTest test = extent.createTest("App status", "App status details capture");

try {
	 appStatus.click();
		/*driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/"
				  +
				  "android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[11]/android.widget.LinearLayout/android.widget.TextView")).click();*/
		
		WebElement status = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup"
				+ "/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.TextView"));
		System.out.println("App status page opened sucessfully : " +status.getText() );
		
	    WebElement machineStatus = driver.findElement(By.id("com.jpvendtech.vms:id/machineStatusUpdateTextView" ));
		System.out.println( "Machine status : " +machineStatus.getText());
		
	    WebElement serialNo = driver.findElement(By.id("com.jpvendtech.vms:id/machineSerialNumberTextView" ));
	    System.out.println(  "SerialNo : " +serialNo.getText());
	    
		WebElement cloudStatus = driver.findElement(By.id("com.jpvendtech.vms:id/cloudConnectionStatusTextView" ));
		System.out.println("cloud status : " +cloudStatus.getText());
		
		WebElement serverType = driver.findElement(By.id("com.jpvendtech.vms:id/cloudServerTextView" ));
		System.out.println("Server type : " +serverType.getText());
		
		WebElement envtype = driver.findElement(By.id("com.jpvendtech.vms:id/cloudEnvironmentTextView" ));
		System.out.println( "Envinorment type : " +envtype.getText());
		
		WebElement machid = driver.findElement(By.id("com.jpvendtech.vms:id/cloudMachineIdTextView" ));
		System.out.println( "Machine Id : " +machid.getText());
		
		WebElement machinfo = driver.findElement(By.id("com.jpvendtech.vms:id/cloudMachineDetailsTextView" ));
		System.out.println( "Additional machine information : " +machinfo.getText()                );
		
		WebElement Fw = driver.findElement(By.id("com.jpvendtech.vms:id/connectedVmcBoardsTextView" ));
		System.out.println( "Vmc Board Firmware version : " +Fw.getText());
		
		WebElement appversion = driver.findElement(By.id("com.jpvendtech.vms:id/appVersionTextView" ));
		System.out.println("VMS App version : "  +appversion.getText());
		
		WebElement buildtype = driver.findElement(By.id("com.jpvendtech.vms:id/appBuildTextView" ));
		System.out.println( "VMS Build Type : "  +buildtype.getText());
	
} catch (Exception e) {
	test.log(Status.FAIL, "App status details haven't captured - unsuccessful");
	test.log(Status.FAIL, "Reason for failure" + e);
}
  
	
	//Vmc log export using MiXplorer
	/*try {
		
		driver.findElement(By.id("com.jpvendtech.vms:id/exportUsbCommLogBtn")).click();
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Download Jun 1, 17:14\"]")).click();
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Pick\"]\r\n"
				+ "")).click();
		
	}catch (Exception e) {
		test.log(Status.FAIL, "Vmc log not available");
		test.log(Status.FAIL, "Reason for failure" +e);
	}*/
	//vmc logs mail
	
	/*WebElement vlog = driver.findElement(By.id("com.jpvendtech.vms:id/mailUsbCommLogBtn"));
	if (vlog.isDisplayed()) {
		vlog.isEnabled();
		test.log(Status.PASS, "vmc log mailed successfully - please check the mail");
	}else {
		test.log(Status.FAIL, "Vmc log unavailable - please enable vmc log to file toggle");
	}*/
	//vmc log capture through mail
	try {
		fedBack.click();
	//driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
		vmcHwSettings.click();
	//driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[3]/android.widget.LinearLayout/android.widget.TextView")).click();
	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.cardview.widget.CardView[5]/android.widget.LinearLayout/androidx.cardview.widget.CardView[3]/android.view.ViewGroup/android.widget.Switch")).click();
	test.log(Status.PASS, "Vmc log enabled seccessfully");
	fedBack.click();
	}catch (Exception e) {
		test.log(Status.FAIL, "Vmc log enable - unseccessfull!!!");
		test.log(Status.FAIL, "Reason for failure" + e);
	}
	//Enabling cloud api's
	try {
		appSettings.click();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[3]/android.widget.LinearLayout/android.widget.TextView")).click();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.Switch")).click();
		test.log(Status.PASS, "Cloud log enabled seccessfully");
		fedBack.click();
		
	} catch (Exception e) {
		test.log(Status.FAIL, "Cloud log enable - unseccessfull!!!");
		test.log(Status.FAIL, "Reason for failure" + e);
	}
	
	//Enabling ble api's
	try {
		driver.findElement(By.xpath("	\r\n"
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.widget.LinearLayout/android.widget.TextView")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/touchLessSolutionsEnabledToggle")).click();
		WebElement touchLess = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.cardview.widget.CardView[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.widget.LinearLayout/android.widget.TextView"));
		touchAction = new Actions(driver);
		touchAction.clickAndHold(touchLess).perform();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/androidx.cardview.widget.CardView[2]/android.widget.LinearLayout/androidx.cardview.widget.CardView[3]/android.view.ViewGroup/android.widget.Switch")).click();
		
		driver.findElement(By.id("com.jpvendtech.vms:id/updateBtn")).click();
		test.log(Status.PASS, "Ble log enabled seccessfully");
		
	} catch (Exception e) {
		test.log(Status.FAIL, "Ble log enable - unseccessfull!!!");
		test.log(Status.FAIL, "Reason for failure" + e);
	}
	
	
	try {
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
		//fedBack.click();
		
		
		driver.findElement(By.id("android:id/button1")).click();
		//WebElement cs_btn2 = driver.findElement(By.id("com.jpvendtech.vms:id/bottomNavBtn2"));
		//touchAction.clickAndHold(cs_btn2).perform();
		
		//WebElement cs_btn3 = driver.findElement(By.id("com.jpvendtech.vms:id/customerSupportTextView"));
		//touchAction.clickAndHold(cs_btn3).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//passing credentials
		driver.findElement(By.id("com.jpvendtech.vms:id/emailEditText")).sendKeys(prop.getProperty("sadminusername"));
		driver.findElement(By.id("com.jpvendtech.vms:id/passwordEditText")).sendKeys(prop.getProperty("sadminpassword"));
		driver.findElement(By.id("com.jpvendtech.vms:id/adminLoginBtn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[11]/android.widget.LinearLayout/android.widget.TextView")).click();
		//appStatus.click();
		// Mailing vmc,cloud&ble
		driver.findElement(By.id("com.jpvendtech.vms:id/mailUsbCommLogBtn")).click();
		test.log(Status.PASS, "Vmc log mailed seccessfully");
		driver.findElement(By.id("com.jpvendtech.vms:id/mailCloudCommLogBtn")).click();
		test.log(Status.PASS, "Cloud log mailed seccessfully");
		driver.findElement(By.id("com.jpvendtech.vms:id/mailBleCommLogBtn")).click();
		test.log(Status.PASS, "Ble log mailed seccessfully");
		
	} catch (Exception e) {
		test.log(Status.FAIL, "Logs haven't mailed - unseccessfull!!!");
		test.log(Status.FAIL, "Reason for failure" + e);
	}
	
	
	
	fedBack.click();
}		
			
	
	

@Test(priority = 6,enabled = true)
public void machineBasicSettings(){
	ExtentTest test = extent.createTest("Machine basic settings", "Machine basic settings module capture");
	
	try {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		machBasicSettings.click();
		Thread.sleep(5000);
		driver.findElement(By.id("com.jpvendtech.vms:id/enableMachineToggle")).click();
		//Thread.sleep(5000);
		//driver.findElement(By.id("com.jpvendtech.vms:id/enableMachineToggle")).click();
		test.log(Status.PASS, "Machine been disabled & enabled successfully");
		
	} catch (Exception e) {
		test.log(Status.FAIL, "Machine enable disabled & enabled - unsuccessfull!!!" );
		test.log(Status.FAIL, "Reason for failure" +e);
	}
	try {
		driver.findElement(By.id("com.jpvendtech.vms:id/cloudSyncToggle")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("com.jpvendtech.vms:id/cloudSyncToggle")).click();
		test.log(Status.PASS, "Cloud sync disabled & enabled successfully");
		
	} catch (Exception e) {
		test.log(Status.FAIL, "Cloud sync disabled & enabled - unsuccessfull!!!" );
		test.log(Status.FAIL, "Reason for failure" +e);
	}
	
	try {
		driver.findElement(By.id("com.jpvendtech.vms:id/machineLocationEditText1")).sendKeys(prop.getProperty("PlusCode"));
		driver.findElement(By.id("com.jpvendtech.vms:id/machineLocationEditText2")).sendKeys(prop.getProperty("City"));
		driver.findElement(By.id("com.jpvendtech.vms:id/machineLocationEditText3")).sendKeys(prop.getProperty("State"));
		driver.findElement(By.id("com.jpvendtech.vms:id/saveMachineLocationDetailsBtn")).click();
		test.log(Status.PASS, "Location updated successfully");
	} catch (Exception e) {
		test.log(Status.FAIL, "Location updated unsuccessfully");
		test.log(Status.INFO, "Reason for failure" +e);
	}
	fedBack.click();
	
	
	
	
}
@Test(priority = 7,enabled = true)
public void uesrAccessMgmnt() {

	ExtentTest test = extent.createTest("User access management", "User access management module capture");
	
	try {
		userAccessMgmnt.click();
		driver.findElement(By.id("com.jpvendtech.vms:id/enableUserAuthToggle")).click();
		test.log(Status.PASS, "User Auth Enabled sucessfully");
		
	} catch (Exception e) {
		test.log(Status.FAIL, "User Auth Enable unsucessfully");
		test.log(Status.FAIL, "Reason for failure" +e);
	}
	//Adding user
	try {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("com.jpvendtech.vms:id/manageUsersBtn")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/addUserBtn")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/usernameEdit")).sendKeys(prop.getProperty("EmployeeName"));
		driver.findElement(By.id("com.jpvendtech.vms:id/companyIdEdit")).sendKeys(prop.getProperty("EmployeeId"));
		driver.findElement(By.id("com.jpvendtech.vms:id/accessIdEdit")).sendKeys(prop.getProperty("AccessId"));
		driver.findElement(By.id("com.jpvendtech.vms:id/saveUserBtn")).click();
		test.log(Status.PASS, "User added sucessfully");
		
	} catch (Exception e) {
		test.log(Status.FAIL, "User haven't added - unsucessfully");
		test.log(Status.FAIL, "Reason for failure" +e);
	}
	
	//sEARCH USER
	try {
		driver.findElement(By.id("com.jpvendtech.vms:id/searchUsersBtn")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/searchUsersEditText")).sendKeys(prop.getProperty("EmployeeName"));
		test.log(Status.PASS, "User search sucessfully");
		
	} catch (Exception e) {
		test.log(Status.FAIL, "User haven't added - unsucessfully");
		test.log(Status.FAIL, "Reason for failure" +e);
	}
	
	//block user
	
	try {
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.TableLayout[1]/android.widget.TableRow/android.widget.LinearLayout/android.widget.Button\r\n"
				+ "")).click();
	    Thread.sleep(1500);
	    test.log(Status.PASS, "User block sucessfully");
	} catch(InterruptedException e) {
	    System.out.println("got interrupted!");
	    test.log(Status.FAIL, "User block - unsucessfully!");
		test.log(Status.FAIL, "Reason for failure" +e);
	   
	}
	//unblock user
	try {
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.TableLayout[1]/android.widget.TableRow/android.widget.LinearLayout/android.widget.Button\r\n"
				+ "")).click();
		
		test.log(Status.PASS, "User unblock sucessfully");
		
	} catch (Exception e) {
		test.log(Status.FAIL, "User unblock - unsucessfully!");
		test.log(Status.FAIL, "Reason for failure" +e);
	}
	
	//Deletion of user
	try {
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.TableLayout[1]/android.widget.TableRow/android.widget.TextView[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement userDeletetion = driver.findElement(By.id("com.jpvendtech.vms:id/deleteUserBtn"));
		touchAction.clickAndHold(userDeletetion).perform();
	//	driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
	//	driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
	//	fedBack.click();
	//	fedBack.click();
		test.log(Status.PASS, "User deletion sucessfully");	
		
	} catch (Exception e) {
		test.log(Status.FAIL, "User haven't deleted - unsucessfull!");
		test.log(Status.FAIL, "Reason for failure" +e);
	}
	
	
	driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
	driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
	
	
	
	

}

@Test(priority = 8,enabled = true)
public void misceleneous() {
	ExtentTest test = extent.createTest("misceleneous", "misceleneous module capture");
	
	try {
		miscellaneousSettings.click();
		driver.findElement(By.id("com.jpvendtech.vms:id/enterSystemSettingsBtn")).click();
		test.log(Status.PASS, "System settings opened sucessfully");
	} catch (Exception e) {
		test.log(Status.FAIL, "System settings haven't opened - unsucessfully!!");
		test.log(Status.FAIL, "Reason for failure" +e);
	}
	try {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.cardview.widget.CardView[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button")).click();
		driver.findElement(By.id("android:id/button_once")).click();
		test.log(Status.PASS, "File manager opened sucessfully");
	} catch (Exception e) {
		test.log(Status.FAIL, "File manager haven't opened - unsucessfull!!");
		test.log(Status.FAIL, "Reason for failure" +e);
	}
	try {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("com.jpvendtech.vms:id/customerSupportUpdateBtn")).click();
	
		//passing address
		driver.findElement(By.id("com.jpvendtech.vms:id/addressEditText")).sendKeys(prop.getProperty("Address"));
		driver.findElement(By.id("com.jpvendtech.vms:id/emailIDEditText")).sendKeys(prop.getProperty("EmailId"));
		driver.findElement(By.id("com.jpvendtech.vms:id/phoneNoEditText")).sendKeys(prop.getProperty("PhoneNumaber"));
		driver.findElement(By.id("com.jpvendtech.vms:id/whatsappNoEditText")).sendKeys(prop.getProperty("WhatsappNumber"));
		driver.findElement(By.id("android:id/button1")).click();
		test.log(Status.PASS, "Customer support updated sucessfully");
		//driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
		//fedBack.click();
		
		
		//driver.findElement(By.id("com.jpvendtech.vms:id/addressEditText")).sendKeys("SF NO.16/13,Kaveri nagar,Velappanchavadi,Chennai - 600077");
		//driver.findElement(By.id("com.jpvendtech.vms:id/emailIDEditText")).sendKeys(null);
		
	} catch (Exception e) {
		test.log(Status.FAIL, "Customer support update haven't done - unsucessfull!!");
		test.log(Status.FAIL, "Reason for failure" + e);
	} 
	//transaction history page size
	try {
		driver.findElement(By.id("com.jpvendtech.vms:id/transactionHistoryPageSizeEdit")).sendKeys(prop.getProperty("TransactionPageSize"));
        test.log(Status.PASS, "Transaction page size changed sucessfully");
		fedBack.click();
		
		} catch (Exception e) {
			test.log(Status.FAIL, "Transaction page size changed haven't done - unsucessfull!!");
			test.log(Status.FAIL, "Reason for failure" + e);
		}
		
		try {
			transactionSettings.click();
			driver.findElement(By.id("com.jpvendtech.vms:id/transactionsHistoryBtn")).click();
			test.log(Status.PASS, "Transaction page size updated according to change sucessfully");
			Thread.sleep(2000);
			fedBack.click();
			
		} catch (Exception e) {
			test.log(Status.FAIL, "Transaction page size haven't updated - unsucessfull!!");
			test.log(Status.FAIL, "Reason for failure" + e);
			fedBack.click();
		}
		
	
	driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
	
	
	
	
	
	
	
	
	
	
	

}
@Test(priority = 9,enabled = true)
public void appSettings() {

	ExtentTest test = extent.createTest("App Settings", "App settings module capture");
	test.assignCategory("SuperAdmin");
	appSettings.click();
	//Company logo change
	try {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[4]/android.widget.LinearLayout/android.widget.TextView")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/companyLogoImageView")).click();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.ImageView")).click();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.TextView")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement logo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView"));
		logo.sendKeys(prop.getProperty("CompanyLogo"));
		
		
		
		//driver.findElement(By.id("android:id/empty")).sendKeys("D:\\Riota\\Auto_Images\\vendolite.jpg");
		//WebElement logo = driver.findElement(By.id("com.estrongs.android.pop:id/grid_view"));
		
		
		// logo.sendKeys("D:\\Riota\\Auto_Images\\vendolite.jpg");
		
		//logo.sendKeys(prop.getProperty("CompanyLogo"));
		test.log(Status.PASS, "Company logo saved  sucessfully");
	} catch (Exception e) {
		test.log(Status.FAIL, "Company logo haven't saved - unsucessfull!!");
		test.log(Status.FAIL, "Reason for failure" +e);
	}
	
	//notification
	try {
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[5]/android.widget.LinearLayout/android.widget.TextView")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/emailNotificationsEnabledToggle")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("com.jpvendtech.vms:id/emailNotificationsEnabledToggle")).click();
		test.log(Status.PASS, "Email notification disabled and enabled sucessfully");
		
		
	} catch (Exception e) {
		test.log(Status.FAIL, "Email notification disabled and enabled - unsucessfull!!");
		test.log(Status.FAIL, "Reason for failure" + e);
	}
	//new mailid save
	try {
		driver.findElement(By.id("com.jpvendtech.vms:id/editClientEmailAccountBtn")).click();
		WebElement mail = driver.findElement(By.id("com.jpvendtech.vms:id/clientEmailEditText"));
		mail.sendKeys(prop.getProperty("ClientEmailId"));
		driver.findElement(By.id("com.jpvendtech.vms:id/editClientEmailAccountBtn")).click();
		test.log(Status.PASS, "New mailId saved sucessfully");
		
	} catch (Exception e) {
		test.log(Status.FAIL, "New mailId haven't saved - unsucessfull!!");
		test.log(Status.FAIL, "Reason for failure" + e);
	}
	//test mail check
	try {
		driver.findElement(By.id("com.jpvendtech.vms:id/testMailBtn")).click();
		test.log(Status.PASS, "Test mail send sucessfully");
	} catch (Exception e) {
		test.log(Status.FAIL, "Test mail haven't send - unsucessfull!!");
		test.log(Status.FAIL, "Reason for failure" + e);
	}
	
	//sms notification
	try {
		driver.findElement(By.id("com.jpvendtech.vms:id/smsNotificationsEnabledToggle")).click();
		test.log(Status.PASS, "Sms notification enabled sucessfully");
	} catch (Exception e) {
		test.log(Status.FAIL, "Sms notification enable - unsucessfull!!");
		test.log(Status.FAIL, "Reason for failure" + e);
	}
	try {
		driver.findElement(By.id("com.jpvendtech.vms:id/editClientMobileNumberBtn")).click();
		WebElement mobileNo = driver.findElement(By.id("com.jpvendtech.vms:id/clientMobileNumberEditText"));
		mobileNo.sendKeys(prop.getProperty("MobileNo"));
		driver.findElement(By.id("com.jpvendtech.vms:id/editClientMobileNumberBtn")).click();
		test.log(Status.PASS, "New client mobile number been saved sucessfully");
		
	} catch (Exception e) {
		test.log(Status.FAIL, "New mobile number saved - unsucessfull!!");
		test.log(Status.FAIL, "Reason for failure" + e);
	}
	try {
		driver.findElement(By.id("com.jpvendtech.vms:id/testSmsBtn")).click();
		test.log(Status.PASS, "Test sms send sucessfully");
		
	} catch (Exception e) {
		test.log(Status.FAIL, "Test sms haven't send - unsucessfull!!");
		test.log(Status.FAIL, "Reason for failure" + e);
	}
	
	/*try {
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[4]/android.widget.LinearLayout/android.widget.TextView")).click();
		WebElement logo = driver.findElement(By.id("com.jpvendtech.vms:id/companyLogoImageView"));
		logo.sendKeys(prop.getProperty("CompanyLogo"));
		test.log(Status.PASS, "Company logo changed sucessfully");
		
	} catch (Exception e) {
		test.log(Status.FAIL, "Company logo haven't changed - unsuccessful!!!");
		test.log(Status.FAIL, "Reason for failure" + e);
	}*/
	
	
	
	fedBack.click();
	fedBack.click();
	
}

//payments setup
@Test(enabled = false)
public void PaymentsSetup() {
	

}

//Transactions Settings
@Test(enabled = false)
public void TransactionsSettings() {
	// TODO Auto-generated method stub

}

//Maintenance History
@Test(enabled = false)
public void MaintenanceHistory() {
	// TODO Auto-generated method stub

}

//AdsandScreen Saver
@Test(enabled = false)
public void AdsandScreenSaver() {
	// TODO Auto-generated method stub

}

//Manage machine Slots
@Test(enabled = false)
public void ManageSlots() {
	// TODO Auto-generated method stub

}

//vmc Hardware Settings
@Test(enabled = false)
public void HardwareSettings() {
	// TODO Auto-generated method stub

}




@AfterSuite
public void tearDown() {
	
	extent.flush();
}
}


