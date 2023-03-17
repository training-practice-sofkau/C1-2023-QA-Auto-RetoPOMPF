package com.sofkau.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends CommonActionOnpages {

    //localizadores de entrada
    @CacheLookup
    @FindBy(xpath = "(//a)[127]")
    private WebElement btnFinalizarCompra;
    //constructor
    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,CartPage.this);
    }
    public void pressBtnCompra(){
        addWaitByVisibility(btnFinalizarCompra,10);//se espera a que se agreguen todos los productos
        scrollTo(btnFinalizarCompra);
        click(btnFinalizarCompra);
    }
}
