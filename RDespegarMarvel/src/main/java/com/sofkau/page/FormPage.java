package com.sofkau.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class FormPage extends CommonActionOnPage {
    public static ArrayList<String> esperados = new ArrayList<>();
    public static ArrayList<String> obtenidos = new ArrayList<>();
    //constructor
    public FormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    //Localizadores
    @CacheLookup
    @FindBy(xpath = "(//div[@class='card-up'])[2]")
    public WebElement form;
    @CacheLookup
    @FindBy(xpath = "(//div[text()='Elements'])")
    public WebElement elements;
    @CacheLookup
    @FindBy(xpath = "(//li[@class='btn btn-light ' and @id='item-3'])[1]")
    public WebElement practiceTable;
    @CacheLookup
    @FindBy(id = "addNewRecordButton")
    public WebElement botonAdd;
    @CacheLookup
    @FindBy(id = "firstName")
    public WebElement name;
    @CacheLookup
    @FindBy(id = "lastName")
    public WebElement lastName;
    @CacheLookup
    @FindBy(id = "userEmail")
    public WebElement email;
    @CacheLookup
    @FindBy(id = "age")
    public WebElement age;
    @CacheLookup
    @FindBy(id = "salary")
    public WebElement salary;
    @CacheLookup
    @FindBy(id = "department")
    public WebElement department;
    @CacheLookup
    @FindBy(id = "submit")
    public WebElement submit;
    public void clickForm() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("(//div[@class='card-up'])[2]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        Thread.sleep(200);
        elements.click();
        executor.executeScript("scrollBy(0,500);");
        Thread.sleep(200);
        practiceTable.click();
        Thread.sleep(200);
        botonAdd.click();
    }

    public void fillMandatoryFields(String firstName, String lastName, String age, String userEmail, String salary, String department) {
        this.name.sendKeys(firstName);
        esperados.add(firstName);
        this.lastName.sendKeys(lastName);
        esperados.add(lastName);
        this.email.sendKeys(userEmail);
        esperados.add(age);
        this.age.sendKeys(age);
        esperados.add(userEmail);
        this.salary.sendKeys(salary);
        esperados.add(salary);
        this.department.sendKeys(department);
        esperados.add(department);
        submit.click();
        resultado();
    }

    public void resultado() {
        WebElement element;
        for (int i = 22; i <=27; i++) {
            element = driver.findElement(By.xpath("(//div[@class='rt-td'])[" +i+ "]"));
            obtenidos.add(element.getText());
        }
    }
}