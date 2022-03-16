package apitestResReq;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;

public class BaseClass {
	
	Logger logger=Logger.getLogger("Test");
	

	Properties properties = new Properties();
		
	@BeforeTest
	public void setup() throws IOException {
		
		FileInputStream fileinput;
		try {
			fileinput = new FileInputStream("config.properties");
			properties.load(fileinput);
			String baseuri = properties.getProperty("baseURL");
			PropertyConfigurator.configure("./log4j.properties");
			logger.setLevel(Level.INFO);
			RestAssured.baseURI=baseuri;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
