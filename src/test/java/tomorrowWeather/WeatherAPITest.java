package tomorrowWeather;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class WeatherAPITest {
	@Test
public void getTest() {
	when().get("https://api.tomorrow.io/v4/locations")
	.then().assertThat().statusCode(401).log().all();
}
}
