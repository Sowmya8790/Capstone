package pages;

import java.util.Objects;

public class PageManager {

    private LoginPage loginPage;
    private ProductPage productPage;
    private ShippingPage shippingPage;
    private PaymentPage paymentPage;
    private ManageProductPage manageProductPage;
    public RegisterPage registerPage;


    public RegisterPage getRegisterPage()
    {
         return(Objects.isNull(registerPage))? registerPage= new RegisterPage():registerPage;
    }
    
   public LoginPage getLoginPage()
   {
        return(Objects.isNull(loginPage))? loginPage= new LoginPage():loginPage;
   }
   
   public ProductPage getproductPage()
   {
        return(Objects.isNull(productPage))? productPage= new ProductPage():productPage;
   }
   
   public ShippingPage getShippingPage()
   {
        return(Objects.isNull(shippingPage))? shippingPage= new ShippingPage():shippingPage;
   }
   
   public PaymentPage getPaymentPage()
   {
        return(Objects.isNull(paymentPage))? paymentPage= new PaymentPage():paymentPage;
   }
   
    
   public ManageProductPage getManageProductPage()
   {
        return(Objects.isNull(manageProductPage))? manageProductPage= new ManageProductPage():manageProductPage;
   }
   

  
}
