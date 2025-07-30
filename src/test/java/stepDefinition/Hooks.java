package stepDefinition;

import org.openqa.selenium.WebDriver;

import com.base.TestBase;
import com.factory.Driverfactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	WebDriver driver;
	com.factory.Driverfactory df;
	
	@Before
	public void setup()
	{
		TestBase base =new TestBase();
		base.loadConfig();
		String browser= base.getProperty("browser");
		String url = base.getProperty("url");
		
		Driverfactory df=new Driverfactory();
		df.init_browser(browser);
		Driverfactory.getDriver().get(url);
	}
	
	@After
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
}
