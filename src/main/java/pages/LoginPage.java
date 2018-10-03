package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	private WebDriver _driver;

	public LoginPage(WebDriver driver) {
		_driver = driver;
		PageFactory.initElements(_driver, this);		
	}

	public void verifyIsAt() {
		Assert.assertTrue(title.isDisplayed(), "FAILED: Cannot access to the Login page");
	}

	@FindBy(how = How.CLASS_NAME, using = "")
	private WebElement title;
	@FindBy(how = How.ID, using = "")
	private WebElement userNameField;
	@FindBy(how = How.ID, using = "")
	private WebElement passwordField;
	@FindBy(how = How.CSS, using = "")
	private WebElement submitBtn;

	public void inputUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void clearUserName() {
		userNameField.clear();
	}

	public void inputPassWord(String passWord) {
		passwordField.sendKeys(passWord);
	}

	public void clearPassWord() {
		passwordField.clear();
	}

	public void clickSubmitBtn() {
		submitBtn.click();
	}

	public void Login(String userName, String passWord) {
		inputUserName(userName);
		inputPassWord(passWord);
		clickSubmitBtn();
	}
	
	public void verifyErrorEmptyUserName() {
		WebElement error = _driver.findElement(By.id(""));
		Assert.assertTrue(error.getText().contains("Empty user name"), "FAILED: Empty user name error is not shown");
	}
	
	public void verifyErrorEmptyPassWord() {
		WebElement error = _driver.findElement(By.id(""));
		Assert.assertTrue(error.getText().contains("Empty pass word"), "FAILED: Empty pass word error is not shown");
	}
}
