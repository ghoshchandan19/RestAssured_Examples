package RestAsssuredExamples1;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.InputStream;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class Customer_API {
    
	@Test
	public void Create_Customer() {
		
	Response response=	given().auth().basic("sk_test_XPbhuUljR0FL1uTrfqagOIcP","")
		.formParam("email","mukesh@yahoo.com").formParam("description","test")
		.post("https://api.stripe.com/v1/customers").then().extract().response();
	
	//System.out.println(response.asString());
	System.out.println(response.getStatusCode());
	Assert.assertEquals(200, response.getStatusCode());

	}
	@Test
	public void retrieveCustomer()
	{
		Response response=	given().auth().basic("sk_test_XPbhuUljR0FL1uTrfqagOIcP", "")
				.get("https://api.stripe.com/v1/customers/cus_Deh4WGSQ7fMM1U").then().extract().response();
		System.out.println("----------------------------------------------------------");
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
	}
	/*
	@Test
	public void delete_Customer(){
	Response response=	given().auth().basic("sk_test_XPbhuUljR0FL1uTrfqagOIcP", "")
		.delete("https://api.stripe.com/v1/customers/cus_Degq0TfEVwAaeZ").then().extract().response();
	System.out.println("----------------------------------------------------------");
	System.out.println(response.asString());
	System.out.println(response.getStatusCode());
		
	}
	*/
	
	
	

}
