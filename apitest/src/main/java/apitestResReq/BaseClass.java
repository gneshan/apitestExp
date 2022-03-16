package apitestResReq;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseClass {
	
	@BeforeClass
	public void setup() {
		
		RestAssured.baseURI="https://reqres.in/api";
	}

}
