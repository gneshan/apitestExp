package apitestResReq;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class GetUsers extends BaseClass {
	
	
	@Test(priority=1)
	public void getUsers() {
		logger.info("*****This is the test for getting all users*****");
		Response responseBody = given().basePath("/users")
				.when()//.queryParam("page", "2")
				.get()
				.then()//.assertThat().statusCode(200);
				.statusCode(200).log().all().extract().response();
		
		int statuscode=responseBody.getStatusCode();
		logger.info("The Status Code is "+statuscode);
		
		String prettyString=responseBody.getBody().asPrettyString();
		logger.info("*****Getting all users test case ended*****");
		

}
}