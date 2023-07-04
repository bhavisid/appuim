package Machine.UiAuto;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class AppStatus22  extends MachineBasicAction2{
	
	@Test
	public void AppStatus()  {
		
	ExtentTest test = extent.createTest("App status", "App status details capture");

	try {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
		
		
		//fedBack.click();
		//driver.findElement(By.id("com.jpvendtech.vms:id/fabBack")).click();
	}		

}
