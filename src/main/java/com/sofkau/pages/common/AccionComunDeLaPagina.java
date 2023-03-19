package com.sofkau.pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AccionComunDeLaPagina {

    protected static WebDriver driver;
    private WebDriverWait wait;

    public AccionComunDeLaPagina(WebDriver driver) {

        this.driver = driver;
    }

    protected void addWaitByVisibility(By locator, Duration wait) {
        WebDriverWait await = new WebDriverWait(driver, wait);
        await.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void addWaitByVisibility(WebElement webElement, Duration wait) {
        WebDriverWait await = new WebDriverWait(driver, wait);
        await.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void escribir(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }

    public void borrarTexto(By locator) {   //ok
        driver.findElement(locator).clear();
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void scrollTo(By locator) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("argument[0].scrollIntoView();", driver.findElement(locator));

    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2800);");
    }

    protected void scroll(int numero) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0," + numero + ");");
    }
    protected void ponerMouse(String string){
        WebElement categoria = driver.findElement(By.className(string));
        Actions actions=new Actions(driver);
        actions.moveToElement(categoria).perform();
    }

    protected static String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    protected void explicitWaitTime(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void escribir(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }

    public void borrarTexto(WebElement webElement) {
        webElement.clear();
    }

    public void click(WebElement webElement) {
        webElement.click();
    }


    public void scrollTo(WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("argument[0].scrollIntoView();", webElement);
    }


    public void scrollDown(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,20000)");
    }

    protected static String getText(WebElement webElement) {
        return webElement.getText();
    }

    protected void explicitWaitTime(WebElement webElement) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}

