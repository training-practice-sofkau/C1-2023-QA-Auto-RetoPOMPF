package com.sofkau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VueloPage extends CommonActionOnPages {

    private static final int TIMEOUT_SECONDS = 10;

    public VueloPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Localizadores
     */
    @CacheLookup
    @FindBy(xpath = "/html/body/nav/div[2]/div/div[3]/ul/li[2]/a/div")
    private WebElement inicio;

    @CacheLookup
    @FindBy(xpath = "/html/body/nav/div[4]/div[1]/i")
    public WebElement cLogin;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[1]/div[1]/div[1]/div/div[1]/div[1]/div/input")
    private WebElement origen;

    @CacheLookup
    @FindBy(xpath = "(//span[contains(@class, 'item-text')])[1]")
    private WebElement listaOrigen;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[1]/div[1]/div[1]/div/div[2]/div/div/input")
    private WebElement destino;

    @CacheLookup
    @FindBy(xpath = "(//span[contains(@class, 'item-text')])[1]")
    private WebElement listaDestino;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[1]/div[1]/div[2]/div/div[1]/div/div/div/div/input")
    private WebElement fechaIda;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[3]/div[1]/div[2]/div[2]/div[3]/div[22]/div")
    private WebElement diaIda;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[1]/div[1]/div[2]/div/div[2]/div/div/div/div/input")
    private WebElement fechaRegreso;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[3]/div[1]/div[2]/div[1]/div[3]/div[29]/div")
    private WebElement diaRegreso;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[3]/div[2]/div[1]/button")
    private WebElement aplicar;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[1]/div[1]/div[3]/span/span/label/span[1]")
    private WebElement cualquierFecha;



    public void clickVuelo() throws InterruptedException {
        click(inicio);
    }

    public void closeLogin() throws InterruptedException {
        Thread.sleep(200);
        cLogin.click();
    }

    public void fillMandatoryFields() throws InterruptedException {

        closeLogin();

        click(origen);
        clearText(origen);
        origen.sendKeys("Armenia", Keys.ARROW_DOWN);
        clickcondelay(listaOrigen);

        click(destino);
        clearText(destino);
        destino.sendKeys("Santa Marta", Keys.ARROW_DOWN);
        clickcondelay(listaDestino);

        click(fechaIda);

        clickcondelay(diaIda);
        click(fechaRegreso);

        clickcondelay(diaRegreso);

        scroll(200);

        click(aplicar);



    }

}
