package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageProductSteps extends StepManager{
	
	@When("Click on Manage Product")
	public void click_on_manage_product() {
		manageProductPage.clickmanageProduct();
		
	}

	@And("Validate landed on Manage Product Page")
	public void validate_landed_on_manage_product_page() {
		manageProductPage.validateProductpage();
	}

	@And("Fill all thre details of the product")
	public void fill_all_thre_details_of_the_product() {
		manageProductPage.Productdetails();
	  	}
	
	@And("Add new Catgory")
	public void add_new_catgory() {
		
		manageProductPage.addnewCatgory();
	    
	}
		
	@When("Click on save button")
	public void click_on_save_button() {
		
		manageProductPage.Save();
	   	}

	@Then("Validate The item added or not")
	public void validate_the_item_added_or_not() {
		manageProductPage.Validatedaddeditem();
		
	 	}
	
	@Then("Validate The catgory added or not")
	public void validate_the_catgory_added_or_not() {
		manageProductPage.Validatecatgoryaddedornot();
		
	 	}


}
