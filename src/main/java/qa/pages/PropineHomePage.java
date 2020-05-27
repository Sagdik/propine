package qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.ProPine.BasePropine;

public class PropineHomePage extends BasePropine {

	@FindBy(xpath = "//input[@placeholder='date']")
	WebElement dateField;

	@FindBy(xpath = "//div[@class='container']//a//img")
	WebElement titleText;

	@FindBy(tagName = "h1")
	WebElement headLineText;

	@FindBy(xpath = "//input[@class='btn btn-default']")
	WebElement submitButton;

	public PropineHomePage() {

		PageFactory.initElements(driver, this);
	}

	/**
	 * Medtho to validate page
	 * @return
	 */
	public boolean validatePageTitle() {

		return titleText.isDisplayed();

	}

	/**
	 * Validate page headline
	 * @return
	 */
	public String pageHeadline() {

		return headLineText.getText();
	}

	/**
	 * Method to enter date
	 * @param date
	 */
	public void enterDate(String date) {

		dateField.sendKeys(date);
	}

	/**
	 * Method to select the Submit button
	 * @return
	 */
	public WebElement clickSubmitButton() {

		return submitButton;

	}

}
