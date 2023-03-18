package com.sofkau.pages;

import com.sofkau.pages.common.CommonActionOnpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class PagCarrito extends CommonActionOnpages {

    //localizadores de entrada
    @CacheLookup
    @FindBy(xpath = "//a[@class=\"checkout-button button alt wc-forward\" ]")
    private WebElement btnFinalizarCompra;
    //constructor
    public PagCarrito(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, PagCarrito.this);
    }
    public void pressFinalizeBuy(){
        addWaitByVisibility(btnFinalizarCompra, Duration.ofSeconds(10));//se espera a que se agregen todos los productos
        scrollTo(btnFinalizarCompra);
        click(btnFinalizarCompra);
    }
}
