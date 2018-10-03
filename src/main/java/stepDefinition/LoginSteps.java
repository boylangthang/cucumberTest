package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LandingPage;
import pages.LoginPage;

public class LoginSteps {
	private WebDriver driver;
	private LoginPage loginPage;
	private LandingPage landingPage;
	private String userName;
	
	@Given("^User is on Login page$")
	public void User_is_on_Login_page() throws Throwable {
		if(driver == null) {
			System.setProperty("webdriver.gecko.driver", "E:/Documents/Selenium/drivers/geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();		
			FirefoxProfile profile = new FirefoxProfile();        
	        profile.setAcceptUntrustedCertificates(true);
	        profile.setPreference("security.fileuri.strict_origin_policy", false);
	        FirefoxOptions options = new FirefoxOptions();
			options.setProfile(profile);		
	        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
	        driver = new FirefoxDriver(capabilities);
	        driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}		
		driver.get("login page URL");
		loginPage = new LoginPage(driver);
		loginPage.verifyIsAt();
	}

	@When("^User enters username and password$")
	public void User_enters_username_and_password() throws Throwable {
		this.userName = "userName";
		loginPage.inputUserName("userName");
		loginPage.inputPassWord("passWord");
	}

	@When("^User clicks submit button$")
	public void User_clicks_submit_button() throws Throwable {
		loginPage.clickSubmitBtn();
	}

	@Then("^User is redirected to the Landing page$")
	public void User_is_redirected_to_the_Landing_page() throws Throwable {
		landingPage = new LandingPage(driver, this.userName);
		landingPage.verifyIsAt();
	}

	@When("^User does not enter username$")
	public void User_does_not_enter_username() throws Throwable {				
		loginPage.clearUserName();
	}

	@When("^User enters password$")
	public void User_enters_password() throws Throwable {
		loginPage.inputPassWord("passWord");
	}

	@Then("^An error message ask user to enter username$")
	public void An_error_message_ask_user_to_enter_username() throws Throwable {
	    loginPage.verifyErrorEmptyUserName();
	}

	@When("^User enters username$")
	public void User_enters_username() throws Throwable {
		this.userName = "userName";
		loginPage.inputUserName(userName);
	}

	@When("^User does not enter password$")
	public void User_does_not_enter_password() throws Throwable {
	    loginPage.clearPassWord();
	}

	@Then("^An error message ask user to enter password$")
	public void An_error_message_ask_user_to_enter_password() throws Throwable {
	    loginPage.verifyErrorEmptyPassWord();
	}
}
