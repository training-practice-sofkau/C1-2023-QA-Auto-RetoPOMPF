package com.sofkau.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

import static com.sofkau.util.LimitTimeWait.TEN_SECONDS;

public class CommonActionOnPages {
    private WebDriver driver;
    private WebDriverWait typeWait;

    public CommonActionOnPages(WebDriver driver) {
        this.driver = driver;
        explicitWaitInit();
    }

    private void explicitWaitInit () {
        typeWait = new WebDriverWait(driver, TEN_SECONDS.getDuration());
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
    protected void click (By locator) {
        typeWait.until(ExpectedConditions.elementToBeClickable(locator)).click();
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

    public void scrollP(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1800)");
    }

    public void scrollP2() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,900)");
    }
    public void scrollTo(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }

    protected void goBack() {
        driver.navigate().back();
    }

    protected void ponerMouse(String string){
        WebElement categoria = driver.findElement(By.className(string));
        Actions actions=new Actions(driver);
        actions.moveToElement(categoria).perform();
    }

    public void setZoom(int zoomLevel) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '" + zoomLevel + "%'");
    }

}
