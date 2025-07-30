package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;
	public Properties init_prop() throws IOException
	{
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream(".\\src\\main\\java\\com\\util\\ConfigReader.java");
			prop.load(fis);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
e.printStackTrace();
		}
		return prop;
	}
	
}
