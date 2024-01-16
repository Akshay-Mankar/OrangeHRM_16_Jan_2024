package StepDefination;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseLayer.BaseClass;
import PageLayer.AddEmployee;
import PageLayer.LoginPage;
import UtilityLayer.Wait;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeHRMSteps extends BaseClass {
	
	protected String empid;

	@Given("user is on Login Page")
	public void user_is_on_login_page() {
		BaseClass.initilization();
	}

	@When("user enter valid credentails")
	public void user_enter_valid_credentails(DataTable dataTable) {
		List<List<String>> ls =  dataTable.asLists();
		String uname = ls.get(0).get(0);
		String pwd = ls.get(0).get(1);
		LoginPage loginPage = new LoginPage();
		loginPage.loginPageFunctionality(uname, pwd);
		
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
	    driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	}

	@When("user is on home page validate home page title")
	public void user_is_on_home_page_validate_home_page_title(DataTable dataTable) {
	    List<List<String>> cel = dataTable.cells();
	    String title = cel.get(0).get(0);
	    Assert.assertTrue(Wait.getTitile().contains(title));
	}

	@When("user validate home page url")
	public void user_validate_home_page_url() {
		Assert.assertTrue(Wait.getUrl().contains("dashboard"));
	}

	@When("user validate home page logo")
	public void user_validate_home_page_logo(DataTable dataTable) {
		
		List<List<String>> cel = dataTable.cells();
	    String logoValue = cel.get(0).get(0);
		String str= String.valueOf(driver.findElement(By.xpath("//img[@alt='client brand banner']")).isDisplayed());
		Assert.assertEquals(logoValue, str);
	}

	@When("user click on pim page link")
	public void user_click_on_pim_page_link() {
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
	}

	@When("user validate user is on pim page by using url")
	public void user_validate_user_is_on_pim_page_by_using_url(DataTable dataTable) {
		List<List<String>> cel = dataTable.cells();
	    String url = cel.get(0).get(0);
	    Assert.assertTrue(Wait.getUrl().contains(url));
	}

	@When("user click add employee and enter firstname, lastname and click on save button")
	public void user_click_add_employee_and_enter_firstname_lastname_and_click_on_save_button(DataTable dataTable) {
	    List<List<String>> emp = dataTable.asLists();
	    for (int i=0;i<3;i++)
	    {
	    String fname1 = emp.get(i).get(0);
	    String lname1 = emp.get(i).get(1);
	    AddEmployee addemp = new AddEmployee();
	    addemp.addEmployeeFunctionality(fname1, lname1);
	    }

	}

	@When("user capture employee id number and user click on employeelist")
	public void user_capture_employee_id_number_and_user_click_on_employeelist() {
		empid = driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div /following-sibling::div /child:: input")).getAttribute("value");
		driver.findElement(By.xpath("//a[text()='Employee List']")).click();
	}

	@When("user enter employee id is employee id text  box and click on search button")
	public void user_enter_employee_id_is_employee_id_text_box_and_click_on_search_button() throws InterruptedException {
	    WebElement search = driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']"));
	    search.click();
	    search.sendKeys(empid);
	    driver.findElement(By.xpath("//button[text()=' Search ']")).click();
	    Thread.sleep(4000);
	}

	@When("user selected searched employee and click on delete")
	public void user_selected_searched_employee_and_click_on_delete() throws InterruptedException {
	   driver.findElement(By.xpath("//div[text()='Actions']/following::span")).click();
	   driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash']")).click();
	   Thread.sleep(4000);
	   driver.findElement(By.xpath("//button[text()=' Yes, Delete ']")).click();
	}

	@Then("validate employee is deleted or not")
	public void validate_employee_is_deleted_or_not() {
//		WebElement search = driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']"));
//		search.clear();
//		search.click();
//		search.sendKeys(empid);
		driver.findElement(By.xpath("//button[text()=' Search ']")).click();
		String actual = driver.findElement(By.xpath("//span[text()='No Records Found']")).getText();
		Assert.assertEquals(actual, "No Records Found");
	}

	@When("user click on profile and click on logout button")
	public void user_click_on_profile_and_click_on_logout_button() throws InterruptedException {
		
	 driver.findElement(By.xpath("//img[@class='oxd-userdropdown-img']")).click();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}
}
