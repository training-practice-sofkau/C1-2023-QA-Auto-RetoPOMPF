package com.sofkau.pages;

import org.openqa.selenium.*;

public class CommonActionOnPages {
    private WebDriver driver;

    public CommonActionOnPages(WebDriver driver) {
        this.driver = driver;
    }

    protected void typeIntoPOM(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }
    protected void typeIntoFactory(WebElement element, String value) { element.sendKeys(value); }


    protected void clearTextPOM(By locator) {
        driver.findElement(locator).clear();
    }
    protected void clearTextFactory(WebElement element) { element.clear(); }

    protected void clickPOM(By locator) {
        driver.findElement(locator).click();
    }
    public void Factory(WebElement element) {
        element.click();
    }

    protected void pressEnterPOM(By locator) {driver.findElement(locator).sendKeys(Keys.ENTER);}
    protected void pressEnterFactory(WebElement element) {element.sendKeys(Keys.ENTER); }

    protected void pressSpacePOM(By locator) {
        driver.findElement(locator).sendKeys(Keys.SPACE);
    }
    protected void pressSpaceFactory(WebElement element) {element.sendKeys(Keys.SPACE); }

    public void scrollToPOM(By locator){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }
    public void scrollToFactory(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void setZoom(int zoomLevel) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '" + zoomLevel + "%'");
    }

}
