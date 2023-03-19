package com.sofkau.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.core.config.Property;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static com.sofkau.setup.ConstantSetup.*;
import static com.sofkau.util.Log4j.LOG4J_PROPERTIES_FILE_PATH;

public class WebUI {


    protected WebDriver driver;

    private void setUpWebDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
    }
    private void setUpWebdriverGoogle(){

        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(co);
        driver.get(ZonaFitUrl);
        maximize();
    }

    private void setUpWebdriverEdge(){

        EdgeOptions co = new EdgeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new EdgeDriver(co);
        driver.get(ZonaFitUrl);
        maximize();
    }


    protected void generalSetUpChrome() {
        setUplog4j();
        setUpWebdriverGoogle();
        setUpWebDriver();
    }
    protected void generalSetUpEdge() {
        setUplog4j();
        setUpWebdriverEdge();
        setUpWebDriver();
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