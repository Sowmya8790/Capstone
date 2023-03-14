package stepsDefinitions;


import pages.*;

public class StepManager {

        PageManager pageManager;
        LoginPage loginPage;
        ProductPage productPage;
        ShippingPage shippingPage;
        PaymentPage paymentPage;
        ManageProductPage manageProductPage;
        RegisterPage registerPage;
      

    public StepManager()
    {
        initializePages();
    }

    public void initializePages(){

        pageManager=new PageManager();
        registerPage = pageManager.getRegisterPage();
        loginPage=pageManager.getLoginPage();
        productPage = pageManager.getproductPage();
        shippingPage = pageManager.getShippingPage();
        paymentPage = pageManager.getPaymentPage();
        manageProductPage = pageManager.getManageProductPage();
    }
}
