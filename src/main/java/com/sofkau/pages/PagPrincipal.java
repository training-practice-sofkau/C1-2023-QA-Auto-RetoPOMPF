package com.sofkau.pages;

import com.sofkau.pages.common.CommonActionOnpages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class PagPrincipal extends CommonActionOnpages {

    private WebDriver driver;
    //localizadores de entrada


    private By emailInputLocator = By.xpath("(//input[@id='mce-EMAIL'])[1]");
    private By nameInputLocator = By.xpath("(//input[@id='mce-FNAME'])[1]");
    private By phoneInputLocator = By.xpath("(//input[@id='mce-MMERGE4'])[1]");
    private By subscribeButtonLocator = By.xpath("(//input[@id='mc-embedded-subscribe'])[1]");

    public void setEmail(String email) {
        driver.findElement(emailInputLocator).sendKeys(email);
    }

    public void setName(String name) {
        driver.findElement(nameInputLocator).sendKeys(name);
    }

    public void setPhone(String phone) {
        driver.findElement(phoneInputLocator).sendKeys(phone);
    }

    public void clickSubscribeButton() {
        driver.findElement(subscribeButtonLocator).click();
    }

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"mega-menu-item-198556\"]/a")
    private WebElement menuOfertas;

    @CacheLookup
    @FindBy(xpath = "//option[@value=\"price\"]")
    private WebElement filtroPrecioBajo;

    /*@CacheLookup
    @FindBy(xpath="//*[@name=\"orderby\" and @aria-label=\"Pedido de la tienda\"]")
    private WebElement filtroProductos;
     */

    private static final By btnAgregarCarrito = By.xpath("//*[@class=\"add-to-cart-button\"]");

    public PagPrincipal(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, PagPrincipal.this);
    }

    public void selectCategoryOffer() {
        addWaitByVisibility(menuOfertas, Duration.ofSeconds(6));
        repeatClick(menuOfertas, 2);
    }

    public void selectProductsRandom(int cant) {

            /*addWaitByVisibility(filtroProductos,Duration.ofSeconds(10));
            click(filtroProductos);
            */
        addWaitByVisibility(filtroPrecioBajo, Duration.ofSeconds(5));
        click(filtroPrecioBajo);

        ArrayList<String> listProduct;
        listProduct = getTextElementsUnic(btnAgregarCarrito);//lista de botones disponibles para en carrito
        Random random = new Random();
        //solo se selecciona los botones para añadir directamente los productos
        ArrayList<Integer> indexProductFilter = new ArrayList<>();
        for (int i = 0; i < listProduct.size(); i++) {
            if (Objects.equals(listProduct.get(i), "AÑADIR AL CARRITO")) {
                indexProductFilter.add(i + 1);
            }
        }
        //presionar productos uno a uno, según la cantidad
        for (int i = 0; i < cant; i++) {
            int index = indexProductFilter.get(random.nextInt(indexProductFilter.size()));
            String position = "//*[@id=\"main\"]/div/div[2]/div/div[2]/div[" + index + "]/div/div[2]/div[2]/div[3]";
            indexProductFilter.remove((Integer) index);
            scrollTo(By.xpath(position));
            addWaitByVisibility(By.xpath(position), Duration.ofSeconds(8));
            click(By.xpath(position));
            String afterClick = "//*[@id=\"main\"]/div/div[2]/div/div[2]/div[" + index + "]/div/div[2]/div[2]/div[3]/a[2]";
            addWaitByVisibility(By.xpath(afterClick), Duration.ofSeconds(8));
            if (i == cant - 1) {
                click(By.xpath(afterClick));
            }
        }
    }
}
