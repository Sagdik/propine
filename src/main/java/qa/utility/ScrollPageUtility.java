/**
 * @author sagar.tripathi
 * @project Limkokwing.edustart.co
 */


package qa.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import qa.ProPine.BasePropine;

public class ScrollPageUtility extends BasePropine {
	
	
	JavascriptExecutor js;
	
	
	/**
	 * Scroll The page Vertical by 1000 pix
	 * and  for change make change in value
	 * like 1000 and 0 for horizontal change
	 */
	public  void scrollPageByValue(String horizontalValue,String verticalValue) {
		
		js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy"+"("+ horizontalValue +","+ verticalValue +")");
	}
	
	/**
	 * To scroll down the web page by the 
	 * visibility of the element
	 */
	public void scrollPageVisibleElement(WebElement Element)
	{

		js = (JavascriptExecutor)driver;
		
		js.executeScript("argument[0].scrollIntoView();",Element);
	}
	
	

}
