package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	 public HomePage(WebDriver driver) {
		 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	 
	By profileIcon=By.xpath("//div[@class='myaccountblock']");
	
	
	public void homepage_validation() {
		System.out.println("Title of the page: "+driver.getTitle());
	}
	
	public void profileIconClick()
	{
		driver.findElement(profileIcon).click();
	}
	
	public LoginPage loginpage_validation() {
		System.out.println("Title of the page: "+driver.getTitle());
		return new LoginPage(driver);
	}
}
