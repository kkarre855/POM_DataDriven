package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.testng.Reporter;

public class AddCustomerPage {
	
	WebDriver driver;  //to access webDriver methods
	public AddCustomerPage(WebDriver driver) 
	{
		this.driver=driver;        //Invoking webDriver methods in class
	}
//define Repository	for add customer
	@FindBy(xpath="(//a[contains(text(),'Customers')])[2]")
	WebElement ClickCustomerLink;
	@FindBy(xpath="(//span[@data-caption='Add'])[1]")
	WebElement ClickAddIconButton;
	@FindBy(name="x_Customer_Number")
	WebElement CustomerNumber;
	@FindBy(name="x_Customer_Name")
	WebElement CustomerName;
	@FindBy(name="x_Address")
	WebElement Address;
	@FindBy(name="x_City")
	WebElement City;
	@FindBy(name="x_Country")
	WebElement Country;
	@FindBy(name="x_Contact_Person")
	WebElement ContactPerson;
	@FindBy(name="x_Phone_Number")
	WebElement Phonenumber;
	@FindBy(name="x__Email")
	WebElement Email;
	@FindBy(name="x_Mobile_Number")
	WebElement MobileNumber;
	@FindBy(name="x_Notes")
	WebElement Notes;
	@FindBy(id="btnAction")
	WebElement ClickAddButton;
	@FindBy(xpath="//button[normalize-space()='OK!']")
	WebElement ClickConformOk;
	@FindBy(xpath="(//button[starts-with(text(),'OK')])[6]")
	WebElement ClickAlertOk;
	//search locators
	@FindBy(xpath="//span[@data-caption='Search']")
	WebElement ClickSearchPanel;
	@FindBy(xpath="//input[@id='psearch']")
	WebElement EnterSearchTextBox;
	@FindBy(xpath="//button[@id='btnsubmit']")
	WebElement clickSearchButton;
	//to get Actual value
	@FindBy(xpath="//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span") //web table concept
	WebElement Webtable;
	
	//write methods for locators above and mention all the needed arguments
	public boolean add_Customer(String cname,String Address,String city,String Country,String cperson,String pnumber,
			String email,String mnumber,String notes) throws Throwable
	{
		//this.ClickCustomerLink.click();
		//this.ClickAddIconButton.click();
		Actions ac=new Actions(driver); //mouse actions
		ac.moveToElement(ClickCustomerLink).click().perform();
		ac.moveToElement(ClickAddIconButton).click().perform();
		String Exp_Data=this.CustomerNumber.getAttribute("value");//to get runtime property value we use getAttribute
		this.CustomerName.sendKeys(cname);
		this.Address.sendKeys(Address);
		this.City.sendKeys(city);
		this.Country.sendKeys(Country);
		this.ContactPerson.sendKeys(cperson);
		this.Phonenumber.sendKeys(pnumber);
		this.Email.sendKeys(email);
		this.MobileNumber.sendKeys(mnumber);
		this.Notes.sendKeys(notes);
		//this.ClickAddButton.click();
		ac.moveToElement(ClickAddButton).click().perform();
		Thread.sleep(3000);
		this.ClickConformOk.click();
		Thread.sleep(3000);
		this.ClickAlertOk.click();
		if(!this.EnterSearchTextBox.isDisplayed())
			this.ClickSearchPanel.click();
		this.EnterSearchTextBox.clear();
		this.EnterSearchTextBox.sendKeys(Exp_Data);
		//this.clickSearchButton.click();
		ac.moveToElement(this.clickSearchButton).click().perform();
		String Act_data=Webtable.getText();
		//Assert.assertEquals(Exp_Data, Act_data, "Customer Number not matching");//gives message only when fails assert behavior not used for boolean
		if (Exp_Data.equals(Act_data)) 
		{
			Reporter.log("Customer number Matching::"+Exp_Data+" "+Act_data,true);
			return true;
		}
		else 
		{
			
			Reporter.log("Customer number not Matching::"+Exp_Data+" "+Act_data,true);
			return false;
		}
	}
	
	
	








}
