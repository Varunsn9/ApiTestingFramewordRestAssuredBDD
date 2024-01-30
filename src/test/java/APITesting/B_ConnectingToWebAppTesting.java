package APITesting;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class B_ConnectingToWebAppTesting {

	RequestSpecification request;
	ResponseSpecification response;
	
	@Test
	public void APiConnection() {
		request=new RequestSpecBuilder().setBaseUri("http://localhost:8084").setContentType(ContentType.JSON).build();
		response=new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		
	}
}
