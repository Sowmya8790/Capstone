package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepss extends StepManager{
	
	
	@Given("User launch the URL.")
	public void user_launch_the_url() {
		loginPage.launchapplixation();
	   
	}
	
	@And("Validate lated on Loginpage of medicare")
	public void validate_lated_on_loginpage_of_medicare() {
		loginPage.validatelogo();	    
	}
		
	@Then("Click on login")
	public void click_on_login() {
	    loginPage.clickonlogin();
	}

	@And("Enter the user {string} and password {string}")
	public void enter_the_user_and_password(String string, String string2) {
		loginPage.setusername(string, string2);	   
	}

	@And("click on login button")
	public void click_on_login_button() {
		loginPage.login();
	   
	}


	@When("Enter the admin user {string} and password {string}")
	public void enter_the_admin_user_and_password(String string, String string2) {
		loginPage.setusername(string, string2);
	}

	@Then("Validate Admin\\/User logged into the application")
	public void validate_admin_user_logged_into_the_application() {
		loginPage.Validateafterlogin();
		}

}
