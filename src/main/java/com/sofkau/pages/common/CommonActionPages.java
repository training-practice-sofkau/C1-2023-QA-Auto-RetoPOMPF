package com.sofkau.pages.common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;

public class CommonActionPages {

    protected static WebDriver driver;
    private WebDriverWait wait;

    public CommonActionPages(WebDriver driver) {

        this.driver = driver;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    protected void presionarEspacio(By locator) {
        driver.findElement(locator).sendKeys(Keys.SPACE);
    }

    protected void scroll(int numero) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0," + numero + ");");
    }
    protected static String getText(By locator) {
        return driver.findElement(locator).getText();
    }
    protected void typeInto(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }

    protected void explicitWaitTime(WebElement webElement) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    protected void click(WebElement webElement) {
        webElement.click();
    }

    private By botonWhatsappSelector = By.xpath("(//div[@class='joinchat__button__open'])[1]");
    private By botonNecesitasAsesoriaSelector = By.xpath("(//div[@class='joinchat__agent__image'])[1]");

    public void clickBotonWhatsapp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement botonWhatsapp = wait.until(ExpectedConditions.visibilityOfElementLocated(botonWhatsappSelector));
        botonWhatsapp.click();
    }

    public void clickBotonNecesitasAsesoria() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement botonNecesitasAsesoria = wait.until(ExpectedConditions.visibilityOfElementLocated(botonNecesitasAsesoriaSelector));
        botonNecesitasAsesoria.click();
    }
}


