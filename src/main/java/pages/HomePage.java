package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

	
    @FindBy(linkText = "Sign up")
	private WebElement signUpLink;
	
	
	public HomePage(WebDriver driver) {
		
		super(driver);
	}
	
	
	public void clickOnSignUp() {
		
		
		clickElement(signUpLink);
	}
}
