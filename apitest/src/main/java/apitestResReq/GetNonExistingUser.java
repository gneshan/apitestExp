package apitestResReq;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetNonExistingUser extends BaseClass{
	

	@Test(priority=1)
	public void getUsers() {
		ValidatableResponse responseBody = given().basePath("/users/23")
				.when()//.queryParam("page", "2")
				.get()
				.then().assertThat().statusCode(404);
				//.statusCode(200).log().all().extract().response();
		
		//String prettyString=responseBody.getBody().asPrettyString();
		
	}
}
