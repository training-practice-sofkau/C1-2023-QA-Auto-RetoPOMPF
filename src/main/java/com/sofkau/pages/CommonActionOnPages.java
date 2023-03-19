package com.sofkau.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;

import java.time.Duration;

import static com.sofkau.util.Espera.*;

public class CommonActionOnPages {

    protected WebDriver driver;

    public CommonActionOnPages(WebDriver driver) {
        this.driver = driver;
        WebDriverWait typeWait;
    }

    protected void typeInto(WebElement element, String value){
        element.sendKeys(value);
    }
    protected void typeIntoOp(WebElement element, String value){
        element.sendKeys(value);
    }

    protected void clearText(WebElement element){
        element.clear();
    }

    protected void click(WebElement locator){
        locator.click();
    }

    protected void clickcondelay (WebElement webElement){
        esperaExplicita(webElement);
        webElement.click();
    }

    protected void seleccionUno(WebElement locator){
        locator.sendKeys(Keys.ARROW_DOWN);
    }


    protected void space(By locator){
        driver.findElement(locator).sendKeys(Keys.SPACE);
    }

    protected void enter(WebElement element){
        element.sendKeys(Keys.ENTER);
    }


    protected void tab(By locator) {
        driver.findElement(locator).sendKeys(Key.TAB);
    }

    protected void selectDate(By locator, String value){
        driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a"), value, Keys.ENTER);
    }



    public void setZoom(int zoomLevel) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '" + zoomLevel + "%'");
    }

    protected void esperaExplicita (WebElement webElement){
        WebDriverWait typeWait = new WebDriverWait(driver, Duration.ofSeconds(CINCO.getValor()));
        typeWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void scroll(int scrollAmount){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String script = "window.scrollBy(0," + scrollAmount + ")";
        jse.executeScript(script);
    }
}
