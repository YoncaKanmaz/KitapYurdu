package com.testinium.page;

import com.testinium.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ProductPage {

    Methods methods;


    public ProductPage(){
        methods = new Methods();
    }

    public void searchAndScroll(){

        methods.sendKeys(By.id("search-input"),"oyuncak");
        methods.waitBySeconds(3);
        methods.click(By.cssSelector(".common-sprite.button-search"));
        methods.waitBySeconds(3);
        methods.scrollWithAction(By.xpath("//div[@class='product-cr'][7]"));
        methods.waitBySeconds(3);
        methods.click(By.xpath("//div[@class='product-cr'][4]/div/div/a[@class='add-to-favorites']"));
        methods.waitBySeconds(2);
        Assert.assertTrue(methods.findElement(By.id("swal2-title")).getText().contains("Ürün başarılı bir şekilde"));
        methods.waitBySeconds(5);
        methods.getAttributeAndSave(By.xpath("//div[@class='product-cr'][5]"),"id");
        methods.waitBySeconds(3);
        methods.click(By.xpath("//div[@class='product-cr'][5]/div/div/a[@class='add-to-favorites']"));
        methods.waitBySeconds(3);
        Assert.assertTrue(methods.findElement(By.id("swal2-title")).getText().contains("Ürün başarılı bir şekilde"));
        methods.waitBySeconds(5);
        methods.click(By.xpath("//div[@class='product-cr'][6]/div/div/a[@class='add-to-favorites']"));
        methods.waitBySeconds(3);
        Assert.assertTrue(methods.findElement(By.id("swal2-title")).getText().contains("Ürün başarılı bir şekilde"));
        methods.waitBySeconds(5);
        methods.click(By.xpath("//div[@class='product-cr'][7]/div/div/a[@class='add-to-favorites']"));
        methods.waitBySeconds(3);
        Assert.assertTrue(methods.findElement(By.id("swal2-title")).getText().contains("Ürün başarılı bir şekilde"));
        methods.waitBySeconds(5);
        methods.scrollWithAction(By.id("top-banner"));
        methods.waitBySeconds(3);
        methods.click(By.cssSelector(".menu.top.my-list"));
        methods.click(By.xpath("//a[text()='Favorilerim']"));
        methods.waitBySeconds(3);

    }

    public void filterAndSelect (){

        methods.click(By.cssSelector(".logo-icon"));
        methods.waitBySeconds(3);
        methods.click(By.cssSelector(".lvl1catalog"));
        methods.waitBySeconds(3);
        methods.click(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']"));
        methods.waitBySeconds(3);
        methods.click(By.cssSelector(".sort"));
        methods.waitBySeconds(3);
        methods.click(By.xpath("//option[text()='Yüksek Oylama']"));
        methods.waitBySeconds(3);
        methods.click(By.xpath("//span[@class='mn-strong common-sprite' and text()='Tüm Kitaplar']"));
        methods.waitBySeconds(3);



    }
    public void addToCart (){
        methods.click(By.xpath("//a[text()='Hobi']"));
        methods.waitBySeconds(3);
        methods.randomGeneratorAndRandomItem();
        methods.waitBySeconds(3);
        methods.click(By.id("button-cart"));
        methods.waitBySeconds(3);
    }

    public void deleteThirdItem(){
        methods.click(By.cssSelector(".menu.top.my-list"));
        methods.click(By.xpath("//a[text()='Favorilerim']"));
        methods.waitBySeconds(3);
        methods.findThirdItemAndDelete();
        methods.waitBySeconds(3);
    }

    public void cartAndPurchase(){
        methods.click(By.cssSelector(".common-sprite.fl"));
        methods.waitBySeconds(3);
        methods.click(By.id("js-cart"));
        methods.waitBySeconds(3);
        methods.doubleClickWithAction(By.xpath("//input[@name='quantity']"));
        methods.waitBySeconds(3);
        methods.sendDeleteKey(By.xpath("//input[@name='quantity']"));
        methods.waitBySeconds(3);
        methods.sendKeys(By.xpath("//input[@name='quantity']"),"2");
        methods.waitBySeconds(3);
        methods.click(By.cssSelector(".fa.fa-refresh.green-icon"));
        methods.waitBySeconds(5);
        methods.click(By.xpath("//div[@class='right']/a"));
        methods.waitBySeconds(3);
        methods.click(By.xpath("//div[@id='shipping-tabs']/a[2]"));
        methods.sendKeys(By.id("address-firstname-companyname"),"Deneme");
        methods.sendKeys(By.id("address-lastname-title"),"Deneme2");
        methods.click(By.id("address-zone-id"));
        methods.click(By.xpath("//option[text()='Adana']"));
        methods.click(By.id("address-county-id"));
        methods.click(By.xpath("//option[text()='ALADAĞ']"));
        methods.sendKeys(By.id("district"),"AKPINAR MAH");
        methods.sendKeys(By.id("address-address-text"),"DummyText");
        methods.sendKeys(By.id("address-mobile-telephone"),"5555555555");
        methods.waitBySeconds(2);
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySeconds(2);
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("credit-card-owner"),"Deneme deneme");
        methods.sendKeys(By.id("credit_card_number_1"),"0000");
        methods.sendKeys(By.id("credit_card_number_2"),"0000");
        methods.sendKeys(By.id("credit_card_number_3"),"0000");
        methods.sendKeys(By.id("credit_card_number_4"),"0000");
        methods.click(By.id("credit-card-expire-date-month"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//option[text()='01']"));
        methods.click(By.id("credit-card-expire-date-year"));
        methods.click(By.xpath("//option[text()='2023']"));
        methods.sendKeys(By.id("credit-card-security-code"),"000");
        methods.waitBySeconds(2);
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySeconds(4);
        methods.click(By.xpath("//input[@type='checkbox']"));
        methods.click(By.cssSelector(".button"));
        methods.waitBySeconds(5);
        Assert.assertEquals(methods.findElement(By.cssSelector(".warning")).getText(),"Kart bilgileriniz doğrulanamadı, lütfen tekrar deneyiniz.");

    }

    public void logout(){
        methods.click(By.cssSelector(".checkout-logo"));
        methods.waitBySeconds(2);
        methods.hoverWithAction(By.cssSelector(".menu.top.login"));
    }

}
