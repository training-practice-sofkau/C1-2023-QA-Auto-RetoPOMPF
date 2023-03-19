package com.sofkau.pages.common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CommonActionOnpages {
    protected WebDriver driver;

    public CommonActionOnpages(WebDriver driver) {
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

    protected void addWaitByVisibilityAllElement(By locator, Duration wait) {
        WebDriverWait await = new WebDriverWait(driver, wait);
        await.until((ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)));
    }

    //accion
    protected void typeInto(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }

    protected void typeInto(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void click(WebElement webElement) {
        webElement.click();
    }

    protected void repeatClick(WebElement webElement, int repeats) {
        for (int i = 0; i < repeats; i++) {
            click(webElement);
        }
    }

    protected void clickWithAccion(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    protected void pressEnter(By locator) {
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    public void scrollTo(By locator) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    public void scrollTo(WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public String getAtributeElement(By locator, String atribute) {
        return driver.findElement(locator).getAttribute(atribute);
    }

    protected String getTex(By locator) {
        return driver.findElement(locator).getText();
    }

    protected String getTex(WebElement webElement) {
        return webElement.getText();
    }

    protected int getTextToInt(WebElement webElement) {
        scrollTo(webElement);
        return Integer.parseInt(getTex(webElement).replaceAll("[-+.^:,$]",
                ""));
    }

    protected int getTextToInt(By locator) {
        scrollTo(locator);
        return Integer.parseInt(getTex(locator).replaceAll("[-+.^:,$]",
                ""));
    }

    protected ArrayList<String> getTextElementsUnic(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        ArrayList<String> elementsText = new ArrayList<>();
        for (WebElement webElement : elements) {
            String detalle = getTex(webElement);
            elementsText.add(detalle);
        }
        return elementsText;
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

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }

    public boolean isTextPresent(String text) {
        return driver.getPageSource().contains(text);
    }
}


/*
        public void navigateToHomePage() {
            driver.get("https://zonafit.co//");
        }

        public void waitForPageLoad() {
            new WebDriverWait(driver, DEFAULT_WAIT_TIME).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        }
               private final Duration DEFAULT_WAIT_TIME = Duration.ofSeconds(15);
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

        private final Duration DEFAULT_WAIT_TIME = Duration.ofSeconds(15);
    ;
    private By botonWhatsappSelector = By.xpath("(//div[@class='joinchat__button__open'])[1]");
    private By botonNecesitasAsesoriaSelector = By.xpath("(//div[@data-start='Abrir el chat'])[1]");

        protected ArrayList<String[]> getTextElements(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        ArrayList<String[]> elementsText = new ArrayList<>();
        for(WebElement webElement: elements){
            String [] detalle = webElement.getText().split("\\n");
            elementsText.add(detalle);
        }
        return elementsText;
    }
        protected  void repeatClick(By locator, int repeats){
        for(int i = 0;i<repeats;i++){
            click(locator);
        }
    }

        protected  void addWaitByPresentDom(By locator, Duration wait){
        WebDriverWait await = new WebDriverWait(driver,wait);
        await.until((ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(locator)))));
    }

 */

