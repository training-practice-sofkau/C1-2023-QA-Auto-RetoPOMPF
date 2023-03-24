package com.sofkau.pages;

import com.github.javafaker.Faker;
import com.sofkau.util.Pasajero;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VuelosPage extends CommonActionsOnPages{

    Faker faker = new Faker();

    @CacheLookup
    @FindBy(xpath = "//i[contains(@class, 'login-incentive--close') and contains(@class, 'shifu-3-icon-close') and contains(@class, '-eva-3-mr-md')]")
    private WebElement popUpInitial;

    private By iconFlights = By.xpath("//div[@class='button-content' and contains(label, 'Vuelos')]");

    private By originField = By.xpath("(//input[contains(@placeholder, 'Ingresa desde d')])[1]");

    private By citySelected = By.xpath("//ul[@class='ac-group-items']/li[@class='item -active']/span[@class='item-text']");

    private By destinyField = By.xpath("(//input[contains(@placeholder, 'Ingresa hacia d')])[1]");

    @CacheLookup
    @FindBy(xpath = "//span[@class='switch-circle']")
    private WebElement switchCheap;

    private By btnBuscar = By.xpath("//button[@class='sbox5-box-button-ovr--3LK5x sbox5-3-btn sbox5-button -secondary -icon -lg']");

    private By btnSiguiente = By.xpath("(//span[text()='Siguiente'])[1]");

    private By btnPlus = By.xpath("(//a[@class='steppers-icon-right eva-3-icon-plus'])[1]");
    private By btnContinuar = By.xpath("//em[@class= 'btn-text' and text()='Continuar']");

    @CacheLookup
    @FindBy(xpath = "(//input[@placeholder='Como figura en el documento de viaje'])[1]")
    private WebElement fieldNombrePass1;

    @CacheLookup
    @FindBy(xpath = "(//input[@placeholder='Como figura en el documento de viaje'])[2]")
    private WebElement fieldApellidoPass1;

    @CacheLookup
    @FindBy(xpath = "(//input[@placeholder='Como figura en el documento de viaje'])[3]")
    private WebElement fieldNombrePass2;

    @CacheLookup
    @FindBy(xpath = "(//input[@placeholder='Como figura en el documento de viaje'])[4]")
    private WebElement fieldApellidoPass2;

    @CacheLookup
    @FindBy(xpath = "//input[@name='formData.travelers[0].identifications[0].number']")
    private WebElement idNumber1;

    @CacheLookup
    @FindBy(xpath = "//input[@id='traveler-identification-number-1']")
    private WebElement idNumber2;

    @CacheLookup
    @FindBy(xpath = "//input[@id='formData.contactData.mainEmailAddress']")
    private WebElement email1;

    @CacheLookup
    @FindBy(xpath = "//input[@id='formData.contactData.repeatMainEmailAddress']")
    private WebElement email2;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@placeholder, 'Ingresa tu n')]")
    private WebElement numeroTel;

    @CacheLookup
    @FindBy(xpath = "//*[text()='PSE ']")
    private WebElement selectorPSE;

    @CacheLookup
    @FindBy(xpath = "//*[@id='card-selector-0']")
    private WebElement comboBox;

    @CacheLookup
    @FindBy(xpath = "//input[@id='invoice-first-name-0']")
    private WebElement campoNombre;

    @CacheLookup
    @FindBy(xpath = "//input[@id='invoice-last-name-0']")
    private WebElement campoApellido;

    @CacheLookup
    @FindBy(xpath = "//input[@id='invoice-fiscal-identification-number-0']")
    private WebElement campoCedula;

    @CacheLookup
    @FindBy(xpath = "//input[@class='input-tag invoice-fiscal-address-street ng-untouched ng-pristine ng-invalid']")
    private WebElement campodireccion;

    @CacheLookup
    @FindBy(xpath = "(//i[@class='checkbox-check eva-3-icon-checkmark -eva-3-mr-sm'])[1]")
    private WebElement terminosCondiciones;

    @CacheLookup
    @FindBy(xpath = "//a[@class='chk-button -lg -secondary eva-3-btn']/em[text()='Comprar sin asistencia']")
    private WebElement ultimoboton;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/app/debt-published/div/div[3]/debt-published-info/div/div/div[1]/div/span[2]")
    private WebElement mensajeFinal;


    public VuelosPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToVuelos() throws InterruptedException {
        click(popUpInitial);
        click(iconFlights);
        Thread.sleep(1000);
    }

    public void selectOriginDestiny(String origin, String destiny){
        clickwithDelay(originField);
        clearText(originField);
        fillFieldsSlows(originField, origin);
        clickwithDelay(citySelected);
        clickwithDelay(destinyField);
        clearText(destinyField);
        fillFieldsSlows(destinyField, destiny);
        clickwithDelay(citySelected);
    }

    public void buscarVuelo(){
        click(switchCheap);
        click(btnBuscar);
        scrollDown(160);
        click(btnSiguiente);
        clickwithDelay(btnPlus);
        clickwithDelay(btnContinuar);
    }

    public void fillForm(){
        Pasajero pass1 = new Pasajero(faker.name().firstName(), faker.name().lastName(),
                faker.numerify("########"), "31"+faker.numerify("########"),
                faker.address().fullAddress());
        Pasajero pass2 = new Pasajero(faker.name().firstName(), faker.name().lastName(),
                faker.numerify("########"));
        typeWithDelay(fieldNombrePass1, pass1.getNombre(), 150);
        typeWithDelay(fieldApellidoPass1, pass1.getApellido(), 150);
        typeWithDelay(idNumber1, pass1.getCedula(), 150);
        scrollDown(400);
        typeWithDelay(fieldNombrePass2, pass2.getNombre(), 150);
        typeWithDelay(fieldApellidoPass2, pass2.getApellido(), 150);
        typeWithDelay(idNumber2, pass2.getCedula(), 150);
        scrollDown(600);
        typeWithDelay(email1, pass1.getNombre() +"@gmail.com", 150);
        typeWithDelay(email2, pass1.getNombre() +"@gmail.com", 150);
        scrollDown(400);
        typeWithDelay(numeroTel, pass1.getCelular(), 150);
        scrollDown(400);
        click(selectorPSE);
        scrollDown(400);
        selectCombobox(comboBox);
        scrollDown(600);
        typeWithDelay(campoNombre, pass1.getNombre(), 150);
        typeWithDelay(campoApellido, pass1.getApellido(), 150);
        scrollDown(200);
        typeWithDelay(campoCedula, pass1.getCedula(), 150);
        typeWithDelay(campodireccion, pass1.getDireccion(), 150);
        scrollDown(950);
        clickwithDelay(terminosCondiciones);
        clickwithDelay(ultimoboton);
    }

    public String getTextfinal(){
        return getText(mensajeFinal);
    }
}
