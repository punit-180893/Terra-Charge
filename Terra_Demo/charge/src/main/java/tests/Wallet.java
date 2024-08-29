package tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

import BasePages.Common;
import BasePages.LoginPage;
import Utilities.ReadingPropertiesFile;

public class Wallet extends BasePages.MainPage {
	
	@Test
	public void WalletTest() throws InterruptedException {
		// Test logic specific to login
        System.out.println("Executing login test logic");
        
//      Locate the email field and send data
		driver.findElement(LoginPage.profile_btn).click();
		driver.findElement(LoginPage.password_btn).click();
		
//   	Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(LoginPage.contact_field).sendKeys(ReadingPropertiesFile.getProperty("contactNumber"));
        driver.findElement(LoginPage.password_field).sendKeys(ReadingPropertiesFile.getProperty("password"));
        driver.findElement(LoginPage.login_btn).click();
        
//      Click on wallet button
        driver.findElement(Common.wallet_btn).click();
        
        driver.findElement(Common.addMoney_btn).click();


	}

}
