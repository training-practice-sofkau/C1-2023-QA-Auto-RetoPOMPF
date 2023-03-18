package com.sofkau.setup;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static com.sofkau.setup.SetUpConstantes.ZONA_FIT_URL;
import static com.sofkau.util.Log4j.LOG4J_PROPERTIES_FILE_PATH;

public class WebUI {
    protected static WebDriver driver;
    private void setUpWebDriverChrome(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        co.addArguments("--incognito");
        driver=new ChromeDriver(co);
    }
    private void setUpWebDriverEdge(){
        WebDriverManager.edgedriver().setup();
        EdgeOptions co=new EdgeOptions();
        co.addArguments("--remote-allow-origins=*");
        co.addArguments("--incognito");
        driver=new EdgeDriver(co);
    }
    private void setUpWebDriverUrl(){
        driver.get(ZONA_FIT_URL);
        maximize();
    }
    protected void generalSetUp(String string){
        setUplog4j();
        if (string.equalsIgnoreCase("chrome"))
            setUpWebDriverChrome();
        else
            setUpWebDriverEdge();
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
