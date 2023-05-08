package com.sofkau.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.ArrayList;

public class CommonActionOnPages {
    private WebDriver driver;

    WebElement wait;
    public CommonActionOnPages(WebDriver driver) {

        this.driver = driver;
    }

    protected  void typeInto(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }

    protected void Wait(By locator) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(50))
                    .until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void arrowDown(By locator){
        driver.findElement(locator).sendKeys(Keys.ARROW_DOWN);
    }

    public void scrollTo(By locator){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }


    public void cambiarPestana(){
        driver.switchTo().defaultContent();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }
    protected  String getText (By locator){
        return driver.findElement(locator).getText();
    }

}
