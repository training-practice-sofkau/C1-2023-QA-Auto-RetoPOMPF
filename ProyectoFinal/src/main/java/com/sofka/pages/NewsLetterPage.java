package com.sofka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewsLetterPage extends CommonActionOnPage{
    private WebDriver webDriver;

    private final By email = By.id("mce-EMAIL");
    private final By name = By.id("mce-FNAME");
    private final By phone = By.id("mce-MMERGE4");
    private final By buttonSubscribe = By.id("mc-embedded-subscribe");
    private final By message = By.xpath("//div[contains(@id,'mc_embed_signup')]//div[contains(@id,'mce-responses')]//div[contains(@id,'mce-success-response')]");

    public NewsLetterPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void formComplete(){
        scrollNewsLetter();
        clearTextP(email);
        typeIntoP(email, "ganoxo6430@huvacliq.com");
        clearTextP(name);
        typeIntoP(name, "Gabriela Montoya");
        clearTextP(phone);
        typeIntoP(phone, "3110271465");
        clickP(buttonSubscribe);
    }

    public WebElement getConfirmationMessage (WebDriver webDriver){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(message));
    }
}