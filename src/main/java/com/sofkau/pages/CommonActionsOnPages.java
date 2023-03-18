package com.sofkau.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonActionsOnPages {
    private WebDriver driver;
    public CommonActionsOnPages(WebDriver driver){this.driver = driver;}

    protected void click(WebElement webElement){
        webElement.click();
    }

    protected void pressEnter(WebElement webElement){
        webElement.sendKeys(Keys.ENTER);
    }

    protected void typeInto(WebElement webElement, String value){
        webElement.sendKeys(value);
    }

    public void setZoom(int zoomLevel) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '" + zoomLevel + "%'");
    }
}
