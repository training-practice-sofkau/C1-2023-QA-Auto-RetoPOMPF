package com.sofkau.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static com.sofkau.util.log4j.LOG4J_PROPERTIES_FILE_PATH;
import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class WebUI {

    public static final String MensajeFinal = "\\u00A1Genial! Ahora solo te falta realizar el pago.";
    protected WebDriver driver;

    private void setUpWebdriver(String SeleccionNavegador) {


        switch (SeleccionNavegador) {
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
                EdgeOptions edgeOptionso = new EdgeOptions();
                edgeOptionso.addArguments("--remote-allow-origins=*");
                edgeOptionso.addArguments("--inprivate");
                edgeOptionso.addArguments("--disable-popup-blocking");
                driver = new EdgeDriver(edgeOptionso);
                break;
            default:
                System.out.println("  Este navegador no existe :C");

        }


    }


    protected void generalSetup1( ) {
        setUpLog4j();
        setUpWebdriverUrl();

    }


    protected void generalSetup(String seleccionNavegador) {
        setUpLog4j();
        setUpWebdriver(seleccionNavegador);
        setUpWebdriverUrl();

    }

    protected void quiteDriver() {
        driver.quit();
    }

    private void maximize() {
        driver.manage().window().maximize();
    }

    private void setUpWebdriverUrl() {
        //driver = new ChromeDriver();
        // driver = new EdgeDriver();
        driver.get(ConstantSetup.URL_BASE_DESPEGAR);
        maximize();
    }


    private void setUpLog4j() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }


}
