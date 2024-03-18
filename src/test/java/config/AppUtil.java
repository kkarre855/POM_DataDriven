package config;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import PageClasses.LoginPageClass;
import PageClasses.LogoutPageClass;

public class AppUtil {
	public static Properties conpro;//to use property file
	public static WebDriver driver;
	@BeforeTest
	public static void setUp() throws Throwable
	{
		conpro=new Properties();
		conpro.load(new FileInputStream("./PropertyFiles/Environment.properties"));
		if (conpro.getProperty("Browser").equalsIgnoreCase("chrome")) 
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(conpro.getProperty("Url"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			LoginPageClass login=PageFactory.initElements(driver, LoginPageClass.class);
			login.adminLogin("admin", "master");
		}
		else if (conpro.getProperty("Browser").equalsIgnoreCase("firefox")) 
		{
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(conpro.getProperty("Url"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			LoginPageClass login=PageFactory.initElements(driver, LoginPageClass.class);
			login.adminLogin("admin", "master");
		}

	}

@AfterTest
public static void teardown()
{
	LogoutPageClass logout=PageFactory.initElements(driver, LogoutPageClass.class);
	logout.Logout();
	driver.quit();

}

}
