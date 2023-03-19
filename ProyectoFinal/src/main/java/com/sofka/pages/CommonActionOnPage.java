package com.sofka.pages;

import com.sofka.util.Log4j;
import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.sofka.util.TimeWait.*;


public class CommonActionOnPage{

    private WebDriver driver;

    private WebDriverWait typeWait;

    public CommonActionOnPage(WebDriver driver) {
        this.driver = driver;
        explicitWaitInit();
    }

    private void explicitWaitInit () {
        typeWait = new WebDriverWait(driver, TEN_SECONDS.getTime());
    }

    protected void click (By locator) {
        typeWait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void typeIntoP(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }

    protected void clearTextP(By locator){
        driver.findElement(locator).clear();
    }

    protected void clickP(By locator){
        driver.findElement(locator).click();
    }

    protected void pressSpaceP(By locator) {
        driver.findElement(locator).sendKeys(Keys.SPACE);
    }

    protected void selectAllTextP(By locator){
        WebElement input = driver.findElement(locator);
        input.click();
        input.sendKeys(Keys.chord(Keys.CONTROL,"a"));
    }

    protected void pressEnterP(By locator) {
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    protected void pressEscapeP(By locator){
        driver.findElement(locator).sendKeys(Keys.ESCAPE);
    }

    public void scrollToP(By locator){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    public void scrollP(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1800)");
    }

    public void scrollNewsLetter(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,7500)");
    }

    public void scrollButton(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1500)");
    }

    protected void goBackP() {driver.navigate().back();}
    public void clickElementF(WebElement element) {
        element.click();
    }

    protected void typeIntoF(WebElement element, String value){
        element.sendKeys(value);
    }

    protected void clearTextF(WebElement element){
        element.clear();
    }

    protected void clickF(WebElement element){
        element.click();
    }

    protected void pressSpaceF(WebElement element) {
        element.sendKeys(Keys.SPACE);
    }

    protected void pressEnterF(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

    public void scrollToF(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }
}
