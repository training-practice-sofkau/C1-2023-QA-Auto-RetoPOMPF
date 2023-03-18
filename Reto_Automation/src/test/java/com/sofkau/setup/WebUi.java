package com.sofkau.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static com.sofkau.util.Log4j.LOG4J_PROPERTIES_FILE_PATH;


public class WebUi {

    protected WebDriver driver;

    private void setUpWebdriver() {

        WebDriverManager.chromedriver().setup();
//        WebDriverManager.edgedriver().setup();
//        System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER_PATH);

    }

    private void setUpWebdriverUrl(String URL) {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(co);
        driver.get(URL);
        maximize();
    }

    protected void generalSetUp(String URL) {
        setUplog4j();
        setUpWebdriver();
        setUpWebdriverUrl(URL);
    }

    protected void quitDriver(){
        driver.quit();
    }
    private void maximize(){
        driver.manage().window().maximize();
    }

    protected void setUplog4j() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }
}
