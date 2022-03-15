package apitestResReq;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class GetUsers {
	
	@BeforeTest
	public void setup() {
		
		RestAssured.baseURI="https://reqres.in/api";
		RestAssured.basePath="/users";
		
	}
	
	@Test(priority=1)
	public void getUsers() {
		Response responseBody = given()
				.when()//.queryParam("page", "2")
				.get()
				.then()//.assertThat().statusCode(200);
				.statusCode(200).log().all().extract().response();
		
		String prettyString=responseBody.getBody().asPrettyString();
		

}
}