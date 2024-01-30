package WebTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import GenericWeb.DriverUtilities;
import ObjRepo.DashBoardPOM;

public class RedBusBooking {
	String url="https://www.redbus.in";
	WebDriver driver;
	DashBoardPOM dashBoardPOM;
	DriverUtilities driverUtilities;
	@BeforeTest
	public void beforeTest() throws Throwable {
		driverUtilities =new DriverUtilities();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);

	}
	@AfterTest
	public void afterTest() {
		driver.close();
	}

	@Test
	public void placeTest()throws Throwable {
		dashBoardPOM =new DashBoardPOM(driver);
		dashBoardPOM.getFrom().sendKeys("ker");
		int noOfRecommendations=dashBoardPOM.getFromListOfRecommendation().size();
		int count=1;
		for (WebElement element : dashBoardPOM.getFromListOfRecommendation()) {
			if(count<noOfRecommendations) {
				System.out.println(element.getText());
				driverUtilities.mouseHover(driver, element);
				driverUtilities.scroll(driver, element);
				count++;}
			else {
				element.click();
			}
		}	
		dashBoardPOM.getTo().sendKeys("bang");
		Thread.sleep(5000);
		noOfRecommendations=dashBoardPOM.getFromListOfRecommendation().size();
		count=1;
		for (WebElement element : dashBoardPOM.getFromListOfRecommendation()) {
			if(count<noOfRecommendations) {
				System.out.println(element.getText());
				driverUtilities.mouseHover(driver, element);
				driverUtilities.scroll(driver, element);
				count++;}
			else {
				element.click();
			}
		}	
		Thread.sleep(5000);

	}
}
