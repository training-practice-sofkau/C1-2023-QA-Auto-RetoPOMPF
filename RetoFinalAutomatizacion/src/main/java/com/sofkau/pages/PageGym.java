package com.sofkau.pages;

import com.sofkau.models.Cliente;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageSnacks extends CommonActionOnPages{
    private WebDriver webDriver;
    private final Cliente cliente;
    //Localizadores
    private final By clickSnacks = By.xpath("(//*[@class='product-category col'])[13]");
    private final By gymEnCasa = By.cssSelector("li[id='mega-menu-item-198599'] a[class='mega-menu-link']");
    private final By agregarProd1 = By.xpath("(//button[@value='198366'][normalize-space()='Añadir al carrito'])[1]");


    //Constructor
    public PageSnacks(WebDriver driver, Cliente cliente) {
        super(driver);
        this.cliente = cliente;
        PageFactory.initElements(driver, this);
    }

    public void agregarProductos() {
        scrollP2();
        ponerMouse("dashicons-plus-alt2");
        click(gymEnCasa);
        click(agregarProd1);
    }


}
