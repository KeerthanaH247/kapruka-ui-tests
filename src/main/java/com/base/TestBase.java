package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public void loadConfig()
	{
		try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream("C:\\Users\\Spoorthi\\Desktop\\JAVA\\com.kapruka\\config\\config.properties");
			prop.load(fis);
			fis.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getProperty(String key) {
		return prop.getProperty(key);
		
	}

}
