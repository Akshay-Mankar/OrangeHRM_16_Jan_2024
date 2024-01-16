package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.Wait;

public class LoginPage extends BaseClass {
	@FindBy (name ="username")
	private WebElement UserName;
	
	@FindBy (name ="password")
	private WebElement Password;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void loginPageFunctionality(String uname, String pwd)
	{
		Wait.sendKeys(UserName, uname);
		Wait.sendKeys(Password, pwd);
	}
}
