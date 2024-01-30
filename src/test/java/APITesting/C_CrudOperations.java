package APITesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class C_CrudOperations {

/**
 * get operation us using here to get all the projects	
 */
	@Test
	public void getOperations() {
		
		baseURI="http://localhost:8084";
		port=8084;
		get("/project")
		.then().assertThat().statusCode(400).contentType(ContentType.JSON).log().all();
	}
	@Test
	public void getOperation() {
		baseURI="http://localhost:8084";
		port=8084;
		get("/projects/TY_PROJ_402")
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}
	String projectId;
	
	@Test
	public void postOperation() {
		
		int a=new Random().nextInt(1000);
		
		JSONObject jobj=new JSONObject();
		jobj.put("createdBY", "varun "+a);
		jobj.put("projectName", "armazna "+a);
		jobj.put("status", "completed");
		jobj.put("teamSize", "5");
		
		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log()
		.all();
	}
	@Test
	public void deleteOperation() {
		baseURI="http://localhost";
		port=8084;
		when().delete("/projects/TY_PROJ_405")
		.then()
		.assertThat()
		.statusCode(204)
		.log().all();
	}
	
	@Test
	public void putOPerator() {
		baseURI="http://localhost";
		port=8084;
		
		JSONObject obj=new JSONObject();
		obj.put("createdBy", "var");
		obj.put("projectName","arm");
		obj.put("status", "completed");
		obj.put("teamSize", "3");
		
		given()
		.body(obj)
		.contentType(ContentType.JSON)
		
		.when().put("/projects/TY_PROJ_403")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	
	}
}
