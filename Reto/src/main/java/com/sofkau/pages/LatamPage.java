package com.sofkau.pages;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class LatamPage extends CommonActionOnPages{

    public static String confrimarFlujo1;
    Faker faker = new Faker();
    public static List<String> pasajero=new ArrayList<>();
    public void crearPasajero(){
        pasajero.clear();

        pasajero.add(faker.name().firstName());
        pasajero.add(faker.name().firstName());
        int numero = faker.number().numberBetween(01,28);
        if(numero<10){
            String dia=String.valueOf(numero);
            pasajero.add("0"+dia);
        }else{
            pasajero.add(String.valueOf(numero));
        }
        numero=faker.number().numberBetween(01,12);
        if(numero<10){
            String dia=String.valueOf(numero);
            pasajero.add("0"+dia);
        }else{
            pasajero.add(String.valueOf(numero));
        }
        pasajero.add(String.valueOf(faker.number().numberBetween(1950,2000)));
        pasajero.add(String.valueOf(faker.number().numberBetween(1115086000,1115086999)));
        pasajero.add(String.valueOf(faker.number().numberBetween(1,3)));


    }

    @CacheLookup
    @FindBy(id="txtInputOrigin_field")
    private WebElement origen;

    @CacheLookup
    @FindBy(id="btnItemAutoComplete_0")
    private WebElement ciudadOrigen;

    @CacheLookup
    @FindBy(id="txtInputDestination_field")
    private WebElement llegada;
    @CacheLookup
    @FindBy(id="btnItemAutoComplete_0")
    private WebElement ciudadLlegada;

    @CacheLookup
    @FindBy(id="departureDate")
    private WebElement fechaSalida;

    @CacheLookup
    @FindBy(css ="div.CalendarMonthGrid_month__horizontal:nth-child(3) > div:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(5) > span:nth-child(1)")
    private WebElement numFechaSalida;

    @CacheLookup
    @FindBy(css ="div.CalendarMonthGrid_month__horizontal:nth-child(4) > div:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)")
    private WebElement numFechaLlegada;
    @CacheLookup
    @FindBy(id="WrapperCardFlight0")
    private WebElement seleccionarVueloIda;

    @CacheLookup
    @FindBy(id="WrapperCardFlight0")
    private WebElement seleccionarVueloVuelta;

    @CacheLookup
    @FindBy(id="btnAddPassengerCTA")
    private WebElement seleccionPasajeros;

    @CacheLookup
    @FindBy(id="btnPlusAdults")
    private WebElement sumarAdulto;


    public LatamPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(id="btnSearchCTA")
    private WebElement buscar;

    @CacheLookup
    @FindBy(id=":Rp5:")
    private WebElement prueba;

    @CacheLookup
    @FindBy(id="bundle-detail-0-flight-select")
    private WebElement seleccionarBasicIda;
    @CacheLookup
    @FindBy(id="bundle-detail-0-flight-select")
    private WebElement seleccionarBasicVuelta;

    @CacheLookup
    @FindBy(id="button9")
    private WebElement irAsientos;

    @CacheLookup
    @FindBy(id="btn-next-flight")
    private WebElement siguienteVuelo;

    @CacheLookup
    @FindBy(id="btn-confirm-and-continue")
    private WebElement continuar;
    @CacheLookup
    @FindBy(id="buttonChooseLater")
    private WebElement asientoAliatorio;

    @CacheLookup
    @FindBy(id="button-cart-confirm")
    private WebElement continuarMaletas;

    @CacheLookup
    @FindBy(id="passengerDetails-firstName-ADT_1")
    private WebElement ponerNombre;

    @CacheLookup
    @FindBy(id="passengerDetails-lastName-ADT_1")
    private WebElement ponerApellido;

    @CacheLookup
    @FindBy(id="passengerInfo-dateOfBirth-ADT_1")
    private WebElement ponerFecha;
    @CacheLookup
    @FindBy(id="documentInfo-documentNumber-ADT_1")
    private WebElement ponerId;
    @CacheLookup
    @FindBy(id="passengerInfo-emails-ADT_1")
    private WebElement ponerCorreo;
    @CacheLookup
    @FindBy(id="mui-component-select-passengerInfo.gender")
    private WebElement genero;

    @CacheLookup
    @FindBy(css=".MuiButtonBase-root.MuiListItem-root.MuiMenuItem-root.sc-fzqAui.xBvvB.MuiMenuItem-gutters.MuiListItem-gutters.MuiListItem-button[tabindex='-1']")
    private WebElement femenino;

    @CacheLookup
    @FindBy(id="passengerInfo-phones0-number-ADT_1")
    private WebElement ponerCelular;

    @CacheLookup
    @FindBy(id="repeatContactData-ADT_1-label")
    private WebElement repetirInfo;

    @CacheLookup
    @FindBy(id="passengerFormSubmitButtonADT_1")
    private WebElement guardarPasajero;

    @CacheLookup
    @FindBy(id="undefined--button-wrapper")
    private WebElement continuarPago;

    @CacheLookup
    @FindBy(id="FormCreditCardaddCreditCard")
    private WebElement tarjetaCredito;

    @CacheLookup
    @FindBy(id="saveButton")
    private WebElement agregarTarjeta;

    public void esperar(int segundos){
        try {
            Thread.sleep(segundos);
        }catch (Exception e){
        }
    }
    public void navigatePage(int cantidad, String ciudadsalida, String ciudadllegada) throws InterruptedException {
        typeInto(origen,ciudadsalida);
        click(ciudadOrigen);
        click(llegada);
        typeInto(llegada,ciudadllegada);
        esperar(1000);
        click(ciudadLlegada);
        click(fechaSalida);
        click(numFechaSalida);
        click(numFechaLlegada);
        click(seleccionPasajeros);
        for(int i=1;i<=cantidad-1;i++){
            click(sumarAdulto);
        }
        click(buscar);
        driver.getCurrentUrl();
        CambiarPestana();
        driver.getCurrentUrl();
        click(seleccionarVueloIda);
        click(seleccionarBasicIda);
        System.out.println("ola");

        esperar(5000);
        System.out.println("ola1");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        click(seleccionarVueloVuelta);
        click(seleccionarBasicVuelta);
        click(irAsientos);
        esperar(7000);
        click(siguienteVuelo);
        click(continuar);
        click(asientoAliatorio);
        click(continuarMaletas);
        esperar(10000);
        for(int i=1;i<=cantidad;i++){
            crearPasajero();
            esperar(3000);
            click(By.id("passengerDetails-firstName-ADT_"+String.valueOf(i)));
            typeInto(By.id("passengerDetails-firstName-ADT_"+String.valueOf(i)),pasajero.get(0));
            typeInto(By.id("passengerDetails-lastName-ADT_"+String.valueOf(i)),pasajero.get(1));
            typeInto(By.id("passengerInfo-dateOfBirth-ADT_"+String.valueOf(i)),pasajero.get(2)+"-");
            typeInto(By.id("passengerInfo-dateOfBirth-ADT_"+String.valueOf(i)),pasajero.get(3)+"-");
            typeInto(By.id("passengerInfo-dateOfBirth-ADT_"+String.valueOf(i)),pasajero.get(4));
            click(By.id("documentInfo-documentNumber-ADT_"+String.valueOf(i)));
            typeInto(By.id("documentInfo-documentNumber-ADT_"+String.valueOf(i)),pasajero.get(5));
            System.out.println(pasajero.get(6));
            /*if(pasajero.get(6).equals("2")){
                click(genero);
                esperar(1000);
                click(By.cssSelector(".MuiButtonBase-root.MuiListItem-root.MuiMenuItem-root.sc-fzqAui.xBvvB.MuiMenuItem-gutters.MuiListItem-gutters.MuiListItem-button[tabindex='-1']"));

            }*/
            if(i==1){
                click(ponerCorreo);
                typeInto(ponerCorreo,"estiven.tr96@gmail.com");
                click(repetirInfo);
                click(ponerCelular);
                typeInto(ponerCelular,"3136543214");
                pressEnter(ponerCelular);
                esperar(3000);
            }else{
                //click(ponerId);
                pressEnter(By.id("documentInfo-documentNumber-ADT_"+String.valueOf(i)));
                esperar(3000);
            }
        }
        esperar(1000);
        click(continuarPago);
        esperar(5000);
        click(tarjetaCredito);
        esperar(1000);
        confrimarFlujo1=getText(By.cssSelector(".sc-AxhCb.eCWvbO.latam-typography.latam-typography--heading-04.sc-AxhUy.fxWvvr"));

    }

}
