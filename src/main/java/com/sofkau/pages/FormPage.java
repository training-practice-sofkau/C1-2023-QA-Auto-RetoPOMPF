package com.sofkau.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class FormPage extends CommonActionOnPages {
    public FormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }


}
