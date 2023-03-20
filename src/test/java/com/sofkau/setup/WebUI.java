package com.sofkau.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import static com.sofkau.util.Log4j.LOG4J_PROPERTIES_FILE_PATH;
import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class WebUI {
    protected WebDriver driver;

    private void setUpWebdriver(String SeleccionNavegador){


        switch ( SeleccionNavegador) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--remote-allow-origins=*");
                co.addArguments("--incognito");
                // co.addArguments("--disable-notifications");
                co.addArguments("--disable-popup-blocking");
                driver = new ChromeDriver(co);
                break;
            case "Edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions eo = new EdgeOptions();
                eo.addArguments("--remote-allow-origins=*");
                eo.addArguments("--disable-notifications");
                eo.addArguments("--disable-popup-blocking");
                driver = new EdgeDriver(eo);
                break;
            default:
                System.out.println("  Este navegador no existe :C"  );

        }


    }

    protected void generalSetup(String seleccionNavegador){
        setUplog4j();
        setUpWebdriver(seleccionNavegador);
        setUpWebdriverUrl();

    }

    protected void quiteDriver(){
        driver.quit();
    }
    private void maximize(){
        driver.manage().window().maximize();
    }

    private void setUpWebdriverUrl(){
        //driver = new ChromeDriver();
        //driver = new EdgeDriver();
        // driver.get(DEMO_QA_URL);
        driver.get(ConstantSetup.URL_BASE_DESPEGAR);
        maximize();
    }

    private void setUplog4j(){
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

    protected  String getText (WebElement webElement){
        return webElement.getText();
    }
}


