package com.sofkau.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static com.sofkau.setup.ConstantSetup.LATAM;
import static com.sofkau.util.Log4j.LOG4J_PROPERTIES_FILE_PATH;
import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class WebUI  {
    protected WebDriver driver;
    protected WebDriver driver2;

    private void setupWebDriverUrl() {
        ChromeOptions co = new ChromeOptions();
        EdgeOptions edge = new EdgeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(co);
        //driver2 = new EdgeDriver(edge);
        driver.get(LATAM);
        //driver2.get(LATAM);
        maximize();
    }

    protected  void generalSetUp() {
        setUplog4jUrl();
        setupWebDriverUrl();
        setUpWebDriver();
    }



    private void setUpWebDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    private void setUplog4jUrl() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue() );
    }

    protected  void quitDriver() {
        driver.quit();
    }

    private void maximize() {
        //driver2.manage().window().maximize();
        driver.manage().window().maximize();
    }

}
