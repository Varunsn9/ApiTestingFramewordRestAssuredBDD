package APITesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class A_DataBaseTesting {

	Connection con=null;
	@Test
	public void DbTest() throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		Statement s=con.createStatement();
		String query="Select * from project";
		ResultSet a = s.executeQuery(query);
		while(a.next()) {
			System.out.println(a.getString(4));
		}
		Reporter.log("Database is connected");
		con.close();
		Reporter.log("db connection is closed");
	}
}
