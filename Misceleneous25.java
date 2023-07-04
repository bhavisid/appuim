package Machine.UiAuto;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Misceleneous25 extends MachineBasicAction2{
	
	@Test
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

}
