package com.sofkau.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.sofkau.setup.ConstantSetup.DEMO_QA_URL;
import static com.sofkau.util.log4j.LOG4J_PROPERTIES_FILE_PATH;
import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class WebUI {

    protected WebDriver driver;


    private void setUpWebdriver() {
        // System.setProperty(WEBDRIVER_CHROME_DRIVER,WEBDRIVER_CHROME_DRIVER_PATH);
        WebDriverManager.chromedriver().setup();
    }

    private void setUpWebdriverUrl() {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(co);
        driver.get(DEMO_QA_URL);
        maximize();
    }


    protected void generalSetup() {
        setUpLog4j();
        setUpWebdriver();
        setUpWebdriverUrl();
    }

    protected void quiteDriver() {
        driver.quit();
    }

    private void maximize() {
        driver.manage().window().maximize();
    }


    private void setUpLog4j() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }


}
