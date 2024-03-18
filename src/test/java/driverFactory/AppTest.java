package driverFactory;


import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageClasses.AddCustomerPage;
import PageClasses.AddPurchases;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class AppTest extends AppUtil
{
	//String inputpath="./FileInput/TestData.xlsx";
	String inputpath="./FileInput/purchasedata.xlsx";
	String outputpath="./FileOutput/PurchasesResults.xlsx";
	//String outputpath="./FileOutput/PomResults.xlsx";
	String TestData="customer";
	String Testdata2="purchase";
	ExtentReports report;
	ExtentTest logger;
/*	@Test
	public void startTest() throws Throwable
	{
		report=new ExtentReports("./target/Reports/customer.html");

		ExcelFileUtil xl=new ExcelFileUtil(inputpath);
		int rc=xl.rowCount(TestData);
		Reporter.log("No of rows are::"+rc,true);
		for (int i = 1; i < rc; i++) 
		{
			logger =report.startTest("Validate customer");
			logger.assignAuthor("Kruthika");
			String customername=xl.getCellData(TestData, i, 0);
			String Address=xl.getCellData(TestData, i, 1);
			String city=xl.getCellData(TestData, i, 2);
			String country=xl.getCellData(TestData, i, 3);
			String cperson=xl.getCellData(TestData, i, 4);
			String pnumber=xl.getCellData(TestData, i, 5);
			String email=xl.getCellData(TestData, i, 6);
			String mnumber=xl.getCellData(TestData, i, 7);
			String notes=xl.getCellData(TestData, i, 8);
			logger.log(LogStatus.INFO, customername+"   "+Address+"  "+ city+"  "+ country+"  "+ cperson+"  "+ pnumber+"  "+ email+"  "+mnumber+"  "+notes);
			AddCustomerPage cus=PageFactory.initElements(driver, AddCustomerPage.class);
			boolean res=cus.add_Customer(customername, Address, city, country, cperson, pnumber, email, mnumber, notes);
			if (res) {

				xl.setCellData(TestData, i, 9, "Pass", outputpath);
				logger.log(LogStatus.PASS,"New customer added" );

			} else {

				xl.setCellData(TestData, i, 9, "Fail", outputpath);
				logger.log(LogStatus.FAIL,"New customer added Failed" );



			}
			report.endTest(logger);
			report.flush(); //to push

		}



	}*/



@Test
public void add_purchase() throws Throwable
{
	report=new ExtentReports("./target/Reports/purchase.html");
	ExcelFileUtil xl=new ExcelFileUtil(inputpath);
	int rc=xl.rowCount(Testdata2);
	Reporter.log("No of rows are::"+rc,true);
	for (int i = 1; i < rc; i++)
	{
		logger=report.startTest("Validate Purchases");
		logger.assignAuthor("Kruthika");
		String notes=xl.getCellData(Testdata2, i, 0);
		String tamount=xl.getCellData(Testdata2, i, 1);
		String tpayment=xl.getCellData(Testdata2, i, 2);
		logger.log(LogStatus.INFO, notes+" "+tamount+" "+tpayment);
		AddPurchases pur=PageFactory.initElements(driver, AddPurchases.class);
		boolean res1=pur.add_purchase(notes, tamount, tpayment);
		if (res1) {
			
			xl.setCellData(Testdata2, i, 3,"Pass" ,outputpath );
			logger.log(LogStatus.PASS,"New purchase added" );
				
		}else
		{
			logger.log(LogStatus.FAIL,"New purchase added Failed" );
		}
		report.endTest(logger);
		report.flush();
	}

}








}

