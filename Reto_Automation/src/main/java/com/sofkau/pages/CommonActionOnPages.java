package com.sofkau.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CommonActionOnPages {

    protected WebDriver driver;
    private WebDriverWait typeWait;
    public CommonActionOnPages(WebDriver driver) {
        this.driver = driver;
        explicitWaitInit();
    }

    private void explicitWaitInit() {
        typeWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    protected void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    protected void switchTab(int tabid) {
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(tabid));
    }

    protected void getTabsList() {
        ArrayList<String> tabsList = new ArrayList<String> (driver.getWindowHandles());
        System.out.println(tabsList);
    }
    protected void typeInto(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }

    protected void clearText(By locator){
        driver.findElement(locator).clear();
    }

    protected void click(By locator){
        typeWait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void space(By locator){
        driver.findElement(locator).sendKeys(Keys.SPACE);
    }

    protected void enter(By locator){
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    public void scrollTo(By locator){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    public void scrollTo(WebElement element) {
        typeWait.until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }


    protected void setDate (By locator, String fecha) {
        driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a"), fecha, Keys.ENTER);
    }

    public void setZoom(int zoomLevel) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '" + zoomLevel + "%'");
    }

    protected void click(WebElement webElement){
        typeWait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
//        webElement.click();
    }

    protected void pressEnter(WebElement webElement){
        webElement.sendKeys(Keys.ENTER);
    }

    protected void typeInto(WebElement webElement, String value){
        webElement.sendKeys(value);
    }
    protected void pressArrowDown(WebElement webElement){
        webElement.sendKeys(Keys.ARROW_DOWN);
    }
    protected void pressArrowDown(By locator){
        driver.findElement(locator).sendKeys(Keys.ARROW_DOWN);
    }
}
