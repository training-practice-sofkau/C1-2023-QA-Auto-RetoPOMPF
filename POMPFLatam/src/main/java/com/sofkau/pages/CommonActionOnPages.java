package com.sofkau.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static com.sofkau.util.LimitTimeWait.TEN_SECONDS;


public class CommonActionOnPages {

    private WebDriver driver;
    private WebDriverWait typeWait;

    public CommonActionOnPages(WebDriver driver) {
        this.driver = driver;
        explicitWaitInit();
    }

    private void explicitWaitInit(){
        typeWait = new WebDriverWait(driver, TEN_SECONDS.getValue());
    }

    protected void waitGeneral (By locator){
        typeWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void typeInto(By locator, String value){

        driver.findElement(locator).sendKeys(value);
    }

    protected  void typeInto(WebElement webElement, String value){
        webElement.sendKeys(value);
    }

    protected void clearText(By locator){
        driver.findElement(locator).clear();
    }

    protected void clearText(WebElement webElement){
        webElement.clear();
    }

    protected void click(By locator){
        typeWait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void click(WebElement webElement){
       typeWait.until(ExpectedConditions.visibilityOf(webElement));
       webElement.click();

    }

    public void changeTab(){
        driver.switchTo().defaultContent();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

    protected void pressSpace(By locator){
        driver.findElement(locator).sendKeys(Keys.SPACE);
    }

    protected void pressSpace(WebElement webElement){
        webElement.sendKeys(Keys.SPACE);
    }

    protected void pressEnter(By locator){
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    protected void pressEnter(WebElement webElement){
        webElement.sendKeys(Keys.ENTER);
    }

    public void clickForm(By locator) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", driver.findElement(locator));
    }

    public void pressTab(By locator){
        driver.findElement(locator).sendKeys(Keys.TAB);
    }

    public void zoom(int zoomLevel){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.body.style.zoom = '" + zoomLevel + "%'");
    }

    protected void selectDate(By locator, String value){
        driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a"), value, Keys.ENTER);
    }

    protected void scrollDownToElement(WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    protected void scrollDownToElement(By locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    protected void jsClick(WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click;", webElement);
        webElement.click();
    }

    protected String getMessage(By locator) throws InterruptedException {
        Thread.sleep(3000);
        String text = typeWait.until(ExpectedConditions.elementToBeClickable(locator)).getText();

        return text;
    }
}
