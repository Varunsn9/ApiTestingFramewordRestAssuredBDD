package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
public class APITESTING {
Connection con=null;
@Test
public void connectiontoDataBase() throws Throwable {
Driver driver=new Driver();	
DriverManager.registerDriver(driver);
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
con.close();

}

}