package com.sofkau.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    protected void clickwithDelay(WebElement element){
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
}
