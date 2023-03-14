package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSteps extends StepManager{
	
	@When("Validate Home Page")
	public void validate_home_page() {
	    
		loginPage.validatelogo();
	}

	@And("Click on Register User")
	public void click_on_register_user() {
	    
		registerPage.registerhere();
		
	}

	@And("Enter required personal details")
	public void enter_required_personal_details() {
	    
		registerPage.Personaldetails();
	}

	@And("select the Role")
	public void select_the_role() {
		registerPage.Selectuser();
	}

	@Then("click on Next - Billing")
	public void click_on_next_billing() {

		registerPage.nextbilling();
	}

	@And("Enter the address details")
	public void enter_the_address_details() {
	    
		registerPage.AddressDetails();
	}

	@And("click on next - confirm and validate Previous is enable to click and click on confirm")
	public void click_on_next_confirm_and_validate_previous_is_enable_to_click_and_click_on_confirm() {
	   
		registerPage.clicknext();
	}

	@And("Validate Welcom page should be displayed and click on login here")
	public void validate_welcom_page_should_be_displayed_and_click_on_login_here() {
	    
		registerPage.Valiatewelcomepage();
	}

	@When("Enter the user and password")
	public void enter_the_user_and_password() {

		registerPage.credentials();
	}

	@Then("Validate User logged into the application check the new user name added or not")
	public void validate_user_logged_into_the_application_check_the_new_user_name_added_or_not() {
	   
		registerPage.Validateuser();
	}


}
