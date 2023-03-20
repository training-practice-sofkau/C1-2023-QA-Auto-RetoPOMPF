package com.sofka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CompraCategoriaPage extends CommonActionOnPage{
    private WebDriver webDriver;

    private final By optionProducts = By.xpath("//a[@class='dashicons-plus-alt2 mega-menu-link']");

    public CompraCategoriaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addProducts(){
        //mouseOver(optionProducts);
    }
}
