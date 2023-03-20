package com.sofkau.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.sofkau.util.LimitTimeWait.*;

public class CommonActionOnPages {

    public static List<String> datosIngresados;
    protected WebDriver driver;

    private WebDriverWait typeWait;
    public CommonActionOnPages(WebDriver driver){
        this.driver=driver;
        explicitWaitInit();
    }
    private void explicitWaitInit () {
        typeWait = new WebDriverWait(driver, TEN_SECONDS.getValue());
    }
    protected void typeInto(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }

    protected void typeInto(WebElement webElement,String value){
        webElement.sendKeys(value);
    }
    protected void clearText(By locator){
        driver.findElement(locator).clear();
    }
    protected void click(By locator){
        driver.findElement(locator).click();
    }

    protected void click(WebElement webElement){
        //webElement.click();
        typeWait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    protected void pressEnter(By locator) {
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }
    protected void pressDown(By locator){
        driver.findElement(locator).sendKeys(Keys.DOWN);
    }

    protected void pressEnter(WebElement webElement){
        webElement.sendKeys(Keys.ENTER);
    }
    protected void pressDown(WebElement webElement){
        webElement.sendKeys(Keys.DOWN);
    }
    protected void clickDown(WebElement webElement){
        webElement.click();
        pressDown(webElement);
        pressEnter(webElement);
    }
    protected void pressSpace(By locator){
        driver.findElement(locator).sendKeys(Keys.SPACE);
    }
    protected  String getText (By locator){
        return driver.findElement(locator).getText();
    }
    public void scrollTo(By locator){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    public void CambiarPestana(){
        driver.switchTo().defaultContent();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

    protected void implicitWait(int segundos) {
        driver.manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);}


}
