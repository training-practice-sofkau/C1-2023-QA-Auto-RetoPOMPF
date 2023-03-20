package com.sofkau.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static com.sofkau.setup.ConstantSetup.LATAM_URL;
import static com.sofkau.util.Log4j.LOG4J_PROPERTIES_FILE_PATH;

public class WebUI {
    protected WebDriver driver;

    private void setUpWebdriverUrl(){
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*", "--incognito");
        driver = new ChromeDriver(co);
        driver.get(LATAM_URL);
        maximize();
    }

    protected void generalSetUp(){
        setUplog4j();
        setupWebdriver();
        setUpWebdriverUrl();
    }

    private void setupWebdriver(){
        WebDriverManager.chromedriver().setup();
    }

    private void maximize(){
        driver.manage().window().maximize();
    }

    protected void quiteDriver(){
        driver.quit();
    }

    private void setUplog4j(){
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }
}
