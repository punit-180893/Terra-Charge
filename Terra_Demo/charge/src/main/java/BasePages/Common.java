package BasePages;

import org.openqa.selenium.By;


public class Common {
	
	//Main Page- Clicking on Confirmation Pop-up.
	public static By confirmation_btn = By.xpath("//button[contains(text(), 'I Confirm, I want To Continue With Web App.')]");
	
	//OTPVerify Page
	public static By phoneNumberField = By.xpath("//input[@id=':r4:']");
	public static By continue_btn = By.xpath("//button[contains(text(), 'continue')]");
	public static By otp_field    = By.xpath("//div[@style='display: flex; justify-content: center;']//input[@type='tel']");
	
    //Wallet Test
	public static By wallet_btn = By.xpath("//*[contains(text(),'Wallet')]");
	public static By addMoney_btn = By.xpath("//button[contains(., '+ Add Money')]");

}
