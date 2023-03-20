package com.sofkau.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static com.sofkau.setup.ConstantSetup.DESPEGAR_URL;
import static com.sofkau.util.Log4j.LOG4J_PROPERTIES_FILE_PATH;

public class WebUI {
    protected WebDriver driver;
    private void setUpWebDriver(String navegador){
        switch (navegador){
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions co=new ChromeOptions();
                co.addArguments("--remote-allow-origins=*");
                co.addArguments("--incognito");
                driver=new ChromeDriver(co);
                break;
            case "Edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions ed =new EdgeOptions();
                ed.addArguments("--inprivate");
                driver=new EdgeDriver(ed);

        }

    }
    private void setUpWebDriverUrl(){
        driver.get(DESPEGAR_URL);
        maximize();
    }
    protected void generalSetUp(String navegador){
        setUplog4j();
        setUpWebDriver(navegador);
        setUpWebDriverUrl();
    }
    protected void quitDriver(){
        driver.quit();
    }
    private void maximize(){
        driver.manage().window().maximize();
    }
    private void setUplog4j(){
        PropertyConfigurator.configure(USER_DIR.value()+LOG4J_PROPERTIES_FILE_PATH.getValue());
    }
}
