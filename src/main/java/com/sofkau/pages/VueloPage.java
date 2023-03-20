package com.sofkau.pages;

import com.github.javafaker.Faker;
import com.sofkau.models.Pasajero;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VueloPage extends CommonActionOnPages {

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

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[3]/button")
    private WebElement buscar;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"clusters\"]/span[1]/div/span/reduced-cluster/div/div/div/div/div[2]/span[3]/div/span")
    private WebElement siguiente;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"passengers-modal-position\"]/passengers-modal/div/div[2]/span[1]/span[2]/div/a[2]")
    private WebElement adulto;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"passengers-modal-position\"]/passengers-modal/div/div[2]/span[2]/span[2]/div/a[2]")
    private WebElement menor;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"eva-select\"]")
    private WebElement edadMenor;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"eva-select\"]/option[3]")
    private WebElement opcionEdadMenor;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"passengers-modal-position\"]/passengers-modal/div/div[2]/span[5]/span/a")
    private WebElement aplicarPasajero;

    @CacheLookup
    @FindBy(xpath = "(//input[@placeholder='Como figura en el documento de viaje'])[1]")
    private WebElement nombrePasajero1;

    @CacheLookup
    @FindBy(xpath = "(//*[@placeholder='Como figura en el documento de viaje'])[2]")
    private WebElement apellidoPasajero1;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"traveler-identification-number-0\"]")
    private WebElement documentoPasajero1;

    @CacheLookup
    @FindBy(xpath = "(//*[@placeholder='Como figura en el documento de viaje'])[3]")
    private WebElement nombrePasajero2;

    @CacheLookup
    @FindBy(xpath = "(//*[@placeholder='Como figura en el documento de viaje'])[4]")
    private WebElement apellidoPasajero2;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"traveler-identification-number-1\"]")
    private WebElement documentoPasajero2;

    @CacheLookup
    @FindBy(xpath = "(//*[@placeholder='Como figura en el documento de viaje'])[5]")
    private WebElement nombrePasajero3;

    @CacheLookup
    @FindBy(xpath = "(//*[@placeholder='Como figura en el documento de viaje'])[6]")
    private WebElement apellidoPasajero3;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"traveler-identification-number-2\"]")
    private WebElement documentoPasajero3;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"traveler-birthday-day-2\"]")
    private WebElement diaMenor;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"traveler-birthday-day-2\"]/option[6]")
    private WebElement selectDay;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"traveler-birthday-month-2\"]")
    private WebElement selectMonth;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"traveler-birthday-year-2\"]")
    private WebElement selectYear;

    @CacheLookup
    @FindBy(xpath = "(//*[@placeholder='minombre@ejemplo.com'])[1]")
    private WebElement email;

    @CacheLookup
    @FindBy(xpath = "(//*[@placeholder='minombre@ejemplo.com'])[2]")
    private WebElement emailConfirm;

    @CacheLookup
    @FindBy(xpath ="    //*[@id=\"formData.contactData.phones[0].number\"]")
    private WebElement telefono;

    @CacheLookup
    @FindBy(xpath = "(//i[@class='payment-method-aligned radio-circle'])[4]")
    private WebElement metodo;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"card-selector-0\"]\n")
    private WebElement banco;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"invoice-first-name-0\"]")
    private WebElement nombreFactura;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"invoice-last-name-0\"]")
    private WebElement apellidoFactura;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"invoice-fiscal-identification-number-0\"]")
    private WebElement documentoFactura;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@class, 'invoice-fiscal-address-street')]")
    private WebElement direccionFactura;

    @CacheLookup
    @FindBy(xpath = "(//i[@class='checkbox-check eva-3-icon-checkmark -eva-3-mr-sm'])[1]")
    private WebElement aceptConditions;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"checkout-content\"]/div[1]/buy-container/buy-component/div/div/div/div[1]/button-component/div/a")
    private WebElement comprar;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/app/debt-published/div/div[3]/debt-published-info/div/div/div[1]/div/span[2]")
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

        click(cualquierFecha);

        click(buscar);

        click(siguiente);

        click(adulto);

        click(menor);

        clickcondelay(edadMenor);

        for(int i = 0; i < 2; i++) {
            edadMenor.sendKeys(Keys.ARROW_DOWN);
        }

        click(aplicarPasajero);

        // Llamo al método para generar un nuevo pasajero colombiano
        clickcondelay(nombrePasajero1);
        typeInto(nombrePasajero1, pasajero1.getNombres());
        typeInto(apellidoPasajero1, pasajero1.getApellidos());
        typeInto(documentoPasajero1, pasajero1.getDocumento());

        typeInto(nombrePasajero2, pasajero2.getNombres());
        typeInto(apellidoPasajero2, pasajero2.getApellidos());
        typeInto(documentoPasajero2, pasajero2.getDocumento());

        typeInto(nombrePasajero3, pasajero3.getNombres());
        typeInto(apellidoPasajero3, pasajero3.getApellidos());
        typeInto(documentoPasajero3, pasajero3.getDocumento());

        scroll(100);

        click(diaMenor);

        for(int i = 0; i < 5; i++) {
            diaMenor.sendKeys(Keys.ARROW_DOWN);
        }

        click(selectMonth);

        for(int i = 0; i < 3; i++) {
            selectMonth.sendKeys(Keys.ARROW_DOWN);
        }

        click(selectYear);

        for(int i = 0; i < 2; i++) {
            selectYear.sendKeys(Keys.ARROW_DOWN);
        }

        enter(selectYear);

        scroll(500);

        clickcondelay(email);
        typeInto(email, pasajero1.getCorreo());
        typeInto(emailConfirm, pasajero1.getCorreo());

        scroll(500);

        typeInto(telefono, pasajero1.getTelefono());

        scroll(500);

        click(metodo);

        scroll(500);

        click(banco);

        for(int i = 0; i < 3; i++) {
            banco.sendKeys(Keys.ARROW_DOWN);
        }

        enter(banco);

        scroll(600);

        typeInto(nombreFactura, pasajero1.getNombres());
        typeInto(apellidoFactura, pasajero1.getApellidos());
        typeInto(documentoFactura, pasajero1.getDocumento());
        typeInto(direccionFactura, pasajero1.getDireccion());

        scroll(1300);

        click(aceptConditions);

        click(comprar);


    }

    public String verMensaje(){
        return getTextoFinal(mensaje);
    }


}
