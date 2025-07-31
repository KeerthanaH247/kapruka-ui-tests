package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory {

	public static WebDriver driver;	
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static WebDriver init_browser(String browser)
	{
//		System.out.println("Browser="+browser);
	if(driver == null) {
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("internet explorer"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else {
			System.out.println("Enter a valid browser name");
		}
		driver.manage().window().maximize();
		return driver;
	}
	return driver;
	}
	

	public static void quitDriver() {
		if(driver != null)
		{
			driver.quit();
			driver=null;
		}
	}
}
