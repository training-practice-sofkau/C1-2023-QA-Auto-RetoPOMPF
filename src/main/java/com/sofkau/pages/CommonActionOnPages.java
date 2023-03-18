package com.sofkau.pages;

import org.openqa.selenium.*;

public class CommonActionOnPages {

    private WebDriver driver;

    public CommonActionOnPages(WebDriver driver) {
        this.driver = driver;
    }

    protected void typeInto (By locator, String  value ){
        driver.findElement(locator).sendKeys(value);
    }

    protected void clearText (By locator){

        driver.findElement(locator).clear();
    }

    protected  void pressEnter (By locator){
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    protected  void pressSpace (By locator){
        driver.findElement(locator).sendKeys(Keys.SPACE);
    }

    protected void click (By locator){
        driver.findElement(locator).click();
    }


    // Revisar

    protected void calendar (By locator, String fecha) {
        driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a"), fecha, Keys.ENTER);
    }

    public void setZoom(int zoomLevel) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '" + zoomLevel + "%'");
    }


    protected  String getText (WebElement webElement){
        return webElement.getText();
    }
}
