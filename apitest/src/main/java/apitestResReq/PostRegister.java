package apitestResReq;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class PostRegister extends BaseClass{

	JSONObject request = new JSONObject();

	@DataProvider(name = "datafromexcel")
	public String[][] get_prog_data() throws IOException {
		String path = "./Data.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colnum = XLUtils.getCellCount(path, "Sheet1", 1);
		String progdata[][] = new String[rownum][colnum];
		for (int i = 1; i <= rownum; i++) 
		{
			for (int j = 0; j < colnum; j++) 
			{
				if((XLUtils.getCellData(path, "Sheet1", i, j)==null))
				{
					progdata[i - 1][j]="";

				}else {
					progdata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
				}
			}
		}
		return progdata;
	}
	
//	@DataProvider(name = "datafromexcelresponse")
//	public String[][] get_response_data() throws IOException {
//		String path = "./Data.xlsx";
//		int rownum = XLUtils.getRowCount(path, "Sheet2");
//		int colnum = XLUtils.getCellCount(path, "Sheet2", 1);
//		String progdata[][] = new String[rownum][colnum];
//		for (int i = 1; i <= rownum; i++) 
//		{
//			for (int j = 2; j < colnum; j++) 
//			{
//				if((XLUtils.getCellData(path, "Sheet2", i, j)==null))
//				{
//					progdata[i - 1][j]="";
//
//				}else {
//					progdata[i - 1][j] = XLUtils.getCellData(path, "Sheet2", i, j);
//				}
//			}
//		}
//		return progdata;
//	}

	@Test(dataProvider = "datafromexcel")
	public void getUsers(String Email, String Password) {

		if(!Email.equals(null) && !Password.equals(null)) {
			request.put("email", Email);
			request.put("password", Password);
		}
		else if ((!Email.equals(null)) && (Password.equals(null)))

		{
			request.put("email", Email);
			request.put("password", "");
		}else if ((Email.equals(null)) && (!Password.equals(null))) {

			request.put("email", "");
			request.put("password", Password);
		}else if ((Email.equals(null)) && (Password.equals(null)))
		{
			request.put("email", "");
			request.put("password", "");

		}
		Response response = given().header("Content-Type", "application/json")
				.body(request.toJSONString()).basePath("/register")
				.when()//.queryParam("page", "2")
				.post()
				.then()//.assertThat().statusCode(StatusCode)
				.log().all().extract().response();

//		int status=response.getStatusCode();
//		Assert.assertEquals(status, StatusCode);
//
//		String prettyString=response.getBody().asPrettyString();
//
//		if(status==200 && (ID !=null)){
//
//			AssertJUnit.assertEquals(prettyString.contains(ID), true);
//			AssertJUnit.assertEquals(prettyString.contains(token), true);
//
//		}else if(status==400 && (ID == null)) {
//
//			Assert.assertEquals(prettyString.contains(token), true);
//		}

//		else if(status==400){
//
//			Assert.assertEquals(prettyString.contains(token), true);
//		}
	}	

}
