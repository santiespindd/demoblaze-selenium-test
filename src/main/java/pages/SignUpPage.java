package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SignUpPage extends BasePage {
	
	@FindBy(xpath="//input[@id='sign-username']")
	private WebElement inputTextUsername;
	
	@FindBy(xpath="//input[@id='sign-password']")
	private WebElement inputTextPassword;
	
	
	@FindBy(xpath = "//button[contains(text(),'Sign up')]")
	private WebElement BtnSignUp;
	
	@FindBy(xpath="//body/div[@id='signInModal']/div[1]/div[1]/div[3]/button[1]")
	private WebElement BtnClose;
	
	
	
	
	
	public SignUpPage(WebDriver driver) {
		
		super(driver);
		
	}
	
	
	public void signUp(String user, String pass) {
		
		sendText(inputTextUsername, user);
		sendText(inputTextPassword, pass);
		
		clickElement(BtnSignUp);
		
		
	}
	
	public void enterUsername(String user) {
		
		sendText(inputTextUsername, user);
	
		
	}
	
	public void enterPassword(String pass) {
		
		sendText(inputTextPassword, pass);
		
	}
	
	public void clickOnBtnSignUp() {
		
		clickElement(BtnSignUp);
	}
	
	public void clickOnClose() {
		
		clickElement(BtnClose);
	}
}
