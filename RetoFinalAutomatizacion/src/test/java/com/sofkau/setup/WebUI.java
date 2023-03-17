package com.sofkau.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static com.sofkau.setup.ConstantSetup.ZONA_FIT_URL;
import static com.sofkau.util.log4j.LOG4J_PROPERTIES_FILE_PATH;

public class WebUI {
    protected WebDriver driver;


    private void setUpWebdriver() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    private void setUpWebdriverUrl() {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(co);
        driver = new EdgeDriver();
        driver.get(ZONA_FIT_URL);
        maximize();
    }

    protected void generalSetUp() {
        setUplog4j();
        setUpWebdriver();
        setUpWebdriverUrl();
    }

    protected void quiteDriver() {
        driver.quit();
    }

    private void maximize() {
        driver.manage().window().maximize();
    }

    private void setUplog4j() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }
}
