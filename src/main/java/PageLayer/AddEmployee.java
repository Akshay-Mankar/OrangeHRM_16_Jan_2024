package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.Wait;

public class AddEmployee extends BaseClass {
	
	@FindBy(xpath="//a[text()='Add Employee']")
	WebElement addButton;
	
	@FindBy(name = "firstName")
	private WebElement fname;
	
	@FindBy(name = "lastName")
	private WebElement lname;
	
	@FindBy(xpath="//button[text()=' Save ']")
	WebElement saveButton;
	
	
	public AddEmployee()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void addEmployeeFunctionality(String firstname, String lastname)
	{
		Wait.click(addButton);
		Wait.sendKeys(fname, firstname);
		Wait.sendKeys(lname, lastname);
		Wait.click(saveButton);
	}
}
