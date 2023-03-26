package com.sofkau.pages;

import org.openqa.selenium.*;

public class CommonActionOnPages {
    protected WebDriver driver;

    public CommonActionOnPages(WebDriver driver) {
        this.driver = driver;
    }
    public void scrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,2000);");
    }

    public void typeInto(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }

    public void clearText(By locator){
        driver.findElement(locator).clear();
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }
    protected void pressEnter(By locator) {

        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    protected void pressSpace (By locator){
        driver.findElement(locator).sendKeys(Keys.SPACE);
    }

}