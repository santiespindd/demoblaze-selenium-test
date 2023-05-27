package tests;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.HomePage;
import pages.SignUpPage;

import com.github.javafaker.Faker;

import utilities.Utilities;

public class RegistrationTest {

	String url = "https://www.demoblaze.com/index.html";
	String driverPath = "..\\demoblaze-selenium-test\\driver\\chromedriver.exe";
	WebDriver driver;

	HomePage home;
	SignUpPage signUpPage;
	String email;
	String password;

	SoftAssert softAssert;

	@BeforeSuite
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		driver.manage().window().maximize();

	}

	@BeforeTest
	public void beforeTest() {

		home = new HomePage(driver);
		signUpPage = new SignUpPage(driver);
		softAssert = new SoftAssert();


	}
	
	@BeforeMethod
	public void beforeMethod() {
		home.clickOnSignUp();
		
	}

	@Test(description = "CP01- Valid Sign up", priority = 1)
	public void validSignUp() throws IOException {

		Faker faker = new Faker();

		email = faker.internet().emailAddress();

		password = faker.internet().password();
		

	

		signUpPage.signUp(email, password);

		softAssert.assertEquals(signUpPage.getAlertMessage(), Utilities.getAlertsProperties("VALID.SIGN.UP"));

		signUpPage.acceptAlert();

	}

	@Test(description = "CP02 - Sing up with used username", priority = 2, dependsOnMethods = "validSignUp")
	public void signUpUsedUsername() throws IOException {

		


		
		signUpPage.signUp(email, password);

		softAssert.assertEquals(signUpPage.getAlertMessage(), Utilities.getAlertsProperties("USED.SIGN.UP"));

		signUpPage.acceptAlert();

		signUpPage.clickOnClose();

	}

	@Test(description = "Sing up with empty fields", priority = 3)
	public void signUpWithEmptyFields() throws IOException {
		



		signUpPage.signUp("", "");

		softAssert.assertEquals(signUpPage.getAlertMessage(), Utilities.getAlertsProperties("EMPTY.SIGN.UP"));

		signUpPage.acceptAlert();

		signUpPage.clickOnClose();
	}

	@AfterSuite
	public void closePage() {

		driver.close();
	}
}
