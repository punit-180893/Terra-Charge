package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BasePages.LoginPage;
import Utilities.ReadingPropertiesFile;

public class Login extends BasePages.MainPage{
	
	@Test
	public void signIn() throws InterruptedException {
//      Locate the email field and send data
		driver.findElement(LoginPage.profile_btn).click();
		driver.findElement(LoginPage.password_btn).click();
//   	Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(LoginPage.contact_field).sendKeys(ReadingPropertiesFile.getProperty("contactNumber"));
        driver.findElement(LoginPage.password_field).sendKeys(ReadingPropertiesFile.getProperty("password"));
        driver.findElement(LoginPage.login_btn).click();
//      Explicit wait 
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.myAccount));
        
//      Print the name, mobile, and email after login
        String name = driver.findElement(LoginPage.name).getText();
        String mobile = driver.findElement(LoginPage.mobile).getText();
        String email = driver.findElement(LoginPage.email).getText();

        System.out.println("Name: " + name);
        System.out.println("Mobile: " + mobile);
        System.out.println("Email: " + email);

    }

}
