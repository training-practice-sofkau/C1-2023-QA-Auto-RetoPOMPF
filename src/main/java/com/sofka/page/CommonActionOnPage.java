package com.sofka.page;

import com.sofka.util.TimeWait;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CommonActionOnPage {

    protected WebDriver driver;
    private WebDriverWait typeWait;
    public CommonActionOnPage(WebDriver driver) {
        this.driver = driver;
        explicitWaitInit();
    }
    void explicitWaitInit() {
        typeWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    protected void typeInto(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }
    protected void clearText(By locator){
        driver.findElement(locator).clear();
    }
    protected void click (By locator) {
        typeWait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    protected void clickpom(By locator){driver.findElement(locator).click();}


    protected void selectDate(By locator, String value){
        driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a"), value, Keys.ENTER);
    }
    protected void tab(By locator) {
        driver.findElement(locator).sendKeys(Keys.TAB);
    }
    protected void setZoom (int zoomLevel) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '" + zoomLevel + "%'");
    }
    protected void pressEnter(By locator) {
        driver.findElement(locator).sendKeys(Keys.ENTER);

    }

    protected void pressSpace(By locator) {
        driver.findElement(locator).sendKeys(Keys.SPACE);
    }


}
