package com.sofka.page;

import com.sofka.model.Suscripcion;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActivityPage extends CommonActionOnPage{
    private Suscripcion suscripcion = new Suscripcion();



//localizadores feature3
    private final By email = By.xpath("(//input[@id='mce-EMAIL'])");
    private final By name = By.xpath("(//input[@id='mce-FNAME'])[1]");
    private final By phone = By.xpath("(//input[@id='mce-MMERGE4'])[1]");
    private final  By button = By.id("mc-embedded-subscribe");




    public ActivityPage(WebDriver driver, Suscripcion suscripcion) {
        super(driver);
        this.suscripcion = suscripcion;

    }

    public void fillMandatoryFields(){
        if (suscripcion.getCorreo() != null) {
            typeInto(email, suscripcion.getCorreo().toString());
        }
        if (suscripcion.getNombre() != null) {
            typeInto(name, suscripcion.getNombre().toString());
        }
        if (suscripcion.getCelular() != null) {
            typeInto(phone, suscripcion.getCelular().toString());
        }
        pressSpace(button);
    }


    public void fillMandatoryFields0(){
        if (suscripcion.getCorreo() != null) {
            typeInto(email, suscripcion.getCorreo().toString());
        }
        if (suscripcion.getCelular() != null) {
            typeInto(phone, suscripcion.getCelular().toString());
        }
        pressSpace(button);
    }
    public void scrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(email));
    }
    public String getMessage() {
        WebElement successMessage = driver.findElement(By.id("mce-success-response"));
        return successMessage.getText();
    }




}
