package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LandingPage {
	private WebDriver _driver;
	private String _userName;

	public LandingPage(WebDriver driver, String userName) {
		_driver = driver;
		_userName = userName;
		PageFactory.initElements(_driver, this);		
	}

	public void verifyIsAt() {
		Assert.assertTrue(title.isDisplayed() && title.getText().contains(_userName),
				"FAILED: Cannot access to the Landing page");
	}

	@FindBy(how = How.CLASS_NAME, using = "<className value>")
	private WebElement title;
}
