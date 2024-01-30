package APITesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;
public class G_PostingUsingDataProvider {

	@Test(dataProvider="projects")
	public void postingDataprovider(String createdBy,String projectName,String status,int teamSize) {
		baseURI="http://localhost";
		port=8084;
		F_PojoClass p=new F_PojoClass(createdBy,projectName,status,teamSize);
		given().contentType(ContentType.JSON).body(p)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).log().all();
	}
	
	@DataProvider
	public  Object[][] projects(){
		int a=new Random().nextInt(1000);
		Object[][] proj = new Object[1000][4];
		for(int i=0;i<1000;i++) {
			for(int j=0;j<4;j++) {
				if(j!=3) {
					proj[i][j]="project"+i+""+j+""+a;	
				}else {
					proj[i][j]=a;
				}
			}
		}
		return proj;
	}
}
