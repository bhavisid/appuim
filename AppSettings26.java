package Machine.UiAuto;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class AppSettings26 extends MachineBasicAction2{

@Test
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
	

}
