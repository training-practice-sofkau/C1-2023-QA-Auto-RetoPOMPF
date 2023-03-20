package com.sofkau.pages;

import com.sofkau.models.Cliente;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.sofkau.util.LimitTimeWait.TEN_SECONDS;

public class Page  extends CommonActionOnPages {
    private WebDriver webDriver;
    private final Cliente cliente;

    //Localizadores
    private final By clickProducto1 = By.xpath("(//div[@class='add-to-cart-button'])[2]");
    private final By clickSabor1 = By.xpath("(//span[@class='ux-swatch__color ux-swatch__color--single-color'])[6]");
    private final By botonAgregar = By.xpath("//div[contains(@class,'woocommerce-variation-add-to-cart')]//button[contains(@class,'single_add_to_cart_button button alt wp-element-button')]");

    private final By clickProducto2 = By.xpath("(//div[@class='add-to-cart-button'])[1]");
    private final By clickSabor2 = By.xpath("//div[contains(@class,'ux-swatch tooltip')]/span[contains(@style,'--swatch-color: #ddb471')]");

    private final By clickProducto3 = By.xpath("(//div[@class='add-to-cart-button'])[4]");
    private final By clickSabor3 = By.xpath("(//span[@class='ux-swatch__color ux-swatch__color--single-color'])[15]");
    private final By botonVerCarrito = By.xpath("(//a[@class='button wc-forward wp-element-button'][normalize-space()='Ver carrito'])[1]");

    private final By botonCantidadMas1 = By.xpath("(//input[@value='+'])[1]");
    private final By botonCantidadMas2 = By.xpath("(//input[@value='+'])[2]");
    private final By botonCantidadMas3 = By.xpath("(//input[@value='+'])[3]");
    private final By botonFinalizarCompra = By.xpath("(//a[normalize-space()='Finalizar compra'])[1]");

    @CacheLookup
    @FindBy(id = "billing_myfield12")
    private WebElement document;

    @CacheLookup
    @FindBy(id = "billing_email")
    private WebElement email;

    @CacheLookup
    @FindBy(id = "billing_first_name")
    private WebElement firstName;

    @CacheLookup
    @FindBy(id = "billing_last_name")
    private WebElement lastName;

    private final By deparment = By.id("select2-billing_state-container");

    @CacheLookup
    @FindBy(css = "input[aria-owns=\"select2-billing_state-results\"][role=\"combobox\"]")
    private WebElement comboboxDepartment;

    @CacheLookup
    @FindBy(css = "input[aria-owns=\"select2-billing_city-results\"][role=\"combobox\"]")
    private WebElement comboboxCity;

    private final By city = By.id("select2-billing_city-container");

    @CacheLookup
    @FindBy(id = "billing_address_1")
    private WebElement address;

    @CacheLookup
    @FindBy(id = "billing_phone")
    private WebElement phone;

    private final By botonRealizarPedido = By.id("place_order");
    private final By terms = By.id("terms");

    private final By mensajeFinal = By.xpath("(//strong[normalize-space()='Gracias. Tu pedido ha sido recibido.'])[1]");

    //Constructor
    public Page(WebDriver driver, Cliente cliente) {
        super(driver);
        this.cliente = cliente;
        PageFactory.initElements(driver, this);
    }

    public void agregarProductos () {
        scrollP();
        click(clickProducto1);
        click(clickSabor1);
        click(botonAgregar);
        goBack();
        goBack();
        click(clickProducto2);
        click(clickSabor2);
        click(botonAgregar);
        goBack();
        goBack();
        click(clickProducto3);
        click(clickSabor3);
        click(botonAgregar);
        click(botonVerCarrito);
        click(botonCantidadMas1);
        click(botonCantidadMas2);
        click(botonCantidadMas3);
        click(botonFinalizarCompra);
    }

    public void fillMandatoryFields() {
        typeIntoFactory(document, cliente.getDocument());
        typeIntoFactory(email, cliente.getEmail());
        typeIntoFactory(firstName, cliente.getName());
        typeIntoFactory(lastName, cliente.getLastName());
        click(deparment);
        typeIntoFactory(comboboxDepartment, cliente.getDepartment());
        pressEnterFactory(comboboxDepartment);
        click(city);
        typeIntoFactory(comboboxCity,cliente.getCity());
        pressEnterFactory(comboboxCity);
        typeIntoFactory(address, cliente.getAddress());
        typeIntoFactory(phone,cliente.getPhone());
        scrollP();
        pressSpacePOM(terms);
        pressSpacePOM(botonRealizarPedido);
    }

    public WebElement getMensajeFinal(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mensajeFinal));
    }

    public void fillMandatoryFields2() {
        typeIntoFactory(email, cliente.getEmail());
        typeIntoFactory(firstName, cliente.getName());
        typeIntoFactory(lastName, cliente.getLastName());
        typeIntoFactory(address, cliente.getAddress());
        typeIntoFactory(phone,cliente.getPhone());
        scrollP();
        pressSpacePOM(terms);
        pressSpacePOM(botonRealizarPedido);
    }

}
