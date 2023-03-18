package com.sofkau.pages;

import org.openqa.selenium.*;
import org.sikuli.script.Key;

public class CommonActionOnPages {
    private WebDriver driver;
    public CommonActionOnPages(WebDriver driver){
        this.driver = driver;
    }
    protected void typeInto(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }
    protected void  clearText(By locator){
        driver.findElement(locator).clear();
    }

    protected void  click(By locator){
        driver.findElement(locator).click();
    }
    protected void  clickElement(WebElement element){
        element.click();
    }
    protected void selectDate(By locator, String value){
        driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a"), value, Keys.ENTER);
    }
    protected void pathFile(By locator, String path){
        driver.findElement(locator).sendKeys(path);
    }

    protected void pressEnter(By locator){
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }
    public void scrollto(By locator){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(locator));
    }
    protected String getText(By locator){
        return driver.findElement(locator).getText();
    }

    protected void presSpace(By locator){
        driver.findElement(locator).sendKeys(Keys.SPACE);
    }
    protected void sendDate(By locator, String value){
        clearText(locator);
        driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a"), value, Keys.ENTER);
    }
    public void scrollTo(By locator){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    public void setZoom(int zoomLevel){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '" +zoomLevel +"%'");

    }
    protected void tab(By locator) {
        driver.findElement(locator).sendKeys(Key.TAB);
    }
}
