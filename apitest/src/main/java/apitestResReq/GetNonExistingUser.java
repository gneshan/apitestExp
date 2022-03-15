package apitestResReq;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetNonExistingUser {
	
	@BeforeTest
	public void setup() {
		
		RestAssured.baseURI="https://reqres.in/api";
		RestAssured.basePath="/users/23";
		
	}
	
	@Test(priority=1)
	public void getUsers() {
		ValidatableResponse responseBody = given()
				.when()//.queryParam("page", "2")
				.get()
				.then().assertThat().statusCode(404);
				//.statusCode(200).log().all().extract().response();
		
		//String prettyString=responseBody.getBody().asPrettyString();
		
	}
}
