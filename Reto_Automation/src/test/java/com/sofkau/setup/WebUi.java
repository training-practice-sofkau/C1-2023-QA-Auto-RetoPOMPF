package com.sofkau.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static com.sofkau.util.Log4j.LOG4J_PROPERTIES_FILE_PATH;


public class WebUi {

    protected WebDriver driver;

//    private void setUpWebdriver() {
//
//
////        WebDriverManager.edgedriver().setup();
////        System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER_PATH);
//
//    }

    private void setUpWebdriverUrlChrome(String URL) {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--incognito");
        co.addArguments("--remote-allow-origins=*");
        co.addArguments("--disable-popup-blocking");
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability(ChromeOptions.CAPABILITY, co);
        co.merge(cap);
        driver = new ChromeDriver(co);
        driver.get(URL);
        maximize();
    }

    private void setUpWebdriverUrlEdge(String URL) {
        EdgeOptions edge = new EdgeOptions();
        edge.addArguments("--incognito");
        edge.addArguments("--remote-allow-origins=*");
        edge.addArguments("--disable-popup-blocking");
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability(EdgeOptions.CAPABILITY, edge);
        edge.merge(cap);
        driver = new EdgeDriver(edge);
        driver.get(URL);
        maximize();
    }

//    ChromeOptions options=new ChromeOptions();

    protected void generalSetUp(String URL, String nav) {
        setUplog4j();
        switch (nav) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                setUpWebdriverUrlChrome(URL);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                setUpWebdriverUrlEdge(URL);
                break;
            default:
                System.out.println("Navegador invalido");
                break;
        }


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
