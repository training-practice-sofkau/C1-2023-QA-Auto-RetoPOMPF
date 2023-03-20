package com.sofkau.pages;

import com.sofkau.util.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage extends  CommonActionOnPages{
    Person person  = new Person();
    Person person2  = new Person();
    Person person3  = new Person();

    public FormPage(WebDriver driver) {
        super(driver);

    }

    private  static final By searchButtom  = By.id("btnSearchCTA");
    private  static final By origin = By.id("txtInputOrigin_field");
    private  static final By destination =  By.id("txtInputDestination_field");
    private static final By origincity = By.id("btnItemAutoComplete_0");
    private static final By passenger = By.id("btnAddPassengerCTA");
    private static final By adult = By.id("btnPlusAdults");
    private static final By children  = By.id("btnPlusChildren");
    private static final By date = By.id("departureDate");
    private static final By numberdate1 = By.xpath("(//*[@class='sc-VuRhl eAAaRm' and text()='28'])[3]");
    private static final By numberdate2 =  By.xpath("(//*[@class='sc-VuRhl eAAaRm' and text()='30'])[3]");

    private static final By outboundflight = By.xpath("(//*[@class='card-flightstyle__WrapperInfoTop-sc__sc-16r5pdw-14 kThKNx'])[1]");
    private static final By outboundflight2 = By.xpath("(//*[@class='card-flightstyle__CardExpander-sc__sc-16r5pdw-2 eHxiMm'])[1]");
    private static final By scrollflight = By.id("bundle-detail-0-flight-select");
    private static final By scrollflight2 = By.xpath("//*[@class='body-flightsstyle__FareRegulationsContainer-sc__sc-1p74not-10 hMWpLQ']");
    private static final By chairButtom = By.id("button9");
    private static final By chair = By.xpath("(//*[@class='Seat__ButtonSeat-sc-4o384m-0 jccqap available standard'])[80]");
    private static final By chair2 = By.xpath("(//*[@class='Seat__ButtonSeat-sc-4o384m-0 jccqap available standard'])[79]");
    private static final By chair3 = By.xpath("(//*[@class='Seat__ButtonSeat-sc-4o384m-0 jccqap available standard'])[78]");
    private static final By addchair = By.id("btn-next-flight");
    private static final By suitcase= By.id("btnSeatMapLeave");
    private static final By carryon = By.id("carry-on");
    private static final By buttomconfirmed = By.id("button-cart-confirm");
    private static final By scrollcarryon= By.xpath("(//*[@class='SectionBaggage__SectionLabel-f26wk5-0 dQERWT'])[1]");

    private static final By firstname= By.id("passengerDetails-firstName-ADT_1");
    private static final By lastName = By.id("passengerDetails-lastName-ADT_1");
    private static final By dateform = By.id("passengerInfo-dateOfBirth-ADT_1");
    private static final By gender = By.id("passengerInfo-gender-ADT_1");
    private static final By gendermen = By.xpath("//*[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root sc-fzqAui xBvvB Mui-selected MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button Mui-selected']");
    private static final By cc = By.id("documentInfo-documentNumber-ADT_1");

    private static final By buttomkeep = By.id("passengerFormSubmitButtonADT_1");
    private static final By email = By.id("passengerInfo-emails-ADT_1");
    private static final By phone = By.id("passengerInfo-phones0-number-ADT_1");
    private static final By informationrepeat = By.id("repeatContactData-ADT_1");

    private static final By firstname2= By.id("passengerDetails-firstName-ADT_2");
    private static final By lastName2 = By.id("passengerDetails-lastName-ADT_2");
    private static final By dateform2 = By.id("passengerInfo-dateOfBirth-ADT_2");
    private static final By cc2 = By.id("documentInfo-documentNumber-ADT_2");
    private static final By buttomkeep2 = By.id("passengerFormSubmitButtonADT_2");
    private static final By firstname3= By.id("passengerDetails-firstName-CHD_1");
    private static final By lastName3 = By.id("passengerDetails-lastName-CHD_1");
    private static final By dateform3 = By.id("passengerInfo-dateOfBirth-CHD_1");
    private static final By cc3 = By.id("documentInfo-documentNumber-CHD_1");
    private static final By buttomkeep3 = By.id("passengerFormSubmitButtonCHD_1");
    private static final By buttomcontinue = By.xpath("(//*[@class='MuiButtonBase-root MuiButton-root MuiButton-text sc-fznyAO CWQMf MuiButton-disableElevation MuiButton-fullWidth'])[4]");
    private static final By inputloggin = By.id("form-input--alias");
    private static final By buttomfinal = By.xpath("(//*[@class='MuiButtonBase-root MuiButton-root MuiButton-text sc-fznyAO CWQMf MuiButton-disableElevation MuiButton-fullWidth'])[4]");
    private static final By loggin = By.id("header__profile__lnk-sign-in");
    private static final By textAssert = By.xpath("(//span)[3]");


    public void chooseFlight(String ida,String vuelta) throws InterruptedException {
        typeInto(origin, ida);
        arrowDown(origin);
        click(origincity);
        Wait(destination);
        typeInto(destination, vuelta);
        Wait(origincity);
        click(origincity);
        arrowDown(destination);
        click(date);
        Wait(numberdate1);
        click(numberdate1);
        Wait(numberdate2);
        click(numberdate2);
        Wait(passenger);
        click(passenger);
        Wait(adult);
        click(adult);
        Wait(children);
        click(children);
        click(searchButtom);
        cambiarPestana();
        Wait(outboundflight2);
        click(outboundflight2);
        scrollTo(scrollflight);
        Wait(scrollflight);
        click(scrollflight);
        Wait(scrollflight2);
        scrollTo(scrollflight2);
        Wait(outboundflight2);
        click(outboundflight2);
        scrollTo(scrollflight);
        Wait(scrollflight);
        click(scrollflight);
        Wait(chairButtom);
        scrollTo(chairButtom);
        Wait(chairButtom);
        click(chairButtom);
        Wait(chair);
        scrollTo(chair);
        click(chair);
        Wait(chair2);
        click(chair2);
        Wait(chair3);
        click(chair3);
        Wait(addchair);
        click(addchair);
        Wait(suitcase);
        click(suitcase);
        Wait(scrollcarryon);
        scrollTo(scrollcarryon);
        click(carryon);
        Wait(buttomconfirmed);
        click(buttomconfirmed);
    };


    public void fillMandatoryFields() {
        Wait(firstname);
        typeInto(firstname,person.getNombre());
        Wait(lastName);
        typeInto(lastName,person.getApellido());
        Wait(dateform);
        typeInto(dateform,person.getFechaNacimienti().toString());
        Wait(cc);
        typeInto(cc,person.getIdcc());
        scrollTo(buttomkeep);
        Wait(email);
        typeInto(email,person.getEmail());
        Wait(phone);
        typeInto(phone,person.getCelular());
        click(informationrepeat);
        Wait(buttomkeep);
        click(buttomkeep);
        Wait(firstname2);
        typeInto(firstname2,person2.getNombre());
        Wait(lastName2);
        typeInto(lastName2,person2.getApellido());
        Wait(dateform2);
        typeInto(dateform2,person2.getFechaNacimienti().toString());
        Wait(cc2);
        typeInto(cc2,person2.getIdcc());
        scrollTo(buttomkeep2);
        Wait(buttomkeep2);
        click(buttomkeep2);
        Wait(firstname3);
        typeInto(firstname3,person3.getNombre());
        Wait(lastName3);
        typeInto(lastName3,person3.getApellido());
        Wait(dateform3);
        typeInto(dateform3,"28-12-2015");
        Wait(cc3);
        typeInto(cc3,person3.getIdcc());
        scrollTo(buttomkeep3);
        Wait(buttomkeep3);
        click(buttomkeep3);
        Wait(buttomfinal);
        click(buttomfinal);
        Wait(loggin);
        click(loggin);
        Wait(inputloggin);
        click(inputloggin);
    }

    public String assertion1(){
        String ass = getText(textAssert);
        return ass;
    }

}
