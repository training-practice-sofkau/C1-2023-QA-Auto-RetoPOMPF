package com.sofkau.pages;

import com.sofkau.pages.common.CommonActionOnpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CheckPag extends CommonActionOnpages {
    private static final String MENSAJE_ESPERADO_CONFIRMACION = "Gracias. Tu pedido ha sido recibido.";
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/div/div/div[2]/div/p/strong")
    private WebElement mensajeConfirmacion;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/div/div/div[2]/div/ul/li[3]/strong/span")
    private WebElement precioFactura;

    //constructor
    public CheckPag(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, CheckPag.this);
    }

    public int getPrecioTotalFactura(){
        addWaitByVisibility(precioFactura, Duration.ofSeconds(15));
        return getTextToInt(precioFactura);
    }

    public boolean isDisplayMessageConfirmBuy(){
        addWaitByVisibility(precioFactura, Duration.ofSeconds(15));
        return getTex(mensajeConfirmacion).equals(MENSAJE_ESPERADO_CONFIRMACION);
    }
}
