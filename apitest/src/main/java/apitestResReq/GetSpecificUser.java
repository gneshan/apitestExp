package apitestResReq;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetSpecificUser extends BaseClass{
	
	
	@Test(priority=1)
	public void getUsers() {
		Response responseBody = given().basePath("/users/7")
				.when()//.queryParam("page", "2")
				.get()
				.then()//.assertThat().statusCode(200);
				.extract().response();
		
		String prettyString=responseBody.getBody().asPrettyString();
		int status=responseBody.getStatusCode();
		Assert.assertEquals(status, 200);
		

}
}