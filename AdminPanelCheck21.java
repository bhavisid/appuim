package Machine.UiAuto;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class AdminPanelCheck21 extends MachineBasicAction2{
	
	@Test
	public void adminPanelCheck() {
		
		ExtentTest test = extent.createTest("Admin panel", "Admin panel sub module check ");
		test.assignCategory("SuperAdmin");
		
			//machine basic settings
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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


}
