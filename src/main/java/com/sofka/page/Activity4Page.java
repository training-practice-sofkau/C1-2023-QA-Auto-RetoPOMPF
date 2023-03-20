package com.sofka.page;

import com.sofka.model.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class Activity4Page extends CommonActionOnPage{
    private Login login= new Login();


    //localizadores feature4


    @CacheLookup
    @FindBy(xpath = "(//a[@class='nav-top-link nav-top-not-logged-in icon primary button round is-small'])[1]")
    public WebElement option;

    @CacheLookup
    @FindBy(xpath = "(//input[@id='username'])[1]")
    public WebElement username;

    @CacheLookup
    @FindBy(xpath = "(//input[@id='password'])[1]")
    public WebElement password;

    @CacheLookup
    @FindBy(xpath = "(//button[normalize-space()='Acceder'])[1]")
    public WebElement buttonUser;

    public Activity4Page(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickLoguin() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(option));
        wait.until(ExpectedConditions.elementToBeClickable(option));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", option);
        Thread.sleep(200);
    }

     public void fillMandatory2(String correo, String contrasenna) {
     this.username.sendKeys(correo);

     this.password.sendKeys(contrasenna);

     buttonUser.click();

     }
    public boolean isElementPresent(String locator) {
        try {
            driver.findElement(By.xpath(locator));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
