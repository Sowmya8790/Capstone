package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentSteps extends StepManager{
	

	@And("Give credit card details")
	public void give_credit_card_details() {
	    
		paymentPage.credicarddetails();
		
	}

	@When("Click on Final payment")
	public void click_on_final_payment() {
	    
		paymentPage.clickbutton();
	}

	@Then("Validated Order confirmed page")
	public void validated_order_confirmed_page() {
	   
		paymentPage.VaildateOrderconfirm();
		paymentPage.ValidateQuantity();
		paymentPage.ValidateTablets();
	}


}
