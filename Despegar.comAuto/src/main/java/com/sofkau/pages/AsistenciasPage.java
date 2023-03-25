package com.sofkau.pages;

import com.sofkau.locators.AsistenciasLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.sofkau.locators.AsistenciasLocators.*;

public class AsistenciasPage extends CommonActions {

    public AsistenciasPage(WebDriver driver) {
        super(driver);
        AsistenciasLocators locators = PageFactory.initElements(driver, AsistenciasLocators.class);
    }

    public void closePopUp() {
        click(closePopUp);
    }

    public void selectDestination() {
        click(assistDestination);
    }

    public void selectDestinationLoc() {
        click(assistDestinationLoc);
    }

    public void selectDDate() {
        delayClick(assistDateD);
    }

    public void selectRDate() {
        delayClick(assistDateR);
    }

    public void selectOct() {
        delayClick(rightArrowDate);
        delayClick(rightArrowDate);
        delayClick(rightArrowDate);
        delayClick(rightArrowDate);
        delayClick(rightArrowDate);
        delayClick(rightArrowDate);
        delayClick(rightArrowDate);
    }

    public void selectDDay() {
        delayClick(initDate);
    }

    public void selectRDay() {
        delayClick(endDate);
    }

    public void applyDate() {
        scroll(300);
        delayClick(bttnDate);
    }

    public void selectPassengers() {
        delayClick(passengers);
    }

    public void increasePassengers() {
        delayClick(plusPassengers);
        delayClick(plusPassengers);
    }

    public void applyPassengers() {
        delayClick(bttnPassengers);
    }

    public void searchAssist() {
        delayClick(assistSearchBttn);
    }

    public void setupAssistPage() {
        closePopUp();
        selectDestination();
        selectDestinationLoc();
        selectDDate();
        selectOct();
        selectDDay();
        selectRDate();
        selectRDay();
        applyDate();
        selectPassengers();
        increasePassengers();
        applyPassengers();
        searchAssist();
    }

    public void setupAssistPageBuy() {
        closePopUp();
        selectDestination();
        selectDestinationLoc();
        selectDDate();
        selectOct();
        selectDDay();
        selectRDate();
        selectRDay();
        applyDate();
        selectPassengers();
        applyPassengers();
        searchAssist();
    }
}