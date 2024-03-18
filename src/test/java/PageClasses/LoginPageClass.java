package PageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageClass {
	//define Repository for login
	@FindBy(xpath="//button[@id='btnreset']")
	WebElement ObjReset;
	@FindBy(xpath="//input[@id='username']")
	WebElement Objuser;
	@FindBy(xpath="//input[@id='password']")
	WebElement Objpass;
	@FindBy(xpath="//button[@id='btnsubmit']")
	WebElement ObjLogin; //each element stored into webelement
//method for login
	public void adminLogin(String username,String password) 
{
	ObjReset.click();
	Objuser.sendKeys(username); //pass the arguments you have mentioned
	Objpass.sendKeys(password);
	ObjLogin.click();
}




}





