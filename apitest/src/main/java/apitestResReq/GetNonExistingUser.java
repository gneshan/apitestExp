package apitestResReq;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetNonExistingUser extends BaseClass{
	

	@Test(priority=1)
	public void getUsers() {
		logger.info("*****This is the test for NonExisting user*****");
		Response responseBody = given().basePath("/users/23")
				.when()//.queryParam("page", "2")
				.get()
				.then().assertThat()//.statusCode(404);
				.log().all().extract().response();
		
		int status=responseBody.getStatusCode();
		Assert.assertEquals(status, 404);
		logger.info("The Status Code is "+status);
		
		logger.info("*****The test case for nonExisting user ended*****");
		
		//String prettyString=responseBody.getBody().asPrettyString();
		
	}
}
