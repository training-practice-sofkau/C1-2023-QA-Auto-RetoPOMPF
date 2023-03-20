package com.sofkau.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static com.sofkau.util.LimitTimeWait.*;


public class CommonActionsOnPages {
    private WebDriver driver;
    private WebDriverWait typeWait;
    public CommonActionsOnPages(WebDriver driver){
        this.driver = driver;
        explicitWaitInit();
    }

    protected void click(WebElement webElement){
        webElement.click();
    }

    private void explicitWaitInit () {
        typeWait = new WebDriverWait(driver, Duration.ofSeconds(THIRTY_SECONDS.getValue()));
    }

    protected void explicitWaitInit (WebElement webElement){
        typeWait = new WebDriverWait(driver, Duration.ofSeconds( THIRTY_SECONDS.getValue()));
        typeWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void clickwithDelay(WebElement element){
        typeWait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void clickwithDelay(By element){
        typeWait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void pressEnterWithDelay(WebElement element){
        typeWait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(Keys.ENTER);
    }

    protected void pressEnter(WebElement webElement){
        webElement.sendKeys(Keys.ENTER);
    }

    protected void typeInto(WebElement webElement, String value){
        webElement.sendKeys(value);
    }

    public void setZoom(int zoomLevel) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '" + zoomLevel + "%'");
    }

    public void scrollDown(int scrollAmount){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String script = "window.scrollBy(0," + scrollAmount + ")";
        jse.executeScript(script);
    }

    protected void click (By locator){
        driver.findElement(locator).click();
    }

    protected void clearText(By locator){
        driver.findElement(locator).clear();
    }

    protected void typeInto(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }

    protected void fillFieldsSlows(By locator, String value){
        driver.findElement(locator).sendKeys(value, Keys.ARROW_DOWN, Keys.ENTER);
    }

    protected void selectCombobox(WebElement webElement){
        webElement.sendKeys(Keys.ENTER, Keys.ARROW_DOWN, Keys.ENTER);
    }

    protected void typeWithDelay(WebElement webElement, String text, int delayInMilliseconds) {
        explicitWaitInit(webElement);
        webElement.click();
        for (char c : text.toCharArray()) {
            webElement.sendKeys(Character.toString(c));
            try {
                Thread.sleep(delayInMilliseconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
