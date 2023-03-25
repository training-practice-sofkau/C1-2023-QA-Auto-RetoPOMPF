package com.sofkau.pages;

import com.sofkau.locators.TrasladosLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.sofkau.locators.TrasladosLocators.*;


public class TrasladosPage extends CommonActions {

    public TrasladosPage(WebDriver driver) {
        super(driver);
        TrasladosLocators locators = PageFactory.initElements(driver, TrasladosLocators.class);
    }

    public void closePopUp() {
        click(closePopUp);
    }

    public void selectOrigin() {
        delayClick(origin);
        type(origin, "Aeropuerto Internacional Jose Maria Cordova, Medellin, Colombia");
        explicitWait(originWait);
        tab(origin);
    }

    public void selectDestination() {
        delayClick(destination);
        type(destination, "Hotel Nutibara Medellin, Calle 52a, La Candelaria, Medellin, Antioquia, Colombia");
        delayClick(destinationWait);
    }

    public void selectArrivalDate() {
        delayClick(date);
        delayClick(rightArrowDate);
        delayClick(rightArrowDate);
        delayClick(rightArrowDate);
        delayClick(rightArrowDate);
        delayClick(rightArrowDate);
        delayClick(rightArrowDate);
        delayClick(rightArrowDate);
        delayClick(arrivalDate);
    }

    public void selectArrivalTime() {
        delayClick(selectTime);
        delayClick(time);
    }

    public void selectAdultPassengers() {
        delayClick(passengers);
        delayClick(plusAdultPassengers);
    }

    public void selectChildrenPassengers() {
        delayClick(plusChildrenPassengers);
        delayClick(selectAge);
        delayClick(select1Y);
    }

    public void applyPassengers() {
        delayClick(passengers);
        delayClick(bttnPassengers);
    }

    public void searchTransfer() {
        delayClick(transferSearchBttn);
    }

    public void setupTransferPage() {
        closePopUp();
        selectOrigin();
        selectDestination();
        selectArrivalDate();
        selectArrivalTime();
        selectAdultPassengers();
        selectChildrenPassengers();
        applyPassengers();
        searchTransfer();
    }

    public void setupTransferPage4Me() {
        closePopUp();
        selectOrigin();
        selectDestination();
        selectArrivalDate();
        selectArrivalTime();
        applyPassengers();
        searchTransfer();
    }
}