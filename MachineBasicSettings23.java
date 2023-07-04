package Machine.UiAuto;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MachineBasicSettings23 extends MachineBasicAction2{
	
	@Test
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

}
