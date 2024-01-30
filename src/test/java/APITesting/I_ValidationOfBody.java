package APITesting;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;
import GenericUtility.ProjectEndpoints;
import ObjRepoAPI.Project;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class I_ValidationOfBody {

	@Test
	public void testingPost() {
		given().baseUri("http://localhost:8084")
		.when().get(ProjectEndpoints.getprojectById+"/TY_PROJ_203")
		.then().assertThat()
		.body("projectId",containsString("TY_PROJ_203"))
		.body("projectName", equalTo("Tst"))
        .body("teamSize", equalTo(0))
        .body("createdBy", equalTo("dattta"))
        .body("createdOn", equalTo("29/08/2023"))
        .body("status", equalTo("open"))
		.statusCode(200).log().all();
	}
	
	@Test
	public void postAndTestProject() {
		
		int number=new Random().nextInt(100);
		Project project=new Project("varun"+number,"var"+number,"comp"+number,2+number);
		given().baseUri("http://localhost:8084").body(project).contentType(ContentType.JSON)
		.when().post(ProjectEndpoints.postProject)
		.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all()
		.and().assertThat()
		.body("createdBy", equalTo(project.createdBy))
		.body("projectName",equalTo(project.projectName))
		.body("status",equalTo(project.status)).log().all();
		
	}
}

