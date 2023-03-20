package com.sofkau.pages;

import com.sofkau.models.Passenger;
import com.sofkau.util.PassengerInstance;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightPage extends CommonActionOnPages{

    public static final String DepartureCity = "MDE";
    public static final String ArrivalCity = "CLO";

    public FlightPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Localizadores

    @CacheLookup
    @FindBy(id="txtInputOrigin_field")
    private WebElement inputOriginField;

    private By itemAutoComplete = By.id("btnItemAutoComplete_0");

    @CacheLookup
    @FindBy(id="txtInputDestination_field")
    private WebElement inputDestinationField;

    @CacheLookup
    @FindBy(id="btnAddPassengerCTA")
    private WebElement addPassengerCTA;

    @CacheLookup
    @FindBy(id="btnPlusAdults")
    private WebElement plusAdults;

    @CacheLookup
    @FindBy(id="departureDate")
    private WebElement departureDate;

    @CacheLookup
    @FindBy(id="arrivalDate")
    private WebElement arrivalDate;

    private final By departureDay = By.xpath("//div/descendant::*[580]");
    private final By arrivalDay = By.xpath("//div/descendant::*[650]");

    @CacheLookup
    @FindBy(id="WrapperCardFlight0")
    private WebElement pickFlightOne;

    private final By pickFlightTwo = By.id("WrapperCardFlight0");

    @CacheLookup
    @FindBy(id="btnSearchCTA")
    private WebElement search;

    @CacheLookup
    @FindBy(id="bundle-detail-0-flight-select")
    private WebElement basic;

    @CacheLookup
    @FindBy(id="bundle-detail-0-flight-select")
    private WebElement basic2;

    private final By seats = By.id("button9");

    private final By pickSeatsLater = By.id("btnSeatMapLeave");
    private final By later = By.id("buttonChooseLater");
    private final By btnContinue = By.id("button-cart-confirm");
    private final By firstNameP1 = By.id("passengerDetails-firstName-ADT_1");
    private final By btnP2 = By.id("accordion-passenger-ADT_2");
    private final By firstNameP2 = By.id("passengerDetails-firstName-ADT_2");
    private final By lastNameP1 = By.id("passengerDetails-lastName-ADT_1");
    private final By lastNameP2 = By.id("passengerDetails-lastName-ADT_2");
    private final By dateOfBirthP1 = By.id("passengerInfo-dateOfBirth-ADT_1");
    private final By dateOfBirthP2 = By.id("passengerInfo-dateOfBirth-ADT_2");
    private final By identificationP1 = By.id("documentInfo-documentNumber-ADT_1");
    private final By identificationP2 = By.id("documentInfo-documentNumber-ADT_2");
    private final By emailP1 = By.id("passengerInfo-emails-ADT_1");
    private final By emailP2 = By.id("passengerInfo-emails-ADT_2");
    private final By phoneP1 = By.id("passengerInfo-phones0-number-ADT_1");
    private final By phone2 = By.id("passengerInfo-phones0-number-ADT_2");
    private final By saveP1 = By.id("passengerFormSubmitButtonADT_1");
    private final By saveP2 = By.id("passengerFormSubmitButtonADT_2");
    private final By continueBtn = By.id("undefined--button-wrapper");
    private final By pse = By.id("cnt_main_login-btn");
    private final By text = By.xpath("//*[@id='form-text']/child::span[text()='Si ya eres parte de LATAM, ingresa tus datos:']");
    private PassengerInstance passengerInstance = new PassengerInstance();


    public void fillFieldsFlightOne() throws InterruptedException {

        passengerInstance.fillPassengerInfo();
        Passenger passenger1 = passengerInstance.getPassengerList().get(0);
        Passenger passenger2 = passengerInstance.getPassengerList().get(1);

        click(inputOriginField);
        typeInto(inputOriginField, DepartureCity);
        click(itemAutoComplete);
        click(inputDestinationField);
        typeInto(inputDestinationField, ArrivalCity);
        click(itemAutoComplete);
        click(departureDate);
        click(departureDay);
        click(arrivalDay);
        click(addPassengerCTA);
        click(plusAdults);
        click(search);
        changeTab();
        click(pickFlightOne);
        click(basic);
        Thread.sleep(2000);
        click(pickFlightTwo);
        click(basic2);
        Thread.sleep(2000);
        scrollDownToElement(seats);
        click(seats);
        Thread.sleep(2000);
        click(pickSeatsLater);
        click(later);
        click(btnContinue);
        Thread.sleep(2000);
        click(firstNameP1);
        typeInto(firstNameP1, passenger1.getFirstName());
        typeInto(lastNameP1, passenger1.getLastName());
        typeInto(dateOfBirthP1, passenger1.getDateOfBirth());
        typeInto(identificationP1, passenger1.getIdentification());
        typeInto(emailP1, passenger1.getEmail());
        typeInto(phoneP1, passenger1.getPhone());
        click(saveP1);
        click(firstNameP2);
        typeInto(firstNameP2, passenger2.getFirstName());
        typeInto(lastNameP2, passenger2.getLastName());
        typeInto(dateOfBirthP2, passenger2.getDateOfBirth());
        typeInto(identificationP2, passenger2.getIdentification());
        pressEnter(identificationP2);
        typeInto(emailP2, passenger2.getEmail());
        typeInto(phone2, passenger2.getPhone());
        click(saveP2);
        Thread.sleep(4000);
        click(continueBtn);
        Thread.sleep(2000);
        click(pse);
    }

    public String getElementText() throws InterruptedException {
        String message = getMessage(text);
        return message;
    }


}
