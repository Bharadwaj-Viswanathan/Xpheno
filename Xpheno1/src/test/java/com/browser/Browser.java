package com.browser;

import java.io.IOException;
import java.util.Properties;

import org.junit.AfterClass;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.ExtentReport.ExtentReport;
import com.configure.config;
import com.tests.BaseClass;
import com.tests.Search;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

    private static WebDriver driver;

	public static SoftAssert Softassert;
	public static Capabilities capabilities;
	static String BrowserName;
	static String BrowserVersion;
	public static Properties prop;
	

	@BeforeSuite
	public static void BeforeLaunchingbrowser() throws IOException {
		config.Getdatafrompropertiesfile();
		ExtentReport.extent.setSystemInfo("URL",prop.getProperty("URL"));

		ExtentReport.extent.setSystemInfo("Username",prop.getProperty("UN"));
		ExtentReport.extent.setSystemInfo("Password",prop.getProperty("PW"));
		Softassert=new SoftAssert();
	}
	@Parameters("Browser")
	@BeforeMethod
	public static void LaunchBrowser(String Browser){

		if(Browser.equalsIgnoreCase("Chrome")) {
			System.out.println("Browser Chrome");
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
			capabilities=((RemoteWebDriver)driver).getCapabilities();
			BrowserName = capabilities.getBrowserName();
			BrowserVersion = capabilities.getBrowserVersion();
			DriverManager.setDriver(driver);
		}else if(Browser.equalsIgnoreCase("Firefox")) {
	
			driver=new FirefoxDriver();
			capabilities=((RemoteWebDriver)driver).getCapabilities();
			BrowserName = capabilities.getBrowserName();
			BrowserVersion = capabilities.getBrowserVersion();
			DriverManager.setDriver(driver);
		}else if(Browser.equalsIgnoreCase("Edge")) {
			
			driver=new EdgeDriver();
			capabilities=((RemoteWebDriver)driver).getCapabilities();
			BrowserName = capabilities.getBrowserName();
			BrowserVersion = capabilities.getBrowserVersion();
			DriverManager.setDriver(driver);
		}else {
			System.out.println("Browser not matched");
		}
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().get(prop.getProperty("URL"));
		
		BaseClass.implictwait(30);
	}
	/**
	 * Close the Browser
	 * @throws IOException 
	 */
	@AfterMethod	
	public void CloseBrowser() throws IOException {
		
		DriverManager.getDriver().quit();
		DriverManager.unload();
		Softassert.assertAll();
	}
	/*
	 * @AfterClass private void Endsuite() { Browserinfo(); }
	 */

	public static void Browserinfo() {
		ExtentReport.extent.setSystemInfo("Browser Name",BrowserName);
		ExtentReport.extent.setSystemInfo("Browser Version",BrowserVersion);
	}
}
