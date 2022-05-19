package com.testinium.test;


import com.testinium.driver.BaseTest;
import com.testinium.page.LoginPage;
import com.testinium.page.ProductPage;
import org.junit.Test;

public class ProductTest extends BaseTest {


    @Test
    public void filterAndRandomSelect(){
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();
        loginPage.login();
        productPage.searchAndScroll();
        productPage.filterAndSelect();
        productPage.addToCart();
        productPage.deleteThirdItem();
        productPage.cartAndPurchase();
        productPage.logout();

    }

}
