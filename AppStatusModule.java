package Machine.UiAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;

public class AppStatusModule extends BaseClass2 {
	AndroidDriver driver;
	
	
	
	//Extent report objects
	
	
	@Test(priority = 4)
	public void AppStatus() {
		
	ExtentTest test = extent.createTest("App status", "App status details capture");
		
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
		try {
			driver.findElement(By.id("com.jpvendtech.vms:id/mailUsbCommLogBtn")).click();
		} catch (Exception e) {
			test.log(Status.FAIL, "Vmc log unavailable - please enable vmc log to file toggle");
			test.log(Status.FAIL, "Reason for failure" + e);
			//test.log("Vmc logs mail", "Vmc log unavailable - please enable vmc log to file toggle ");
			
		}
		//cloud logs mail
		try {
			driver.findElement(By.id("com.jpvendtech.vms:id/mailCloudCommLogBtn")).click();
		} catch (Exception e) {
			test.log(Status.FAIL, "Cloud log unavailable - please enable cloud log to file toggle");
			test.log(Status.FAIL, "Reason for failure" + e);
		}
		
		
		
		
		
		
		
		
		
		}

}
