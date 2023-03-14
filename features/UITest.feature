Feature: Login into medicare Application
  I want to login to medicare application as an user and Admin
  
  Background: Common steps in every scenario
  Given User launch the URL.
  Then Click on login
  
 
  Scenario: Register as an User
  When Validate Home Page
  Then Click on login
  And Click on Register User
  And Enter required personal details 
  And select the Role
  Then click on Next - Billing
  When Enter the address details
  Then click on next - confirm and validate Previous is enable to click and click on confirm
  And Validate Welcom page should be displayed and click on login here
  When Validate lated on Loginpage of medicare
  And Enter the user and password 
  And click on login button
  Then Validate User logged into the application check the new user name added or not


  @user
  Scenario: Login into medicare as an User
    When Validate lated on Loginpage of medicare
    And Enter the user "kn@gmail.com" and password "12345"
    And click on login button
    Then Validate Admin/User logged into the application
    When Click on view Products
    And Validate Landed on view Products page
    And Click on Cart icon to add one item to cart and enter the quantity
    And click on continue shopping
    And Click on Cart icon to add second item to cart and enter the quantity
    And click on checkout
    Then Validate User landed on Shipping address page.
   	When Fill all required address details
   	And Click on Add address
   	Then Validate landed on Total summary page
   	When Give credit card details
   	And Click on Final payment
   	Then Validated Order confirmed page


  @admin
  Scenario: Login into medicare as an User
    When Validate lated on Loginpage of medicare
    And Enter the admin user "vk@gmail.com" and password "admin"
    And click on login button
    Then Validate Admin/User logged into the application
    When Click on Manage Product
    And Validate landed on Manage Product Page
    And Fill all thre details of the product
    And Click on save button
    Then Validate The item added or not

	@admin
  	Scenario: Add Catgory to Application as an Admin
    When Validate lated on Loginpage of medicare
    And Enter the admin user "vk@gmail.com" and password "admin"
    And click on login button
    Then Validate Admin/User logged into the application
    When Click on Manage Product
    And Validate landed on Manage Product Page
    And Fill all thre details of the product
    And Add new Catgory
    Then Validate The catgory added or not
