package Machine.UiAuto;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class UserAccessManagement24 extends MachineBasicAction2{
	

@Test
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

}
