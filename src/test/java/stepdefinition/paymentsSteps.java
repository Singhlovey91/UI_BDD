package stepdefinition;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.qa.prePaymentCharge.base.BasePage;
import com.qa.prePaymentCharge.pages.HomePage;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class paymentsSteps extends BasePage {
	
	WebDriver driver =null;
	BasePage base= new BasePage();
	
	HomePage homepage = new HomePage(driver);
	
	
	@Given("^User open the browser and launch the application$")
	public void user_open_the_browser_and_launch_the_application()  {
	   
		
		Properties prop = base.init_prop();
		base.init_driver(prop);
	}

	@When("^User enters following details$")
	public void user_enters_following_details(DataTable table)  {
	    List<List<String>> userList = table.asLists(String.class);
	    
	    for(List<String>e: userList) {
	    
	    homepage.sendMortgageAmount(e.get(0), e.get(1), e.get(2), e.get(3), e.get(4), e.get(5));
	    }
	   
	}

	@When("^User click on calculate button$")
	public void user_click_on_calculate_button()  {
	    homepage.clickOnCalculateLink();
	    
	}

	@SuppressWarnings("deprecation")
	@Then("^Validate the error and error text$")
	public void validate_the_error_and_error_text()  {
	    String expectedErrorMessage= "Must be a value between 0 and 40%";
	    String actualErrorMessage= homepage.validateErrorMessage();
	    Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	    
	}
}
