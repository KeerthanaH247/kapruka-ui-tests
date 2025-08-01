package stepDefinition;

import org.openqa.selenium.WebDriver;


import com.factory.Driverfactory;
import com.pages.HomePage;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

	WebDriver driver =Driverfactory.getDriver();
	HomePage homePage=new HomePage(driver);
	LoginPage loginPage=new LoginPage(driver);
	private void initPages() {
		driver=Driverfactory.getDriver();
		homePage=new HomePage(driver);
		loginPage=new LoginPage(driver);
	}
	
@Given("User is on the Homepage")
public void user_is_on_the_homepage() {
	initPages();
	homePage.homepage_validation();
  }
@When("User clicks on Profile icon")
public void user_clicks_on_profile_icon() {
	homePage.profileIconClick();
}
@Then("User should be able to directed to Login page")
public void user_should_be_able_to_directed_to_login_page() {
homePage.loginpage_validation();
}

@Given("User is on Login page")
public void user_is_on_login_page() {
	initPages();
	homePage.profileIconClick();
	homePage.loginpage_validation();
}
@When("User clicks on Create Account button user will be navigated to Account creation Page")
public void user_clicks_on_create_account_button_user_will_be_navigated_to_account_creation_page() {
   loginPage.create_account();
}
@When("User enters {string} , {string}, {string}, {string} and {string}")
public void user_enters_and(String firstname, String lastname, String email, String password, String confirmPassowrd) {
 if(firstname.isEmpty() && lastname.isEmpty() && email.isEmpty() && password.isEmpty() && confirmPassowrd.isEmpty())
 {
	loginPage.create_account_with_no_credentials();
 }
 else if(!password.equals(confirmPassowrd))
 {
 loginPage.create_account_with_mismatched_password(firstname, lastname, email, password, confirmPassowrd);
 }
 else if(password.equals(confirmPassowrd))
 {
 loginPage.create_account_with_matched_password(firstname, lastname, email, password, confirmPassowrd);
}
}
@Then("Clicks on Create account buuton")
public void clicks_on_create_account_buuton() {

}


@When("User enters {string}, {string}")
public void user_enters(String email, String password) {
	homePage.profileIconClick();
 loginPage.login_account(email, password); 
}
@Then("User will be redirected to homepage")
public void user_will_be_redirected_to_homepage() {
System.out.println(driver.getTitle());  
}




}
