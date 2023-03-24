package com.sofkau.pages;

import com.github.javafaker.Faker;
import com.sofkau.models.Pasajero;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VueloNoDisponiblePage extends CommonActionOnPages{

    public VueloNoDisponiblePage(WebDriver driver) {
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

    private final By diaIda = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[2]/div[3]/div[22]/div");

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[1]/div[1]/div[2]/div/div[2]/div/div/div/div/input")
    private WebElement fechaRegreso;

    /*@CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[3]/div[1]/div[2]/div[1]/div[3]/div[29]/div")
    private WebElement diaRegreso;*/

    private final By diaRegreso = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[1]/div[3]/div[29]/div");

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[1]/div[2]/div[1]/button")
    private WebElement aplicar;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[1]/div[1]/div[4]/div/div/div/div/input")
    private WebElement pasajeros;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[3]/div/div/div[1]/div[1]/div[2]/div/button[2]")
    private WebElement cantidadPasajeros;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[3]/div/div/div[2]/div[2]/div/div/div/select")
    private WebElement clase;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[3]/div/div/div[3]/a/em")
    private WebElement aplicarPasajeros;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[1]/div[1]/div[3]/span/span/label/span[1]")
    private WebElement cualquierFecha;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[3]/button")
    private WebElement buscar;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"disambiguated-banner-position\"]/disambiguated-banner/div/div/div[2]/div[1]/h3")
    private WebElement mensaje;


    public void clickVuelo() throws InterruptedException {
        click(inicio);
    }

    public void closeLogin() throws InterruptedException {
        Thread.sleep(200);
        cLogin.click();
    }

    public static Pasajero generarPasajeroColombiano() {
        Faker faker = new Faker();

        Pasajero pasajero = new Pasajero();
        pasajero.setNombres(faker.name().firstName());
        pasajero.setApellidos(faker.name().lastName());
        pasajero.setDocumento(faker.number().digits(10));
        pasajero.setCorreo(faker.internet().emailAddress());
        pasajero.setTelefono("31" + faker.number().digits(8));
        pasajero.setDireccion(faker.address().fullAddress());

        return pasajero;
    }

    public void fillMandatoryFields() throws InterruptedException {

        Pasajero pasajero1 = generarPasajeroColombiano();
        Pasajero pasajero2 = generarPasajeroColombiano();
        Pasajero pasajero3 = generarPasajeroColombiano();

        closeLogin();

        click(origen);
        clearText(origen);
        origen.sendKeys("Pereira", Keys.ARROW_DOWN);
        clickcondelay(listaOrigen);

        click(destino);
        clearText(destino);
        destino.sendKeys("San Andres", Keys.ARROW_DOWN);
        clickcondelay(listaDestino);

        scroll(200);

        click(fechaIda);
        click(fechaIda);

        clickPOM(diaIda);

        click(fechaRegreso);
        click(fechaRegreso);


        clickPOM(diaRegreso);


        click(aplicar);

        esperaExplicita(pasajeros);

        click(pasajeros);
        clickcondelay(cantidadPasajeros);
        clickcondelay(cantidadPasajeros);

        click(clase);

        for(int i = 0; i < 4; i++) {
            clase.sendKeys(Keys.ARROW_DOWN);
        }

        clickcondelay(clase);

        clickcondelay(aplicarPasajeros);

        clickcondelay(buscar);

    }

    public String verMensaje(){
        return getTextoFinal(mensaje);
    }

}
