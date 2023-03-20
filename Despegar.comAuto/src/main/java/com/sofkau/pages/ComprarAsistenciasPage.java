package com.sofkau.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ComprarAsistenciasPage extends CommonActions {
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"slider_id_1\"]/swiper/div/div[2]/new-assistance/div/div[2]/pricebox/div/div/div[1]/div[2]/button")
    public static WebElement buyBttn;

    public ComprarAsistenciasPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void buyRecommended() {
        scroll(700);
        click(buyBttn);
    }
}