package APITesting;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class F_PojoClass {
	
	public String createdBy;
	public String projectName;
	public String status;
	public int teamSize;
	
	public F_PojoClass() {
		
	}
	public F_PojoClass(String createdBy, String projectName, String status, int teamSize) {
		this.createdBy=createdBy;
		this.projectName=projectName;
		this.status=status;
		this.teamSize=teamSize;
	}/*
		 * 
		 * public String getCreatedBy() { return createdBy; }
		 * 
		 * public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
		 * 
		 * public String getProjectName() { return projectName; }
		 * 
		 * public void setProjectName(String projectName) { this.projectName =
		 * projectName; }
		 * 
		 * public String getStatus() { return status; }
		 * 
		 * public void setStatus(String status) { this.status = status; }
		 * 
		 * public int getTeamSize() { return teamSize; }
		 * 
		 * public void setTeamSize(int teamSize) { this.teamSize = teamSize; }
		 * 
		 */	
}
