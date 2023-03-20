package com.sofka.page;

import io.cucumber.plugin.event.Node;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class Activity2Page extends CommonActionOnPage{
    private By facebookSymbolLocator = By.className("icon-facebook");

    public Activity2Page(WebDriver driver) {
        super(driver);
        explicitWaitInit(); // Iniciando explicit wait en el constructor
    }

    public void clickFacebookButton() {
        try {
            Thread.sleep(2000);
            click(facebookSymbolLocator);

        }catch (Exception e){
            System.out.println(e.getMessage());

        }

    }
    public boolean isElementPresent(String locator) {
        try {
            driver.findElement(By.xpath(locator));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
