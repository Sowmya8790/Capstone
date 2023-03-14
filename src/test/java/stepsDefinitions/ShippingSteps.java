package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShippingSteps extends StepManager{
	
	@When("Fill all required address details")
	public void fill_all_required_address_details() {
	    
		shippingPage.Shippingdetails();
	}

	@And("Click on Add address")
	public void click_on_add_address() {
	    
		shippingPage.clickAddaddress();
	}

	@Then("Validate landed on Total summary page")
	public void validate_landed_on_total_summary_page() {
	    
		shippingPage.ValidateTabnames();
		
	}
	

}
