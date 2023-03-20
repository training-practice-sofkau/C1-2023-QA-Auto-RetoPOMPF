package com.sofkau.page;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class CommonActionOnPage {
    protected WebDriver driver;
    public CommonActionOnPage(WebDriver driver) {
        this.driver = driver;
    }
    protected void typeInto(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }
    protected void clearText(By locator){
        driver.findElement(locator).clear();
    }
    protected void click(By locator){
        driver.findElement(locator).click();
    }
    protected void ponerMouse(String string){
        WebElement categoria = driver.findElement(By.className(string));
        Actions actions=new Actions(driver);
        actions.moveToElement(categoria).perform();
    }
    protected void ponerMouseXpath(String string){
        WebElement categoria = driver.findElement(By.xpath(string));
        Actions actions=new Actions(driver);
        actions.moveToElement(categoria).perform();
    }
    protected void selectDate(By locator, String value){
        driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a"), value, Keys.ENTER);
    }
    protected void scroll(int numero){
        JavascriptExecutor executor=(JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,"+numero+");");
    }
    protected void tab(By locator) {
        driver.findElement(locator).sendKeys(Keys.TAB);
    }
    protected void setZoom (int zoomLevel) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '" + zoomLevel + "%'");
    }
}
