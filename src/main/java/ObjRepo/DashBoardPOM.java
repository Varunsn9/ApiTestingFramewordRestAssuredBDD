package ObjRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPOM {
WebDriver driver;
	
@FindBy(xpath = "//label[.='From']/preceding-sibling::input")
private WebElement from;
@FindBy(xpath="//label[.='To']/preceding-sibling::input")
private WebElement to;

@FindAll({@FindBy(xpath ="//ul[@class='sc-dnqmqq eFEVtU']/child::li/child::div/child::text/preceding-sibling::text"),
			@FindBy(xpath="//ul[@class='sc-dnqmqq eFEVtU']/child::li/child::div/child::text[1]")})
private List<WebElement> fromListOfRecommendation;

@FindBy(xpath="//ul[@class='sc-dnqmqq eFEVtU']/child::li/child::div/child::text[1]")
private List<WebElement> toListOfRecommendation;

public List<WebElement> getToListOfRecommendation() {
	return toListOfRecommendation;
}

public void setToListOfRecommendation(List<WebElement> toListOfRecommendation) {
	this.toListOfRecommendation = toListOfRecommendation;
}
@FindBy(xpath = "//ul[@class='sc-dnqmqq eFEVtU']")
private WebElement fromAndTOSearchRecommendationWindow;

public List<WebElement> getFromListOfRecommendation() {
	return fromListOfRecommendation;
}


public WebElement getTo() {
	return to;
}

public void setTo(WebElement to) {
	this.to = to;
}


public void setListOfRecommendation(List<WebElement> listOfRecommendation) {
	this.fromListOfRecommendation = listOfRecommendation;
}

public DashBoardPOM(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver=driver;
}

public WebElement getFrom() {
	return from;
}
public void setFrom(WebElement element) {
	from=element;
}
}
