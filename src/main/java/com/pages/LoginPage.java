package com.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.AlertUtils;

public class LoginPage {

	WebDriver driver;
	String alertUtilsText;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	AlertUtils alertUtils=new AlertUtils(driver);
	
	@FindBy(xpath = "//button[normalize-space()='Create Account']")
	WebElement createAccount;
	
	@FindBy(name = "firstName")
	WebElement firstname;
	
	@FindBy(name = "lastName")
	WebElement lastname;
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(name = "passwordReConfirm")
	WebElement confirmPassword;
	
	@FindBy(id = "exampleInputEmail1")
	WebElement loginEmail;
	
	@FindBy(xpath = "exampleInputPassword1")
	WebElement loginPassword;
	
	@FindBy(name = "Login")
	WebElement loginButton;
	
	public void create_account()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		createAccount.click();
		System.out.println("Title of Create Account page "+driver.getTitle());
	}
	
	public void create_account_with_no_credentials() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		createAccount.click();
		alertUtilsText=alertUtils.handleAlert();
		}
	
	public void create_account_with_mismatched_password(String fname, String lname, String emailid, String pswd, String confirmPswd) {
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		email.sendKeys(emailid);
		password.sendKeys(pswd);
		confirmPassword.sendKeys(confirmPswd);
		createAccount.click();
		alertUtilsText=alertUtils.handleAlert();
	}
	
	public void create_account_with_matched_password(String fname, String lname, String emailid, String pswd, String confirmPswd) {
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		email.sendKeys(emailid);
		password.sendKeys(pswd);
		confirmPassword.sendKeys(confirmPswd);
		createAccount.click();
	}
	
	
	public void login_account(String mailid, String pswd) {
		
		loginEmail.sendKeys(mailid);
		loginPassword.sendKeys(pswd);
		loginButton.click();
	}
}
