package com.sofkau.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.sofkau.util.TiemposWait.TEN_SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class CommonActionOnPages {

    private final WebDriver driver;
    private WebDriverWait typeWait;


    public CommonActionOnPages(WebDriver driver) {
        this.driver = driver;
        explicitWaitInit();
    }

    protected void esperaExplicita(WebElement webElement) {
        typeWait = new WebDriverWait(driver, Duration.ofSeconds(TEN_SECONDS.getValue()));
        typeWait.until(ExpectedConditions.visibilityOf(webElement));
    }


    protected void explicitWaitInit() {
        typeWait = new WebDriverWait(driver, Duration.ofSeconds(TEN_SECONDS.getValue()));
    }

    protected void explicitWaitInit(WebElement webElement) {
        typeWait = new WebDriverWait(driver, Duration.ofSeconds(TEN_SECONDS.getValue()));
        typeWait.until(ExpectedConditions.visibilityOf(webElement));
    }


    protected void waitGeneral(WebElement webElement) {
        typeWait.until(elementToBeClickable(webElement));
    }


    protected void clearText(WebElement webElement) {
        typeWait.until(elementToBeClickable(webElement)).clear();
    }


    protected void typeInto(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }

    protected void click(WebElement webElement) {
        typeWait.until(elementToBeClickable(webElement)).click();

    }

    protected void selectComboox(WebElement webElement) {
        webElement.sendKeys(Keys.ENTER, Keys.ARROW_DOWN, Keys.ENTER);
    }


    protected void clickcondelay(WebElement webElement) {
        esperaExplicita(webElement);
        webElement.click();
    }


    public void scroll(int scrollAmount) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String script = "window.scrollBy(0," + scrollAmount + ")";
        jse.executeScript(script);
    }


    public String getTextoFinal(WebElement webElement) {
        esperaExplicita(webElement);
        return webElement.getText();
    }

}
