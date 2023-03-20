package com.sofkau.page;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.sofkau.util.LimitTime.THIRTY_SECONDS;

public class CommonActionOnPage {
    protected WebDriver driver;
    private WebDriverWait typeWait;
    public CommonActionOnPage(WebDriver driver) {
        this.driver = driver;
    }
    protected void typeIntol(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }
    protected void clearTextl(By locator){
        driver.findElement(locator).clear();
    }
    protected void click (WebElement webElement){
        webElement.click();
    }
    protected  void clearText (WebElement webElement){
        webElement.clear();
    }
    protected void typeInto(WebElement webElement, String value){
        webElement.sendKeys(value);
    }
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
    public void pressSpace(By locator){
        driver.findElement(locator).sendKeys(Keys.SPACE);
    }
    public void pressEnter(By locator){
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }
    public void pressTab(By locator){
        driver.findElement(locator).sendKeys(Keys.TAB);
    }
    protected String getText (WebElement webElement) {
        esperaExplicita(webElement);
        return webElement.getText();
    }
    public void scrollTo(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }
    public void scroll(int scrollAmount){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String script = "window.scrollBy(0," + scrollAmount + ")";
        jse.executeScript(script);
    }
    private void explicitWaitInit(){
        typeWait = new WebDriverWait(driver, Duration.ofSeconds(THIRTY_SECONDS.getValue()));
    }

    protected void clickwithDelay(WebElement element){
        typeWait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(Keys.ENTER);
    }

    protected void pressEnterWithDelay(WebElement element){
        typeWait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    protected void clickcondelay (WebElement webElement){
        esperaExplicita(webElement);
        webElement.click();
    }
    protected void esperaExplicita (WebElement webElement){
        typeWait = new WebDriverWait(driver, Duration.ofSeconds( THIRTY_SECONDS.getValue()));
        typeWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void esperaImplicita (WebElement webElement){
        typeWait.until(ExpectedConditions.visibilityOf(webElement));
    }




}
