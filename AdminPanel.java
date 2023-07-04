package Machine.UiAuto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import io.appium.java_client.android.AndroidDriver;

public class AdminPanel {
	
	AndroidDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	
	
	

	
	
	
	//@BeforeTest
	//public void extentReport1() {

	//	DateFormat datetime = new SimpleDateFormat("MMddyyyHHmmss");		
	//	String filename = "./reports/results" + datetime + ".html";
	//	ExtentHtmlReporter reporter = new ExtentHtmlReporter(filename);
	//	reporter.setAppendExisting(true);
	//    extent = new ExtentReports();
	//	extent.attachReporter(reporter);
	 //   test = extent.createTest("AdminPanel", "Admin Panel login");
		
		
		
		
	//}
	
	//public void reportStep(String message,String status) {
	//	if(status.equalsIgnoreCase("pass")){
	//		test.pass(message);
	//	}else if(status.equalsIgnoreCase("fail")){
	//		test.fail(message);
	//		throw new RuntimeException("see  thr report for details");
			
	//	}
		
	//}
	/*@BeforeTest
	public void setUp() {
		
		testName = "AdminPanel";
		testDiscription = "Admin panel logined with existing Id";
		category = "Superadmin";
	}*/
	/*@BeforeTest
	public void StartExtentReport() {
	
	ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/results.html");
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	ExtentTest test = extent.createTest("AdminPanel", "Admin panel login with new machine Id");
	test.assignCategory("Sadmin User");
	System.out.println("Extent Report initiated");
	extent.flush();
	
	}
	/*public void reportStep(String message,String status) {
		if(status.equalsIgnoreCase("pass")){
			test.pass(message);
		}else if(status.equalsIgnoreCase("fail")){
			test.fail(message);
			throw new RuntimeException("see the report for details");
			
			
		}
		
	}*/
	@BeforeSuite
	public void reportSetup() {

	    htmlReporter = new ExtentHtmlReporter("./ExtentReport/results.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	
	}
	
	
	@BeforeTest(alwaysRun = true)
	public  void desiredCapability() throws MalformedURLException {
		ExtentTest test = extent.createTest("captureDateTime", "Date and time capture");
		try {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.1.2");
		capabilities.setCapability("deviceName", "192.168.74.212:9898");
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
			test.log(Status.PASS, "Date and time capture sucessfull");
		
		}
		catch (Exception e) {
			test.log(Status.FAIL, "Date and time not captured - Test failed");
			test.log(Status.FAIL, "Reason for failure " +e);
		}

	}
	
/*	@Test(priority = 1,enabled = true)
	public void captureDateTime() {
		ExtentTest test = extent.createTest("captureDateTime", "Date and time capture");
		WebElement time = driver.findElement(By.className("android.widget.TextView"));
		String time1 = time.getText();
		System.out.println(time1);
		System.out.println("date success");
		WebElement date = driver.findElement(By.className("android.widget.TextView"));
		String date1 = date.getText();
		System.out.println(date1);
		test.log(Status.INFO, "Date and time capture sucessfull");

		
	}*/
	
	@Test(priority = 2,enabled = true)
	public void userlogin() throws IOException {
		ExtentTest test = extent.createTest("Userlogin", "Userlogin Sadmin,admin,user");
		
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("D:\\Riota\\Softwares\\Eclipse_workspace\\Work_space\\UiAuto\\src\\main\\java\\Machine\\UiAuto\\config.properties");
		prop.load(ip);
		String Usertype = prop.getProperty("usertype");
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
			System.out.println("Userlogin succesful");

		}
	
		test.log(Status.INFO, "Login sucessful");   
	}
	@Test(priority = 3,enabled = true)
	public void login() {
		
		//login credentials--need to set at config.properties
		//this.driver.findElement(By.id("com.jpvendtech.vms:id/emailEditText")).sendKeys("projects@vi.com");
		//this.driver.findElement(By.id("com.jpvendtech.vms:id/passwordEditText")).sendKeys( "riota@CHN40");
		//this.driver.findElement(By.id("com.jpvendtech.vms:id/adminLoginBtn")).click();
		//this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//server selection UAT
		try {
		driver.findElement(By.id("com.jpvendtech.vms:id/serverEditText")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//android.widget.ImageButton[@content-desc=\"Show drop-down menu\"])[1]")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/machineModelEditText")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/serverConnectButton")).click();
		reportStep("Server selction successful","pass");
		}catch (Exception e) {
			reportStep("Server selection unsuccessful"+e.getMessage(), "fail");
		}
		
		//passing machineid--need to set at config.properties
		try {
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.cardview.widget.CardView[4]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")).sendKeys("2VE0018614");
		driver.findElement(By.id("com.jpvendtech.vms:id/loginMachineBtn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		reportStep("MachineId passed successful", "pass");
		}catch (Exception e) {
			reportStep("MachineId passed unsuccessful" +e.getMessage(), "fail");
		}
		
		//machine basic settings
		try {
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/"
				  +
				  "android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget."
				  +
				  "LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.widget.LinearLayout/android.widget.TextView")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
		reportStep("Machine basic settings open sucessful", "pass");
		}catch (Exception e) {
			reportStep("Machine basic settings open unsucessful" +e.getMessage(), "fail");
			
		}
		//manage machine slots
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget."
				  +
				  "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android."
				  +
				  "widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[2]/android.widget.LinearLayout/android.widget.TextView")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
		//vmc hardware settings
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget."
				  +
				  "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget."
				  +
				  "LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[3]/android.widget.LinearLayout/android.widget.TextView")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
		//user access mgmnt
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget."
				  +
				  "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget."
				  +
				  "LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[4]/android.widget.LinearLayout/android.widget.TextView")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
		//payment setup
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget."
				  +
				  "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget."
				  +
				  "LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[5]/android.widget.LinearLayout/android.widget.TextView" )).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
		//transaction settings
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget."
				  +
				  "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx."
				  +
				  "recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[6]/android.widget.LinearLayout/android.widget.TextView")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
		//maintenance history
		driver.findElement(By.xpath( "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
				  +
				  "/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget."
				  +
				  "RecyclerView/androidx.cardview.widget.CardView[7]/android.widget.LinearLayout/android.widget.TextView")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
		//ads&screen saver 
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/"
				  +
				  "androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[8]/android.widget.LinearLayout/android.widget.TextView" )).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
		//miscellaneous settings
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/"
				  +
				  "android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[9]/android.widget.LinearLayout/android.widget.TextView")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
		//app settings
		driver.findElement(By.xpath( "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/"
				  +
				  "android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[10]/android.widget.LinearLayout/android.widget.TextView" )).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
		//app status
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/"
				  +
				  "android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[11]/android.widget.LinearLayout/android.widget.TextView")).click();
		driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
			
		
	}
	//app status page data capture
	@Test(priority = 4,enabled = true)
	public void AppStatus() {
		
		
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/"
				  +
				  "android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[11]/android.widget.LinearLayout/android.widget.TextView")).click();
		
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
		
		
		
		
		
		
		
		}
	@Test(priority = 5,enabled = true)
	public void executionSuccessfull(){
		

		System.out.println("Execution successfull");
		

	}
	
	@AfterSuite
	public void EndExtentReport() {
		

		extent.flush();
		System.out.println("Flush successfully");
	}
	/*public static ExtentReports extent =new ExtentReports();

    public static ExtentHtmlReporter htmlReporter;

@BeforeSuite

  public void beforeSuiteSetup() {

    String filepath = System.getProperty("user.dir");

has context menu*/
	
	//@AfterTest
	//public void extentReportStop() {
		
	//	extent.flush();
		
	//}

}
