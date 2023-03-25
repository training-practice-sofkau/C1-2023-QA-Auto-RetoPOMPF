package com.sofkau.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonActions {
    private final WebDriver driver;

    public CommonActions(WebDriver driver) {
        this.driver = driver;
    }

    protected void explicitWait (WebElement element){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void click(WebElement element) {
        element.click();
    }

    protected void scroll(int lines) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String script = "window.scrollBy(0," + lines + ")";
        jse.executeScript(script);
    }

    protected String getText(WebElement element) {
        explicitWait(element);
        return element.getText();
    }

    protected void delayClick(WebElement element) {
        explicitWait(element);
        element.click();
    }

    protected void type(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected void tab(WebElement element) {
        explicitWait(element);
        element.sendKeys(Keys.TAB);
    }

    protected void enter(WebElement element) {
        explicitWait(element);
        element.sendKeys(Keys.ENTER);
    }
}