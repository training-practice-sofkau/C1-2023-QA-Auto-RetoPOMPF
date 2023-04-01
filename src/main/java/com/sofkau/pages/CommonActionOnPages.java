package com.sofkau.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.sofkau.util.Espera.CIENTOVEINTE;

public class CommonActionOnPages {

    protected WebDriver driver;

    public CommonActionOnPages(WebDriver driver) {
        this.driver = driver;
        WebDriverWait typeWait;
    }

    protected void typeInto(WebElement element, String value){
        element.sendKeys(value);
    }

    protected void clearText(WebElement element){
        element.clear();
    }

    protected void click(WebElement element){
        element.click();
    }

    protected void clickPOM(By locator) throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(locator).click();
    }

    protected void clickcondelay (WebElement webElement){
        esperaExplicita(webElement);
        webElement.click();
    }

    protected void enter(WebElement element){
        element.sendKeys(Keys.ENTER);
    }


    public void setZoom(int zoomLevel) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '" + zoomLevel + "%'");
    }

    protected void esperaExplicita (WebElement webElement){
        WebDriverWait typeWait = new WebDriverWait(driver, Duration.ofSeconds(CIENTOVEINTE.getValor()));
        typeWait.until(ExpectedConditions.visibilityOf(webElement));
    }


    public void scroll(int scrollAmount){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String script = "window.scrollBy(0," + scrollAmount + ")";
        jse.executeScript(script);
    }

    public String getTextoFinal(WebElement webElement) {
        esperaExplicita(webElement);
        return webElement.getText();
    }
}
