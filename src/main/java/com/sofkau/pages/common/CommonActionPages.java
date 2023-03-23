package com.sofkau.pages.common;

import org.openqa.selenium.*;
<<<<<<< HEAD
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

=======
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
>>>>>>> main

public class CommonActionPages {

    protected static WebDriver driver;
    private WebDriverWait wait;

    public CommonActionPages(WebDriver driver) {

        this.driver = driver;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

<<<<<<< HEAD
    public void scrollTo(By locator) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("argument[0].scrollIntoView();", driver.findElement(locator));

    }
=======
>>>>>>> main
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

<<<<<<< HEAD
=======
    protected void presionarEspacio(By locator) {
        driver.findElement(locator).sendKeys(Keys.SPACE);
    }
>>>>>>> main

    protected void scroll(int numero) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0," + numero + ");");
    }
<<<<<<< HEAD

    protected static String getText(By locator) {
        return driver.findElement(locator).getText();
    }

=======
    protected static String getText(By locator) {
        return driver.findElement(locator).getText();
    }
>>>>>>> main
    protected void typeInto(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }

<<<<<<< HEAD
    public void borrarTexto(WebElement webElement) {
        webElement.clear();
    }

    public void scrollDown(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,20000)");
    }



    protected void explicitWaitTime(WebElement webElement) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

=======
    protected void explicitWaitTime(WebElement webElement) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
>>>>>>> main
    protected void click(WebElement webElement) {
        webElement.click();
    }

<<<<<<< HEAD
    public void scrollTo(WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    protected String getTex(By locator) {
        return driver.findElement(locator).getText();
    }

    protected static String getText(WebElement webElement) {
        return webElement.getText();
    }

    protected String getTex(WebElement webElement) {
        return webElement.getText();
    }

=======
>>>>>>> main
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
<<<<<<< HEAD

    public boolean isTextPresent(String text) {
        return driver.getPageSource().contains(text);

    }
    public String getText() {
        return driver.findElement(By.tagName("body")).getText();
    }


    public boolean isSuscriptionMessagePresent() {
        WebElement suscriptionMessage = driver.findElement(By.xpath("(//div[@id='mce-success-response'])"));
        return suscriptionMessage.isDisplayed();
    }

    protected void addWaitByVisibilityAllElement(By locator, Duration wait) {
        WebDriverWait await = new WebDriverWait(driver, wait);
        await.until((ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)));
    }

    //accion
    protected void typeInto(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
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

    public String getAtributeElement(By locator, String atribute) {
        return driver.findElement(locator).getAttribute(atribute);
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
    protected void ponerMouse(String string) {
        WebElement categoria = driver.findElement(By.className(string));
        Actions actions = new Actions(driver);
        actions.moveToElement(categoria).perform();
    }

    protected void explicitWaitTime(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    protected void addWaitByVisibility(By locator, Duration wait) {
        WebDriverWait await = new WebDriverWait(driver, wait);
        await.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void addWaitByVisibility(WebElement webElement, Duration wait) {
        WebDriverWait await = new WebDriverWait(driver, wait);
        await.until(ExpectedConditions.visibilityOf(webElement));
    }
    public void borrarTexto(By locator) {   //ok
        driver.findElement(locator).clear();
    }

}



=======
}


>>>>>>> main
