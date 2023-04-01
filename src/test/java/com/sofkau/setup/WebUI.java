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

    protected static final String ID = "1011334";
    protected static final String APIKEY = "519be85584de1be15e49e05d435430d6";
    protected static final String TS = "1";
    protected static final String HASH = "5dcd64e699b6a72f1e891978296aba78";

    protected WebDriver driver;

    private void setUpWebdriver(String navegadorSelect){

        switch (navegadorSelect) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--remote-allow-origins=*");
                co.addArguments("--incognito");
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

    private void setUpWebdriverUrl(){
        driver.get(DESPEGAR_URL);
        maximize();
    }


    protected void generalSetUp(String navegadorSelect){
        setUplog4j();
        setUpWebdriver(navegadorSelect);
        setUpWebdriverUrl();
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
