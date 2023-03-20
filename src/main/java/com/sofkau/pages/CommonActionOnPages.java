package com.sofkau.pages;

import com.sofkau.util.TiempoEsperaExplicita;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;

import java.time.Duration;

import static com.sofkau.util.TiempoEsperaExplicita.DIEZ_SEGUNDO;
import static com.sofkau.util.TiempoEsperaExplicita.NUEVE_SEGUNDO;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class CommonActionOnPages {
    private WebDriver driver;

    private By locator;
    private  TiempoEsperaExplicita tiempoEsperaExplicita;
    private WebDriverWait typeWait;

    public CommonActionOnPages(WebDriver driver){
        super();
        this.driver = driver;

    }

    protected void pressEnter (WebElement webElement){
        webElement.sendKeys(Keys.ENTER);
    }

    protected void explicitWaitInit() {
        typeWait = new WebDriverWait(driver, Duration.ofSeconds(NUEVE_SEGUNDO.getValue()));
    }

    protected void esperaExplicita(WebElement webElement){
       WebDriverWait typeWait;
       typeWait = new WebDriverWait(driver, Duration.ofSeconds(90));
       typeWait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public String getTextoFinal(WebElement webElement) {
        esperaExplicita(webElement);
        return webElement.getText();
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
   protected void typeInto(WebElement webElement, String value){
       webElement.sendKeys(value);
   }

    protected void  clickElement(WebElement element){
        element.click();
    }

    protected void waitGeneral(WebElement webElement) {
        typeWait.until(elementToBeClickable(webElement));
    }


    protected void clickcondelay (WebElement webElement){
        esperaExplicita(webElement);
        webElement.click();
    }

    protected  void clearText (WebElement webElement){
        webElement.clear();
    }


    protected void  clearText(By locator){
        driver.findElement(locator).clear();
    }

    protected void  click(By locator){
        driver.findElement(locator).click();
    }
    protected void tab(By locator) {
        driver.findElement(locator).sendKeys(Key.TAB);
    }

    public void scrollTo(By locator){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }
    protected void selectDate(By locator, String value){
        driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a"), value, Keys.ENTER);
    }
    protected void pathFile(By locator, String path){
        driver.findElement(locator).sendKeys(path);
    }

    protected void pressEnter(By locator){
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }
    public void scrollto(By locator){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(locator));
    }


    protected String getText(By locator){
        return driver.findElement(locator).getText();
    }

    protected void presSpace(By locator){
        driver.findElement(locator).sendKeys(Keys.SPACE);
    }
    protected void sendDate(By locator, String value){
        clearText(locator);
        driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a"), value, Keys.ENTER);
    }

    public void setZoom(int zoomLevel){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '" +zoomLevel +"%'");

    }
    public void scroll(int scrollAmount){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String script = "window.scrollBy(0," + scrollAmount + ")";
        jse.executeScript(script);
    }

    /* protected void typeInto(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }
    */

}
