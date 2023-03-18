package com.sofkau.pages;

import com.sofkau.models.FormModel;
import com.sofkau.pages.common.CommonActionOnpages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;

public class PagPago extends CommonActionOnpages {
    private final FormModel formModel;
    private static final String TITULO_FORMULARIO = "FACTURACION Y ENVIO";

    //localizadores de entrada
    private static final By precioProducto = By.xpath("//td[@class=\"product-total\"]/span");

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"customer_details\"]/div[1]/div/h3")
    private WebElement tituloDetallesPago;


    private static final By precioSubTotal = By.xpath("//*[@id=\"order_review\"]/table/tfoot/tr[1]/td");

    //formulario
    @CacheLookup
    @FindBy(id = "billing_myfield12")
    private WebElement cedula;

    @CacheLookup
    @FindBy(id = "billing_email")
    private WebElement email;

    @CacheLookup
    @FindBy(id = "billing_first_name")
    private WebElement nombre;

    @CacheLookup
    @FindBy(id = "billing_last_name")
    private WebElement apellido;

    private static final By region = By.id("select2-billing_state-container");
    private static final By municipio = By.id("select2-billing_city-container");
    private static final By cajaTextoRegionMunicipio = By.xpath("/html/body/span/span/span[1]/input");

    @CacheLookup
    @FindBy(id = "billing_address_1")
    private WebElement direccion;

    @CacheLookup
    @FindBy(id = "billing_address_2")
    private WebElement noDireccion;

    @CacheLookup
    @FindBy(id = "billing_phone")
    private WebElement telefono;

    private By precioTotalFacturado = By.xpath("//*[@id=\"order_review\"]/table/tfoot/tr[4]/td");

    private static final By pagoBaloto = By.xpath("//label[@for=\"payment_method_bank_transfer_1\"]");
    private static final By radioButtonBaloto = By.id("payment_method_bank_transfer_1");
    private static final By contenedorTerminosCondiciones = By.xpath("//*[@id=\"payment\"]/div/div/p");
    private static final By checkBoxTerminos = By.id("terms");
    private static final By btnRealizarPedido = By.id("place_order");

    public PagPago(WebDriver driver, FormModel formModel){
        super(driver);
        this.formModel = formModel;
        PageFactory.initElements(driver, PagPago.this);
    }

    public void fillFormPay () {

            addWaitByVisibility(cedula, Duration.ofSeconds(15));
            scrollTo(cedula);
            typeInto(cedula, formModel.getCedula());

            typeInto(email, formModel.getEmail());

            typeInto(nombre, formModel.getName());

            typeInto(apellido, formModel.getLastName());

            scrollTo(region);
            click(region);
            addWaitByVisibility(cajaTextoRegionMunicipio, Duration.ofSeconds(5));
            typeInto(cajaTextoRegionMunicipio, formModel.getRegion());
            pressEnter(cajaTextoRegionMunicipio);

            click(municipio);
            addWaitByVisibility(cajaTextoRegionMunicipio,Duration.ofSeconds(5));
            typeInto(cajaTextoRegionMunicipio, formModel.getCity());
            pressEnter(cajaTextoRegionMunicipio);

            typeInto(direccion, formModel.getAddress());

            typeInto(noDireccion, formModel.getNoAddress());

            typeInto(telefono, formModel.getPhone());


            while (getAtributeElement(radioButtonBaloto,"checked")==null){
                addWaitByVisibility(pagoBaloto,Duration.ofSeconds(8));
                scrollTo(pagoBaloto);
                clickWithAccion(pagoBaloto);
           }

            addWaitByVisibility(contenedorTerminosCondiciones,Duration.ofSeconds(8));
            while(getAtributeElement(contenedorTerminosCondiciones,"class")
                  .equals("form-row validate-required")) {
                addWaitByVisibility(checkBoxTerminos,Duration.ofSeconds(8));
                scrollTo(contenedorTerminosCondiciones);
                clickWithAccion(checkBoxTerminos);
            }
            scrollTo(btnRealizarPedido);
            addWaitByVisibility(btnRealizarPedido,Duration.ofSeconds(8));
            clickWithAccion(btnRealizarPedido);
    }

    public Boolean isTitleAppear() {
        addWaitByVisibility(tituloDetallesPago,Duration.ofSeconds(10));
        String titlePage = getTex(tituloDetallesPago);
        return titlePage.contains(TITULO_FORMULARIO);
    }

    public int subTotalPrice(){
        addWaitByVisibilityAllElement(precioProducto,Duration.ofSeconds(5));
        ArrayList<String> listPriceFull = getTextElementsUnic(precioProducto);
        int subTotalPrice =0;
        for (String product : listPriceFull) {
            if (product.length() > 0) {
                int i = Integer.parseInt(product.replaceAll("[-+.^:,$]",
                        ""));
                subTotalPrice += i;
            }
        }
        return subTotalPrice;
    }

    public int getSubTotalPrice(){
       return getTextToInt(precioSubTotal);
    }

    public  int getTotalFacturado(){
        return getTextToInt(precioTotalFacturado);
    }
}
