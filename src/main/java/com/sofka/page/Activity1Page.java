package com.sofka.page;

import com.sofka.model.Facturacion;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class Activity1Page extends CommonActionOnPage {
    Facturacion f = new Facturacion();

    //localizadores feature1

    private final By icon = By.xpath("(//a[@class='dashicons-plus-alt2 mega-menu-link'])[1]");
    private final By icon2 = By.xpath("//div[@class='row hide-for-small large-columns-8 medium-columns-3 small-columns-2 row-small']//div[1]//div[1]//a[1]");
    private final By proteina= By.xpath("(//img[@alt='aminox 30 serv'])[1]");
    private final By home = By.xpath("(//img[@class='header-logo-dark'])[1]");
    private final By simbolcarrito = By.xpath("//div[contains(@class,'single_variation_wrap')]//button[contains(@class,'wp-element-button')]");
    private final By sombolx= By.xpath("(//button[@title='Close (Esc)'])[1]");
    private final By proteina2 = By.xpath("(//img[@alt='gold standard 5 lb'])[1]");
    private final By proteina3= By.xpath("(//img[@alt='serious mass 12 lb'])[1]");
    private final By vercarrito= By.xpath("//p[contains(@class,'woocommerce-mini-cart__buttons')]//a[contains(@class,'button wc-forward')]");
    private final By simboladd1= By.xpath("(//input[@value='+'])[1]");
    private final By simboladd2 = By.xpath("(//input[@value='+'])[2]");
    private final By simboladd3 = By.xpath("(//input[@value='+'])[3]");
    private final By finalizarcompra= By.xpath("(//a[normalize-space()='Finalizar compra'])[1]");
    private final By numero_doc= By.xpath("(//input[@id='billing_myfield12'])[1]");
    private final By email_pedido = By.xpath("(//input[@id='billing_email'])[1]");
    private final By name1= By.xpath("(//input[@id='billing_first_name'])[1]");
    private final By name2 = By.xpath("(//input[@id='billing_last_name'])[1]");
    private final By direccion= By.xpath("(//input[@id='billing_address_1'])[1]");
    private final By direccion2= By.xpath("(//input[@id='billing_address_2'])[1]");
    private final By celu= By.xpath("(//input[@id='billing_phone'])[1]");
    private final By nota= By.xpath("(//textarea[@id='order_comments'])[1]");
    private final By pago = By.xpath("(//input[@id='payment_method_bank_transfer_1'])[1]");
    private final By terminos = By.id("terms");
    private final By realizarPedido= By.id("place_order");
    private final By colorA = By.xpath("//div[@title='Watermelon']//span[@class='ux-swatch__color ux-swatch__color--single-color']");
    private final By colorB = By.xpath("(//span[@class='ux-swatch__color ux-swatch__color--single-color'])[10]");
    private final By colorC = By.xpath("(//span[@class='ux-swatch__color ux-swatch__color--single-color'])[5]");
    private final By lugar = By.id("select2-billing_state-container");
    private final By box_department = By.cssSelector("input[aria-owns='select2-billing_state-results']");
    private final By alugar= By.id("select2-billing_city-container");
    private final By box_ciudad = By.cssSelector("input[aria-owns='select2-billing_city-results']");
    private final By pedidoCompletado = By.xpath("(//strong[normalize-space()='Gracias. Tu pedido ha sido recibido.'])[1]");
    private final By color_in= By.xpath("(//span[@class='ux-swatch__color ux-swatch__color--single-color'])[5]");

    public Activity1Page(WebDriver driver, Facturacion f) {
        super(driver);
        this.f=f;
    }
    public void agregar(){
        scrollproteina();
        click(proteina);
        click(colorA);
        click(simbolcarrito);
        click(sombolx);
        //click(close);
        click(home);
        scrollproteina2();
        click(proteina2);
        click(colorB);
        click(simbolcarrito);
        click(sombolx);
        click(home);
        scrollproteina3();
        click(proteina3);
        click(colorC);
        click(simbolcarrito);
        click(vercarrito);
        click(simboladd1);
        click(simboladd2);
        click(simboladd3);
        click(finalizarcompra);
    }

    public void type()  {
        typeInto(numero_doc,f.getDocumento());
        typeInto(email_pedido,f.getEmail());
        typeInto(name1,f.getNombre());
        typeInto(name2,f.getApellido());
        click(lugar);
        typeInto(box_department,f.getLugar1());
        pressEnter(box_department);
        click(alugar);
        typeInto(box_ciudad,f.getLugar2());
        pressEnter(box_ciudad);
        typeInto(direccion,f.getDireccion());
        typeInto(direccion2,f.getDireccion2());
        typeInto(celu,f.getTelefono());
        typeInto(nota,f.getNotas_adicionales());
        scrollpago();
        pressSpace(terminos);
        pressSpace(realizarPedido);
        try {
            Thread.sleep(1600);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //scrollPedidoCompletado();

    }
    public void type0()  {
        typeInto(numero_doc,f.getDocumento());
        typeInto(name2,f.getApellido());
        click(lugar);
        typeInto(box_department,f.getLugar1());
        pressEnter(box_department);
        click(alugar);
        typeInto(box_ciudad,f.getLugar2());
        pressEnter(box_ciudad);
        typeInto(direccion,f.getDireccion());
        typeInto(direccion2,f.getDireccion2());
        typeInto(celu,f.getTelefono());
        typeInto(nota,f.getNotas_adicionales());
        scrollpago();
        pressSpace(terminos);
        pressSpace(realizarPedido);
        try {
            Thread.sleep(1600);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //scrollPedidoCompletado();

    }



    public void scrollproteina() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(proteina));
    }

    public void scrollicon2() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(icon2));
    }
    public void scrollPedidoCompletado(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(pedidoCompletado));
    }

    public void scrollcarrito() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(simbolcarrito));
    }


    public void scrollproteina2() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(proteina2));
    }
    public void scrollproteina3() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(proteina3));
    }


    public void scrollVercarrito() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(vercarrito));
    }




    public void scrollpago() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(pago));
    }
    public void clickpago() {
        try {
            //Thread.sleep(200);
            click(pago);

        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
    public void clickterminos() {
        try {
            //Thread.sleep(200);
            click(terminos);

        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
    public void clickRealizarPedido() {
        try {
            //Thread.sleep(200);
            click(realizarPedido);

        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }














}
