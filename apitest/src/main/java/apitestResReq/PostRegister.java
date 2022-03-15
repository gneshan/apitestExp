package apitestResReq;

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

public class PostRegister {

//	{
//	    "email": "eve.holt@reqres.in",
//	    "password": "pistol"
//	}
	
	
	
	@BeforeTest
	public void setup() {
		
		RestAssured.baseURI="https://reqres.in/api";
		RestAssured.basePath="/register";
	
	}
	
	@DataProvider(name = "datafromexcel")
	String[][] get_prog_data() throws IOException {
	String path = "C:\\Users\\206711721\\eclipse-workspace\\apitest\\src\\main\\java\\apitestResReq\\Data.xlsx";
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
				
				}else
	progdata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
	}
	}
	return progdata;
	}
	
	@Test(priority=1,dataProvider = "datafromexcel")
	public void getUsers(String Email, String Password, int StatusCode, String ID, String token) {
		
		JSONObject request = new JSONObject();
		request.put("email", Email);
		request.put("password", Password);
				
		Response response = given().header("Content-Type", "application/json")
				.body(request.toJSONString())
				.when()//.queryParam("page", "2")
				.post()
				.then()
				.log().all().extract().response();
		
		int status=response.getStatusCode();
		Assert.assertEquals(status, StatusCode);
		
		String prettyString=response.getBody().asPrettyString();
		
		if(status==200) {
				
		Assert.assertEquals(prettyString.contains(ID), true);
		Assert.assertEquals(prettyString.contains(token), true);
		
		}else if(status==400){
			
			Assert.assertEquals(prettyString.contains(token), true);
		}
		
		
	
	}	
	
}
