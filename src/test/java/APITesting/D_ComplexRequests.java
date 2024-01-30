package APITesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.protobuf.ByteString.Output;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;
import java.util.Random;

public class D_ComplexRequests {

	String createdBy;
	String projectName;
	String status;
	int teamSize;
	@Test
	public void postingWithHashMap() {
		baseURI="http://localhost:8084";
		port=8084;
		
		HashMap<String, String> hm=new HashMap<String, String>();
		hm.put("createdBy", "varuan12");
		hm.put("projectName", "varVv2");
		hm.put("status", "ongoing");
		hm.put("teamSize","5");
		
		given().contentType(ContentType.JSON).body(hm)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).log().all();
	}
	@Test
	public void postingUsingJSONobject() {
		baseURI = "http://localhost:8084";
		port=8084;
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "varunv1");
		jobj.put("projectName", "huaqwe");
		jobj.put("status", "completed");
		jobj.put("teamSize", "15");
		
		given().contentType(ContentType.JSON).body(jobj)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).log().all();
	}
	@Test
	public void postingUsingJSONFile() {
		baseURI="http://localhost:8084";
		port=8084;
		File file=new File("C:\\Users\\1\\eclipse-workspace\\APITestingFrameWord\\src\\test\\resources\\ApiResources\\jsondata.json");
		given().contentType(ContentType.JSON)
		.body(file).when().post("/addProject")
		.then().assertThat().statusCode(201).log().all();
	}
	@Test
	public void postingUsingPojoClass() {
		
		baseURI="http://localhost";
		port=8084;
		int num=new Random().nextInt(1000);
		String createdBy="varungd"+num;
		String projectName="armaznarhg"+num;
		String status="Ongoing";
		int teamSize=num+1;
	
		F_PojoClass p=new F_PojoClass(createdBy,projectName,status,teamSize);
		given()
		.contentType(ContentType.JSON)
		.body(p)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).log().all();
	}
}
