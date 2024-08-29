package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BasePages.Common;
import BasePages.LoginPage;
import Utilities.ReadingPropertiesFile;

public class OTPVerify extends BasePages.MainPage{
	
	@Test
	public void OtpSignIn() throws InterruptedException {
//      Locate the email field and send data
		driver.findElement(LoginPage.profile_btn).click();
		driver.findElement(Common.phoneNumberField).sendKeys(ReadingPropertiesFile.getProperty("phoneNumber"));
		driver.findElement(Common.continue_btn).click();
		
//      Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//      Explicit wait for OTP elements
        WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed
        WebElement otpInputField = wait.until(ExpectedConditions.presenceOfElementLocated(Common.otp_field));
        
//      Replace with the actual OTP you expect
        String otp = "4050";
        otpInputField.sendKeys(otp);
        WebDriverWait wait1 = new WebDriverWait(driver, 60);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.myAccount));
        

	}

}
