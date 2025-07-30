package stepDefinition;

import org.openqa.selenium.WebDriver;

import com.factory.Driverfactory;
import com.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

	WebDriver driver;
	HomePage homePage;
@Given("User is on the Homepage")
public void user_is_on_the_homepage() {
	driver=Driverfactory.driver;
	homePage=new HomePage(driver);
	homePage.profileIconClick();
  }
@When("User clicks on Profile icon")
public void user_clicks_on_profile_icon() {
	System.out.println("Working-1");
  }
@Then("User should be able to directed to Login page")
public void user_should_be_able_to_directed_to_login_page() {
	System.out.println("Working-2");
   }



}
