package PageClasses;
//here page is module

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPageClass 
{
	@FindBy(xpath="(//a[starts-with(text(),' Logout')])[2]")
	WebElement ObjLogout;
	//method for logout
	public void Logout() 
	{
		ObjLogout.click();
	}
	

}
