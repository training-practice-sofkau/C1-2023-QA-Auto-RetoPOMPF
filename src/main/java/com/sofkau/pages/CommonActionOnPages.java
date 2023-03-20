package com.sofkau.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.sofkau.util.ValorTiempoEspera.*;

public class CommonActionOnPages {

    private WebDriver driver;
    private WebDriverWait typeWait;

    public CommonActionOnPages(WebDriver driver) {
        this.driver = driver;
        WebDriverWait typeWait;
    }


    protected void typeInto(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }

    protected void scrollDown(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    protected void clearText(WebElement webElement) {
        webElement.clear();
    }

    protected void pressEnter(WebElement webElement) {
        webElement.sendKeys(Keys.ENTER);
    }

    protected void pressSpace(WebElement webElement) {
        webElement.sendKeys(Keys.SPACE);
    }

    protected void click(WebElement webElement) {
        webElement.click();
    }



    protected void esperaExplicita(WebElement webElement) {
        typeWait = new WebDriverWait(driver, Duration.ofSeconds(CUARENTA.getValor()));
        typeWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void esperaImplicita(WebElement webElement) {
        typeWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void clickcondelay(WebElement webElement) {
        esperaExplicita(webElement);
        webElement.click();
    }


      protected String getText (WebElement webElement) {
        esperaExplicita(webElement);
        return webElement.getText();
    }




    public void scroll(int scrollAmount) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String script = "window.scrollBy(0," + scrollAmount + ")";
        jse.executeScript(script);
    }


    protected void typeWithDelay(WebElement webElement, String text, int delayInMilliseconds) {
        esperaExplicita(webElement);
        webElement.click();
        for (char c : text.toCharArray()) {
            webElement.sendKeys(Character.toString(c));
            try {
                Thread.sleep(delayInMilliseconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }




    protected void typeInto(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }

    protected void clearText(By locator) {
        driver.findElement(locator).clear();
    }

    protected void pressEnter(By locator) {
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    protected void pressSpace(By locator) {
        driver.findElement(locator).sendKeys(Keys.SPACE);
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void calendar(By locator, String fecha) {
        driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a"), fecha, Keys.ENTER);
    }

    private void esperaExplicita() {
        typeWait = new WebDriverWait(driver, Duration.ofSeconds(CUARENTA.getValor()));
    }


    protected void esperaImplicita(By locator) {
        typeWait.until(ExpectedConditions.elementToBeClickable(locator));
    }




}