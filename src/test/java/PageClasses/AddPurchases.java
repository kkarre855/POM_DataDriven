package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddPurchases 
{
WebDriver driver;
public AddPurchases(WebDriver driver) 
{
	this.driver=driver;
}

@FindBy(xpath = "(//a[starts-with(text(),'Purchases')])[3]")
WebElement clickpurchase;
@FindBy(xpath = "(//span[@data-caption='Add'])[1]")
WebElement clickAddpurchaseIcon;
@FindBy(name = "x_Purchase_Number")
WebElement PurchaseNumber;
@FindBy(xpath = "//button[@class='btn btn-default btn-sm']")
WebElement PurchaseDate;
@FindBy(xpath="//table[@cellpadding='0']/tbody/tr/td[starts-with(text(),'25')]")
WebElement Selectdate;
@FindBy(name = "x_Supplier_ID")
WebElement SupplierID;
@FindBy(xpath="//span/select[@name='x_Supplier_ID']/option[3]")
WebElement Selectsupplierid;

@FindBy(name = "x_Notes")
WebElement Notes;
@FindBy(name = "x_Total_Amount")
WebElement TotalAmount;
@FindBy(name = "x_Total_Payment")
WebElement TotalPayment;
@FindBy(name = "x_Total_Balance")
WebElement TotalBalance;
@FindBy(name = "btnAction")
WebElement clickAddpurchase;
@FindBy(xpath = "//button[normalize-space()='OK!']")
WebElement clickconformOk;
@FindBy(xpath = "(//button[starts-with(text(),'OK')])[6]")
WebElement clickAlertOk;
//search
@FindBy(xpath = "//span[@data-caption='Search']")
WebElement clicksearchpanel;
@FindBy(xpath = "//input[@id='psearch']")
WebElement EntersearchBox;
@FindBy(xpath = "//button[@id='btnsubmit']")
WebElement clicksearchButton;
@FindBy(xpath="//table[@class='table ewTable']/tbody/tr/td[5]/div/span/span")
WebElement Webtable;
@FindBy(xpath="//table[@class='table ewTable']/tbody/tr/td[10]/div/span/span")
WebElement Tbalance;

//writing method
public boolean add_purchase(String notes,String tamount,String tpayment) throws Throwable
{
	this.clickpurchase.click();
	this.clickAddpurchaseIcon.click();
	String Exp_data=this.PurchaseNumber.getAttribute("value");
	this.PurchaseDate.click();
	this.Selectdate.click();
	this.SupplierID.click();
	this.Selectsupplierid.click();
	this.Notes.sendKeys(notes);
	this.TotalAmount.sendKeys(tamount);
	this.TotalPayment.sendKeys(tpayment);
	String pbalance=this.TotalBalance.getAttribute("value");
	this.clickAddpurchase.click();
	Thread.sleep(2000);
	this.clickconformOk.click();
	Thread.sleep(2000);
	this.clickAlertOk.click();
	Thread.sleep(2000);
	
	if (!this.EntersearchBox.isDisplayed())
		this.clicksearchpanel.click();
	this.EntersearchBox.clear();
	this.EntersearchBox.sendKeys(Exp_data);
	String Act_data=Webtable.getText();
	String Act_amount=Tbalance.getText();
	if (Exp_data.equals(Act_data)) 
	{
		Reporter.log("Pruches number matching::"+Exp_data+" "+Act_data,true);
		Reporter.log("Total balance matching::"+pbalance+" "+Act_amount,true);
		return true;
	} else {
		Reporter.log("Pruches number not matching::"+Exp_data+" "+Act_data,true);
		Reporter.log("Total balance not matching::"+pbalance+" "+Act_amount,true);
		return false;
	}
	
    



}
}
