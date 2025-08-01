package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utils.AlertUtils;

public class LoginPage {

	WebDriver driver;
	String alertUtilsText;
	HomePage homePage;
	AlertUtils alertUtils;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		homePage=new HomePage(driver);
		alertUtils=new AlertUtils(driver);
	}
	
	
	
	private By createAccount= By.xpath("//button[normalize-space()='Create Account']");
	
	private By firstname=By.name ("firstName");
	
	private By lastname=By.name( "lastName");
	
	private By email=By.name("email");
	
	private By password=By.name( "password");
	
	private By confirmPassword=By.name("passwordReConfirm");
	
	private By loginEmail=By.id("exampleInputEmail1");
	
	private By loginPassword=By.id("exampleInputPassword1");
	
	private By loginButton=By.name("Login");
	
	private By deleteAccount=By.xpath("//div/div[normalize-space()='Delete Account']");
	
	private By deleteEmail=By.id("email");
	private By deletePassword=By.id("password");
	private By deleteMyAccount=By.xpath("//input[@name='Submit']");
	
	public void create_account()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(createAccount).click();
		System.out.println("Title of Create Account page "+driver.getTitle());
	}
	
	public void create_account_with_no_credentials() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(createAccount).click();
		alertUtilsText=alertUtils.handleAlert();
		}
	
	public void create_account_with_mismatched_password(String fname, String lname, String emailid, String pswd, String confirmPswd) {
		
		homePage.profileIconClick();
		create_account();
		driver.findElement(firstname).sendKeys(fname);
		driver.findElement(lastname).sendKeys(lname);
		driver.findElement(email).sendKeys(emailid);
		driver.findElement(password).sendKeys(pswd);
		driver.findElement(confirmPassword).sendKeys(confirmPswd);
		driver.findElement(createAccount).click();
		alertUtils.handleAlert();
	}
	
	public void create_account_with_matched_password(String fname, String lname, String emailid, String pswd, String confirmPswd) {
		homePage.profileIconClick();
		create_account();
		driver.findElement(firstname).sendKeys(fname);
		driver.findElement(lastname).sendKeys(lname);
		driver.findElement(email).sendKeys(emailid);
		driver.findElement(password).sendKeys(pswd);
		driver.findElement(confirmPassword).sendKeys(confirmPswd);
		driver.findElement(createAccount).click();
//		homePage.profileIconClick();
//		driver.findElement(deleteAccount).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.findElement(deleteEmail).sendKeys(emailid);
//		driver.findElement(deletePassword).sendKeys(pswd);
//		driver.findElement(deleteMyAccount).click();
		}
	
	
	public void login_account(String mailid, String pswd) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		homePage.profileIconClick();
		driver.findElement(loginEmail).sendKeys(mailid);
		driver.findElement(loginPassword).sendKeys(pswd);
		driver.findElement(loginButton).click();
	}
}
