package com.sofkau.setup;

import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static com.sofkau.setup.ConstantSetup.APIMARVEL_URL;
import static com.sofkau.setup.ConstantSetup.DESPEGAR_URL;
import static com.sofkau.util.Log4j.LOG4J_PROPERTIES_FILE_PATH;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebUI {

    protected static final String ID = "1011334";
    protected static final String APIKEY = "519be85584de1be15e49e05d435430d6";
    protected static final String TS = "1";
    protected static final String HASH = "5dcd64e699b6a72f1e891978296aba78";

    protected WebDriver driver;

    private void setUpWebdriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        co.addArguments("--incognito");
        // co.addArguments("--disable-notifications");
        co.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(co);
    }

    private void setUpWebdriverUrl(){
        driver.get(DESPEGAR_URL);
        maximize();
    }

    private void setUpWebdriverUrlMarvel(){
        driver.get(APIMARVEL_URL);
        maximize();
    }


    protected void generalSetUp(){
        setUplog4j();
        setUpWebdriver();
        setUpWebdriverUrl();
    }

    protected void generalSetUpMarvel(){
        setUplog4j();
        setUpWebdriver();
        setUpWebdriverUrl();
    }


    private void  quiteDriver(){
        driver.quit();
    }

    private void maximize(){
        driver.manage().window().maximize();
    }

    private void setUplog4j(){
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }


}
