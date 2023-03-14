package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps extends StepManager{
	

	@When("Click on view Products")
	public void click_on_view_products1() {
	    productPage.clickviewproduct();
	}

	@And("Validate Landed on view Products page")
	public void validate_landed_on_view_products_page() {
	    productPage.clickviewproduct();
	}

	@And("Click on Cart icon to add one item to cart and enter the quantity")
	public void click_on_cart_icon_to_add_one_item_to_cart_and_enter_the_quantity() {
		productPage.oneitemaddtocart();
		
		
	}

	@And("click on continue shopping")
	public void click_on_continue_shopping() {
		productPage.continueshoppingicon();
	}

	@And("Click on Cart icon to add second item to cart and enter the quantity")
	public void click_on_cart_icon_to_add_second_item_to_cart_and_enter_the_quantity() {
		productPage.seconditemaddtocart();
	}

	@And("click on checkout")
	public void click_on_checkout() {
		productPage.checkouticon();
	}

	@Then("Validate User landed on Shipping address page.")
	public void validate_user_landed_on_shipping_address_page() {
		productPage.validateshippingpage();
	}




}
