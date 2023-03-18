package com.sofka.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static com.sofka.setup.ConstantSetup.*;
import static com.sofka.util.Log4j.LOG4J_PROPERTIES_FILE_PATH;

public class WebUI {
    protected WebDriver driver;

    private void setUpWebdriver(){
        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    private void setUpWebdriverUrl(){
        EdgeOptions co = new EdgeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new EdgeDriver(co);
        driver.get(ZONA_FIT_URL);
        maximize();
    }

    private void setUpWebdriverUrl2(){
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(co);
        driver.get(ZONA_FIT_URL);
        maximize();
    }

    protected void generalSetUpGoogleChrome(){
        setUplog4j();
        setUpWebdriver();
        setUpWebdriverUrl2();
    }

    protected void generalSetUpMicrosoftEdge(){
        setUplog4j();
        setUpWebdriver();
        setUpWebdriverUrl();
    }

    protected void  quiteDriver(){
        driver.quit();
    }

    private void maximize(){
        driver.manage().window().maximize();
    }

    private void setUplog4j(){
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }
}