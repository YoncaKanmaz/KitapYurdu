package com.testinium.methods;

import com.testinium.driver.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Methods {

    WebDriver driver;

    FluentWait<WebDriver> wait;

    String favoriteID;
    public Methods() {

        driver = BaseTest.driver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);

    }

    public WebElement findElement(By by) {

        return wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }

    public void click(By by) {

        findElement(by).click();

    }

    public void waitBySeconds(long seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sendKeys(By by, String text) {

        findElement(by).sendKeys(text);
    }

    public void scrollWithAction(By by) {

        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();

    }

    public void hoverWithAction(By by) {

        Actions actions = new Actions(driver);
        WebElement mainMenu = findElement(by);
        actions.moveToElement(mainMenu);

        WebElement subMenu = findElement(By.xpath("//a[text()='Çıkış']"));
        actions.moveToElement(subMenu);
        actions.click().build().perform();

    }

    public void getAttributeAndSave(By by, String attributeName) {

        WebElement webElement = driver.findElement(by);
        favoriteID = webElement.getAttribute(attributeName);
    }

    public String getText(By by) {

        return findElement(by).getText();

    }

    public void randomGeneratorAndRandomItem(){

        Actions actions = new Actions(driver);
        List<WebElement> itemsInPage = driver
                .findElements(By.xpath("//li[@class='mg-b-10']"));
        int size = itemsInPage.size();
        int randNumber = ThreadLocalRandom.current().nextInt(0, size-1);
        actions.moveToElement(itemsInPage.get(randNumber)).build().perform();
        itemsInPage.get(randNumber).click();
    }

    public void findThirdItemAndDelete(){

        String str= "//div[@id=\"" + favoriteID + "\"]//a[@data-title='Favorilerimden Sil']";
        findElement(By.xpath(str)).click();
    }

    public void sendDeleteKey(By by) {

        findElement(by).sendKeys(Keys.DELETE);
    }

    public void doubleClickWithAction(By by) {

        Actions actions = new Actions(driver);
        actions.doubleClick(findElement(by)).perform();

    }

}
