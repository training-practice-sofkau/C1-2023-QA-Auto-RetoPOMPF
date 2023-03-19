package com.sofkau.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompraVueloPage extends CommonActionOnPages {

    @CacheLookup
    @FindBy (xpath="//a[@title='Vuelos']//div[@class='button-content']")
    private WebElement selectorBotonVuelos;

    @CacheLookup
    @FindBy (xpath="//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[1]/div[1]/div[1]/div/div[1]/div[1]/div/input")
    private WebElement selectorOringen;

    @CacheLookup
    @FindBy (xpath="(//span[contains(@class, 'item-text')])[1]")
    private WebElement SelectorConfirmacionOrigen;

    @CacheLookup
    @FindBy (xpath="//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[1]/div[1]/div[1]/div/div[2]/div/div/input")
    private WebElement selectorDestino;

    @CacheLookup
    @FindBy  (xpath="(//span[contains(@class, 'item-text')])[1]")
    private WebElement SelectorConfirmacionDestino;







    public CompraVueloPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void FillMandatoryFields() {
        click(selectorBotonVuelos);
        clearText(selectorOringen);
        click(selectorOringen);
        typeInto(selectorOringen, "Barranquilla");


    }


    public void filtrarOrigen ( String destino){
        System.out.println(" Imprime algo pls " );
        click (selectorOringen);
        clearText(selectorOringen);
        selectorOringen.sendKeys(destino,Keys.ARROW_DOWN);
        selectorOringen.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        clickcondelay(SelectorConfirmacionOrigen);
    }


    public void filtrarDestino ( String destino){



        click(selectorDestino);
        typeInto(selectorOringen, "Bogota");

        System.out.println(" Imprime algo pls " );
        click (selectorDestino);
        clearText(selectorDestino);
        selectorDestino.sendKeys(destino,Keys.ARROW_DOWN);
        selectorDestino.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        clickcondelay(SelectorConfirmacionDestino);
    }

}
