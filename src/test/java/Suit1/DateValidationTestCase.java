package Suit1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import qa.ProPine.BasePropine;
import qa.pages.PropineHomePage;
import qa.utility.CustomeListner;


@Listeners(CustomeListner.class)
public class DateValidationTestCase extends BasePropine {
	
	PropineHomePage homePage;
	SoftAssert softAssert;
	
	
	public DateValidationTestCase() {
		super();
	}
	
	@Parameters({"url"})
	@BeforeMethod(alwaysRun = true)
	public void openBrowser(String url) throws InterruptedException {

		//Launch the browser 
		launchBrowser(url);
		homePage = new PropineHomePage();
		softAssert = new SoftAssert();
	}
	
	/**
	 * Home Page Validation Page
	 */
	
	@Test
	public void validatePageTitle() {
		
		boolean text = homePage.validatePageTitle();
	
		softAssert.assertEquals(text, true);
		
		softAssert.assertAll();
		
	}
	
	/**
	 * Home Page Day Parser 
	 */
	@Test
	public void validatePageHeadline() {
		
		String headLineText = homePage.pageHeadline();
	
		System.out.println(headLineText);
		
		softAssert.assertEquals(headLineText, "Propine Date Parser");
		
		softAssert.assertAll();
		
	}
	
	/**
	 * Validate All Mandatory fields present on page
	 */
	@Test
	public void validateAllMandatoryFields() {
		
		homePage.enterDate("12/12/2020");
		
		homePage.clickSubmitButton().click();
		
		driver.manage().timeouts().implicitlyWait(15000,TimeUnit.MILLISECONDS);
		
		String resultValue = driver.findElement(By.xpath("//div[@class='container']//div[2]//div")).getText();
		
		softAssert.assertEquals(resultValue,"Sat Dec 12 2020 00:00:00 GMT+0000");
	
		softAssert.assertAll();
	}
	
	
	/**
	 * Negative Test Cases
	 * Validate All language support on Date pareser
	 */
	@Test
	public void valdiateLanguageSupportDateParser() {
		
		homePage.enterDate("u'Le 11 Décembre 2014 à 09:00'");

		homePage.clickSubmitButton().click();
		
		driver.manage().timeouts().implicitlyWait(15000,TimeUnit.MILLISECONDS);
		
		String resultValue = driver.findElement(By.xpath("//div[@class='container']//div[2]//div")).getText();
		
		softAssert.assertEquals(resultValue, "Invalid date");
		
		softAssert.assertAll();
		
	}
	
	/**
	 * Negative Test Cases
	 * Validate Date parse in different format
	 */
	@Test
	public void validateDateParseFormat() {
		
		homePage.enterDate("2005-05-05 22:12 PM");
		
		homePage.clickSubmitButton().click();
		
		driver.manage().timeouts().implicitlyWait(15000,TimeUnit.MILLISECONDS);
		
		String resultValue = driver.findElement(By.xpath("//div[@class='container']//div[2]//div")).getText();
		
		softAssert.assertEquals(resultValue, "Invalid date");
		
		softAssert.assertAll();
	}
	

	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

}
