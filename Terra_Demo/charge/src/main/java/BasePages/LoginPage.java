package BasePages;

import org.openqa.selenium.By;

public class LoginPage {
//  Confirmation Pop-Up	
	public static By profile_btn = By.xpath("//a[@href='/my-account']");
	
	public static By password_btn =  By.xpath("//button[contains(text(), 'Password')]");
    public static By contact_field = By.xpath("//input[@id='phone-login']");
    public static By password_field = By.xpath("//input[@id='password-login']");
    public static By login_btn = By.xpath("//button[contains(text(), 'Login')]");
    public static By myAccount = By.xpath("//div[contains(text(),'My Account')]");
    
//  Print name, email, mobile  
    public static By name = By.xpath("//*[contains(text(),'Punit Sharma')]");
    public static By mobile = By.xpath("//*[contains(text(),'9996074014')]");
    public static By email = By.xpath("//*[contains(text(),'punitsharma@terra-charge.co.in')]");


}
