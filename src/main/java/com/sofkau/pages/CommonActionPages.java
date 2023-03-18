package com.sofkau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonActionPages {

    protected WebDriver driver;
    private HomePage homePage;
    private final Duration DEFAULT_WAIT_TIME = Duration.ofSeconds(15);
    ;


    private By botonWhatsappSelector = By.xpath("(//div[@class='joinchat__button__open'])[1]");
    private By botonNecesitasAsesoriaSelector = By.xpath("(//div[@data-start='Abrir el chat'])[1]");

    public CommonActionPages(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBotonWhatsapp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement botonWhatsapp = wait.until(ExpectedConditions.visibilityOfElementLocated(botonWhatsappSelector));
        botonWhatsapp.click();
    }

    public void clickBotonNecesitasAsesoria() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement botonNecesitasAsesoria = wait.until(ExpectedConditions.visibilityOfElementLocated(botonNecesitasAsesoriaSelector));
        botonNecesitasAsesoria.click();
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }

    public void navigateToHomePage() {
        driver.get("https://zonafit.co//");
    }

    public void waitForPageLoad() {
        new WebDriverWait(driver, DEFAULT_WAIT_TIME).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public boolean isTextPresent(String text) {
        return driver.getPageSource().contains(text);
    }
}







