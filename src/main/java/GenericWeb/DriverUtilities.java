package GenericWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import groovyjarjarantlr4.v4.codegen.model.Action;

public class DriverUtilities {

	public void mouseHover(WebDriver driver,WebElement element) {
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	public void scroll(WebDriver driver,WebElement element) {
		Actions actions=new Actions(driver);
		actions.scrollToElement(element).perform();;
	}
}
