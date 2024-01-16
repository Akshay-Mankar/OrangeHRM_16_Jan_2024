package UtilityLayer;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;

public class Wait extends BaseClass{
	private final static int time=40;
	public static WebElement visibilityStatus(WebElement wb)
	{
		return new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOf(wb));
	}
	
	public static void sendKeys(WebElement wb, String Value)
	{
		visibilityStatus(wb).sendKeys(Value);
	}
	
	public static void click(WebElement wb)
	{
		visibilityStatus(wb).click();
	}
	
	public static String getTitile() {
		return driver.getTitle();
		
	}
	
	public static String getUrl() {
		return driver.getCurrentUrl();
		
	}
}
