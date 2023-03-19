package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class CommonActionsOnPages {
    private WebDriver driver;
    protected WebDriverWait wait;


    public CommonActionsOnPages(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    protected void typeInto(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }

    protected void clearText(By locator) {
        driver.findElement(locator).clear();
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }
    protected void doubleClick(By locator) {
        driver.findElement(locator).click();
        driver.findElement(locator).click();
    }

    protected void pressEnter(By locator) {
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    protected void pressSpace(By locator) {
        driver.findElement(locator).sendKeys(Keys.SPACE);
    }

    protected void pressTab(By locator) {
        driver.findElement(locator).sendKeys(Keys.TAB);
    }

    protected void typeIntoAndEsc(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
        driver.findElement(locator).sendKeys(Keys.ESCAPE);
    }

    protected void typeIntoAndEnter(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    protected void dateInput(By locator) {
        driver.findElement(locator).isEnabled();
    }

    protected void implicitWait(long segundos) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(segundos));
    }
    protected void explicitWait(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void switchTab(){
        driver.switchTo().defaultContent();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }
    public void scrollTo(By locator){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }
    }

