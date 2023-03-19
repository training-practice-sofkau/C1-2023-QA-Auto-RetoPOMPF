package com.sofkau.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

import static com.sofkau.setup.ConstantSetup.*;
import static com.sofkau.util.Log4j.*;
import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class WebUI {
    protected WebDriver driver;

    private void setUpWebdriver(String navegador){
        switch (navegador){
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--remote-allow-origins=*");
                co.addArguments("--incognito");
                driver = new ChromeDriver(co);
                break;
            case "Edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions ed = new EdgeOptions();
                ed.addArguments("--inprivate");
                driver = new EdgeDriver(ed);
        }
    }

    protected void generalSetup(String navegador){
        setUplog4j();
        setUpWebdriver(navegador);
        setUpWebdriverUrl();
    }
    protected void quiteDriver(){
        driver.quit();
    }
    private void maximize(){
        driver.manage().window().maximize();
    }

    private void setUpWebdriverUrl(){
        driver.get(DESPEGAR_URL);
        maximize();
    }

    private void setUplog4j(){
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }
}
