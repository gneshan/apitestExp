package apitestResReq;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetSpecificUser extends BaseClass{
	
	
	@Test(priority=1)
	public void getUsers() {
		logger.info("*****This is the test for getting specific user*****");
		Response responseBody = given().basePath("/users/7")
				.when()//.queryParam("page", "2")
				.get()
				.then()//.assertThat().statusCode(200);
				.extract().response();
		
		String prettyString=responseBody.getBody().asPrettyString();
		int status=responseBody.getStatusCode();
		Assert.assertEquals(status, 200);
		logger.info("The Status Code is "+status);
		logger.info("*****Getting specific user test case ended*****");
		

}
}