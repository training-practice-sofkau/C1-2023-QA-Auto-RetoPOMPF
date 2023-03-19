package com.sofkau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompraProductos {
    /*private WebDriver driver;
    private WebDriverWait wait;

    public CompraProductos(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Localizadores:
    By producto1 = By.xpath("(//a[@aria-label='Elige las opciones para “Gold Standard 100% Whey · 5 lb Optimum Nutrition”'])[1]");
    By producto2 = By.xpath("(//a[@aria-label='Elige las opciones para “AMINOx® · 30 serv BSN”'])[1]");
    By producto3 = By.xpath("(//a[@aria-label='Elige las opciones para “Gold Standard 100% Whey · 2 lb Optimum Nutrition”'])[1]");
    By saborProducto1 = By.xpath("(//span[@class='ux-swatch__color ux-swatch__color--single-color'])[10]");
    By saborProducto2 = By.xpath("(//span[@class='ux-swatch__color ux-swatch__color--single-color'])[6]");
    By saborProducto3 = By.xpath("(//span[@class='ux-swatch__color ux-swatch__color--single-color'])[1]");
    By añadirAlCarrito = By.xpath("(//button[@type='submit'][normalize-space()='Añadir al carrito'])[1]");
    By cerrarCarrito = By.xpath("(//button[@title='Close (Esc)'])[1]");
    By paginaPrincipal = By.xpath("(//img[@class='header-logo-dark'])[1]");
    By verCarrito = By.xpath("(//a[@class='button wc-forward wp-element-button'][normalize-space()='Ver carrito'])[1]");
    By modificarCantidadProducto1 = By.xpath("(//input[@value='+'])[1]");
    By modificarCantidadProducto2 = By.xpath("(//input[@value='+'])[2]");
    By modificarCantidadProducto3 = By.xpath("(//input[@value='+'])[3]");
    By finalizarCompra = By.xpath("(//a[normalize-space()='Finalizar compra'])[1]");
    By numeroDocumento = By.xpath("(//input[@id='billing_myfield12'])[1]");
    By email = By.xpath("(//input[@id='billing_email'])[1]");
    By nombre = By.xpath("(//input[@id='billing_first_name'])[1]");
    By apellido = By.xpath("(//input[@id='billing_last_name'])[1]");
    By eligeOpcion = By.xpath("(//span[@id='select2-billing_state-container'])[1]");
    By eligeOpcion2 = By.xpath("(//span[@id='select2-billing_city-container'])[1]");
    By direccion = By.xpath("(//input[@id='billing_address_1'])[1]");
    By celular = By.xpath("(//input[@id='billing_phone'])[1]");
    By clickOpcionPago = By.xpath("(//label[normalize-space()='PAGA EN PUNTO BALOTO'])[1]");
    By clickTerminos = By.xpath("(//label[@for='terms'])[1]");
    By clickRealizarPedido = By.xpath("(//button[normalize-space()='Realizar el pedido'])[1]");

    //métodos
    public void seleccionarProducto1() {
        driver.findElement(producto1).click();
    }

    public void seleccionarProducto2() {
        driver.findElement(producto2).click();
    }

    public void seleccionarProducto3() {
        driver.findElement(producto3).click();
    }

    public void seleccionarSaborProducto1() {
        driver.findElement(saborProducto1).click();
    }

    public void seleccionarSaborProducto2() {
        driver.findElement(saborProducto2).click();
    }

    public void seleccionarSaborProducto3() {
        driver.findElement(saborProducto3).click();
    }

    public void añadirAlCarrito() {
        driver.findElement(añadirAlCarrito).click();
    }

    public void cerrarCarrito() {
        driver.findElement(cerrarCarrito).click();
    }

    public void paginaPrincipal() {
        driver.findElement(paginaPrincipal).click();
    }

    public void verCarrito() {
        driver.findElement(verCarrito).click();
    }

    public void aumentarCantidadProducto1() {
        driver.findElement(modificarCantidadProducto1).click();
    }

    public void aumentarCantidadProducto2() {
        driver.findElement(modificarCantidadProducto2).click();
    }

    public void aumentarCantidadProducto3() {
        driver.findElement(modificarCantidadProducto3).click();
    }

    public void irAPaginaDePago() {
        driver.findElement(finalizarCompra).click();
    }


    public void ingresarNumeroDocumento(String documento) {

        driver.findElement(numeroDocumento).sendKeys(documento);
    }

    public void ingresarEmail(String correo) {

        driver.findElement(email).sendKeys(correo);
    }

    public void ingresarNombre(String nombreCliente) {
        driver.findElement(nombre).sendKeys(nombreCliente);
    }

    public void ingresarApellido(String apellidoCliente) {

        driver.findElement(apellido).sendKeys(apellidoCliente);
    }

    public void elegirOpcion(String departamento) {
        driver.findElement(eligeOpcion).click();
        WebElement option = driver.findElement(By.xpath("//li[text()='" + departamento + "']"));
        option.click();
    }

    public void elegirOpcion2(String ciudad) {
        driver.findElement(eligeOpcion2).click();
        WebElement option = driver.findElement(By.xpath("//li[text()='" + ciudad + "']"));
        option.click();
    }

    public void ingresarDireccion(String direccionCliente) {

        driver.findElement(direccion).sendKeys(direccionCliente);
    }

    public void ingresarCelular(String celularCliente) {

        driver.findElement(celular).sendKeys(celularCliente);
    }

    public void seleccionarOpcionPago() {

        driver.findElement(clickOpcionPago).click();
    }

    public void aceptarTerminos() {

        driver.findElement(clickTerminos).click();
    }

    public void realizarPedido() {

        driver.findElement(clickRealizarPedido).click();
    }

     */
}
